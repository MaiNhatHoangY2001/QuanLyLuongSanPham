package generator;

import java.io.Serializable;
import java.util.Date;
import java.util.stream.Stream;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SinhMaHoaDonNhap implements IdentifierGenerator{
	private Date date= new Date();
	private String prefix = "HN"+date.getYear()%100 + (date.getMonth()>=10?date.getMonth():"0"+date.getMonth());
	

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String query = "SELECT maHoaDonNhap FROM HoaDonNhapHang";
		Stream<String> ids = session.createQuery(query, String.class).stream();
		Long max = ids.map(o -> o.replace(prefix, "")).mapToLong(Long::parseLong).max().orElse(0L);
		return prefix + (String.format("%03d", max + 1));
	}
}
