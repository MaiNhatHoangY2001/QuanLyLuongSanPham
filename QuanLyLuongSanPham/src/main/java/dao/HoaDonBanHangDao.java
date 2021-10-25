package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernateCfg.HibernateConfig;
import model.HoaDonBanHang;

public class HoaDonBanHangDao {
	private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

	public HoaDonBanHang getHoaDonBanHang(String maHoaDon) {
		HoaDonBanHang hoaDonBanHang = null;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			hoaDonBanHang = session.get(HoaDonBanHang.class, maHoaDon);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.commit();
		}
		session.close();

		return hoaDonBanHang;

	}

	public List<HoaDonBanHang> getAllHoaDonBanHang() {
		List<HoaDonBanHang> list = new ArrayList<HoaDonBanHang>();
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery("select * from HoaDonBanHang", HoaDonBanHang.class).getResultList();

			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return list;

	}
}
