package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernateCfg.HibernateConfig;
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
	
	public boolean capNhatSanPham(SanPham sp) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			session.update(sp);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		
		return false;
	}
	
	public boolean xoaSanPhamTheoMa(String maSPCanXoa) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.delete(session.find(SanPham.class, maSPCanXoa));
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
		session.close();
		return true;
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
	
	public List<SanPham> getAllSanPham() {
		List<SanPham> list = new ArrayList<SanPham>();
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery("select * from SanPham", SanPham.class).getResultList();

			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return list;
	}

}
