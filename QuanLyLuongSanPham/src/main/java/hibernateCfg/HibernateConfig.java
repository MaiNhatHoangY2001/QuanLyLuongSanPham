package hibernateCfg;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import model.BangLuong;
import model.ChiTietHoaDonBan;
import model.ChiTietHoaDonBanPK;
import model.ChiTietHoaDonNhap;
import model.ChiTietHoaDonNhapPK;
import model.HoaDonBanHang;
import model.HoaDonNhapHang;
import model.KhachHang;
import model.NhanVien;
import model.SanPham;
import model.TaiKhoan;

public class HibernateConfig {
	public static SessionFactory sessionFactory = null;
	private static HibernateConfig instance = new HibernateConfig();

	public static HibernateConfig getInstance() {
		return instance;
	}

	public HibernateConfig() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

		Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(BangLuong.class)
				.addAnnotatedClass(ChiTietHoaDonBan.class).addAnnotatedClass(ChiTietHoaDonNhap.class)
				.addAnnotatedClass(ChiTietHoaDonBanPK.class).addAnnotatedClass(ChiTietHoaDonNhapPK.class)
				.addAnnotatedClass(HoaDonBanHang.class).addAnnotatedClass(HoaDonNhapHang.class)
				.addAnnotatedClass(KhachHang.class).addAnnotatedClass(NhanVien.class).addAnnotatedClass(SanPham.class)
				.addAnnotatedClass(TaiKhoan.class).getMetadataBuilder().build();
		if (sessionFactory == null) {
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void main(String[] args) {
		SessionFactory factory= HibernateConfig.getInstance().getSessionFactory();
		Session session=factory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
	}
}
