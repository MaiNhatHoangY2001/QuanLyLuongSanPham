package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernateCfg.HibernateConfig;
import model.NhanVien;
import model.SanPham;

public class SanPhamDao {
	private SessionFactory sessionFactory = null;

	public SanPhamDao() {
		sessionFactory = HibernateConfig.getInstance().getSessionFactory();
	}

	public boolean themSanPham(SanPham sanPham) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			session.save(sanPham);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
	}
	public SanPham getSanPham(String id) {
		SanPham sanPham;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			sanPham=session.find(SanPham.class, id);
			tr.commit();
			return sanPham;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public static void main(String[] args) {
		
		SanPham pham= new SanPham("Iphone 14", 499999999, "Chinh nghèo", "PK", LocalDate.of(2020,9, 23));
		SanPhamDao sanPhamDao= new SanPhamDao();
		
//		System.out.println(sanPhamDao.getNhanVien("SP21100001"));
		System.out.println(sanPhamDao.themSanPham(pham));
	}

}
