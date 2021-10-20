//STT07_19474251_MaiNhatHoang
package dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import org.bson.Document;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.google.gson.Gson;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;

import entity.Department;
import entity.Employee;
import entity.JobInfo;

public class EmployeeDao extends AbstractDao {

	private static final Gson GSON = new Gson();
	private MongoCollection<Document> emCollection;

	public EmployeeDao(MongoClient client) {
		super(client);
		emCollection = db.getCollection("employees");
	}

	// + addEmployee(employee: Employee) : boolean
	public boolean addEmployee(Employee employee) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);

		AtomicBoolean rs = new AtomicBoolean(false);

		String json = GSON.toJson(employee);
		Document doc = Document.parse(json);
		Document docDe = (Document) doc.get("department");
		Document docJob = (Document) doc.get("jobInfo");
		
		doc.append("_id", employee.getId());
		doc.remove("id");
		doc.remove("phone");
		doc.append("phoneNumber", employee.getPhone());
		doc.remove("jobInfo");
		doc.append("jobInfo", docJob);
		doc.append("departmentID", docDe.getString("id"));
		doc.remove("department");

		emCollection.insertOne(doc).subscribe(new Subscriber<InsertOneResult>() {

			public void onSubscribe(Subscription s) {
				s.request(1);
			}

			public void onNext(InsertOneResult t) {
				if (t.getInsertedId() != null) {
					rs.set(true);
				}
			}

			public void onError(Throwable t) {
				t.printStackTrace();
			}

			public void onComplete() {
				latch.countDown();
			}
		});

		latch.await();
		return rs.get();

	}

//	+ getNumOfEmpsByPosition(): Map<String, Integer> 
//Hoang19474251> db.employees.aggregate([{$group:{_id:'$jobInfo.position', num:{$sum:1}}}])	
	public Map<String, Integer> getNumOfEmpsByPosition() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);

		Map<String, Integer> map = new HashMap<String, Integer>();

		emCollection.aggregate(Arrays.asList(Document.parse("{$group:{_id:'$jobInfo.position', num:{$sum:1}}}")))
				.subscribe(new Subscriber<Document>() {

					private Subscription s;

					@Override
					public void onSubscribe(Subscription s) {
						this.s = s;
						this.s.request(1);
					}

					@Override
					public void onNext(Document t) {

						String pos = t.getString("_id");
						Integer num = t.getInteger("num");
						map.put(pos, num);
						this.s.request(1);
					}

					@Override
					public void onError(Throwable t) {
						t.printStackTrace();
					}

					@Override
					public void onComplete() {
						latch.countDown();
					}
				});

		latch.await();
		return map;

	}

	// + updateJobInfo (employeeId: String, newValue: JobInfo): boolean
	public boolean updateJobInfo(String employeeId, JobInfo newValue) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);
		AtomicBoolean rs = new AtomicBoolean(false);

		String json = GSON.toJson(newValue);
		Document doc = Document.parse(json);

		emCollection.updateOne(Filters.eq("_id", employeeId), Updates.set("jobInfo", doc))
				.subscribe(new Subscriber<UpdateResult>() {

					@Override
					public void onSubscribe(Subscription s) {
						s.request(1);
					}

					@Override
					public void onNext(UpdateResult t) {
						if (t.getModifiedCount() > 0) {
							rs.set(true);
						}
					}

					@Override
					public void onError(Throwable t) {
						t.printStackTrace();
					}

					@Override
					public void onComplete() {
						latch.countDown();
					}
				});

		latch.await();
		return rs.get();

	}
}
