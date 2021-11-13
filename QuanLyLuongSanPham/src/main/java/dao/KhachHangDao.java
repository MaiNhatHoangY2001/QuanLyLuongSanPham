package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernateCfg.HibernateConfig;
import model.KhachHang;

public class KhachHangDao {
	private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

	public KhachHang getKhachHang(String maKhachHang) {
		KhachHang khachHang = null;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			khachHang = session.get(KhachHang.class, maKhachHang);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.commit();
		}
		session.close();

		return khachHang;

	}

	public List<KhachHang> getAllKhachHang() {
		List<KhachHang> list = new ArrayList<KhachHang>();
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery("select * from KhachHang", KhachHang.class).getResultList();

			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return list;

	}

	public boolean themKhachHang(KhachHang khachHang) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(khachHang);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
		session.close();
		return true;

	}

	public KhachHang timKiemKhachHangBangSdt(String sdt) {
		KhachHang khachHang = null;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			khachHang = session.createNativeQuery("SELECT        * FROM            KhachHang where sDT='" + sdt + "'",
					KhachHang.class).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return khachHang;
	}

	public static void main(String[] args) {
		KhachHangDao dao = new KhachHangDao();
		KhachHang khachHang = new KhachHang("Hoang Van Hoang", "Go vap", "099999998");
		dao.themKhachHang(khachHang);

//		dao.getAllKhachHang().forEach(e->{
//			System.out.println(e);
//		});
	}
}
