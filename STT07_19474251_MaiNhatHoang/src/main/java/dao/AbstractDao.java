//STT07_19474251_MaiNhatHoang
package dao;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoDatabase;

public class AbstractDao {
	private static final String MY_DB = "Hoang19474251";
	private MongoClient client;
	protected MongoDatabase db;

	public AbstractDao(MongoClient client) {
		super();
		this.client = client;
		db = client.getDatabase(MY_DB);
	}

	public MongoClient getClient() {
		return client;
	}

	public MongoDatabase getDb() {
		return db;
	}

}
