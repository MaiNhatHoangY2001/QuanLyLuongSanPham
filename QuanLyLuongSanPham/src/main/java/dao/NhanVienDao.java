package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernateCfg.HibernateConfig;
import model.NhanVien;

public class NhanVienDao {
	private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

	public NhanVien getNhanVien(String maNhanVien) {
		NhanVien nhanVien = null;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			nhanVien = session.get(NhanVien.class, maNhanVien);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.commit();
		}
		session.close();

		return nhanVien;

	}

	public List<NhanVien> getAllNhanVien() {
		List<NhanVien> list = new ArrayList<NhanVien>();
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery("select * from NhanVien", NhanVien.class).getResultList();

			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return list;

	}

	public boolean themNhanVien(NhanVien nhanVien) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(nhanVien);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
		session.close();
		return true;

	}
	public static void main(String[] args) {
		NhanVienDao dao = new NhanVienDao();
		NhanVien nhanVien= new NhanVien();
//		dao.getAllNhanVien().forEach(e->{
//			System.out.println(e);
//		});
	}
}
