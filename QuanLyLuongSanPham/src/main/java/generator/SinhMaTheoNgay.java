package generator;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.stream.Stream;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;

public class SinhMaTheoNgay implements IdentifierGenerator, Configurable {
	private String prefix;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		LocalDate date = LocalDate.now();
		String s = "" + date.getYear() % 100
				+ (date.getMonthValue() >= 10 ? date.getMonthValue() : "0" + date.getMonthValue());
		String query = String.format("select %s from %s",
				session.getEntityPersister(object.getClass().getName(), object).getIdentifierPropertyName(),
				object.getClass().getSimpleName());

		Stream<String> ids = session.createQuery(query).stream();
		Long max = ids.map(o -> o.replace(o.substring(0,5), "")).mapToLong(Long::parseLong).max().orElse(0L);

		return prefix + s + (String.format("%04d", max + 1));
	}

	@Override
	public void configure(org.hibernate.type.Type type, java.util.Properties params, ServiceRegistry serviceRegistry)
			throws org.hibernate.MappingException {
		// TODO Auto-generated method stub
		prefix = params.getProperty("prefix");
	}

}
