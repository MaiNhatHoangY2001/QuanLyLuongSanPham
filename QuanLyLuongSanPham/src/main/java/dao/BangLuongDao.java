package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernateCfg.HibernateConfig;
import model.BangLuong;
import model.NhanVien;
import model.SanPham;

public class BangLuongDao {
	private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

	public BangLuong getBangLuong(String maBangLuong) {
		BangLuong bangLuong = null;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			bangLuong = session.get(BangLuong.class, maBangLuong);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.commit();
		}
		session.close();

		return bangLuong;

	}

	public BangLuong getBangLuongTheoMaNhanVien(String maNhanVien, int year, int month) {
		BangLuong bangLuong = null;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			bangLuong = session.createNativeQuery(
					"select * from BangLuong where maNhanVien = '"+maNhanVien+
					"'and YEAR(thoiGian) = "+year+" and MONTH(thoiGian) = " + month,
					BangLuong.class).getSingleResult();

			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return bangLuong;
	}

	public boolean themBangLuong(BangLuong bangLuong) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			session.save(bangLuong);
			tr.commit();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		finally {
			session.close();
		}
		return false;
	}
	
	public boolean suaBangLuong(BangLuong bangLuong) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			session.update(bangLuong);
			tr.commit();
				
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		finally {
			session.close();
		}
		return false;
	}
	
	public boolean xoaBangLuong(String id) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			session.delete(session.find(BangLuong.class, id));
			tr.commit();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		finally {
			session.close();
		}
		return false;
	}
	
	public List<BangLuong> getAllBangLuong() {
		List<BangLuong> list = new ArrayList<BangLuong>();
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery("select * from BangLuong", BangLuong.class).getResultList();

			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return list;

	}
	public static void main(String[] args) {
		BangLuongDao bangLuongDao = new BangLuongDao();
		NhanVien nhanVien = new NhanVien("NV0001");
		BangLuong bangLuong = new BangLuong(LocalDate.now(), 2, 2, 2, 2);
		bangLuong.setNhanVien(nhanVien);
//		System.out.println(bangLuongDao.themBangLuong(bangLuong));
		
		System.out.println(bangLuongDao.xoaBangLuong("BL21100003"));
		
	}
}
