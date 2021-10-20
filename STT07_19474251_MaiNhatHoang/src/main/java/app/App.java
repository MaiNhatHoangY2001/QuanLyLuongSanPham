//STT07_19474251_MaiNhatHoang
package app;

import java.util.Map;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import dao.EmployeeDao;
import entity.Department;
import entity.Employee;
import entity.JobInfo;
///Hoagn Van CHionh
public class App {
	public static void main(String[] args) throws InterruptedException {
		MongoClient client = MongoClients.create();
		
		EmployeeDao emDao = new EmployeeDao(client);
		
//		2a)
		Employee em = new Employee("mainhathoangy2001@gmail.com", "Mai Nhat", "Male", "19474251", 
				"Hoang", "0986439506");
		
		Department department = new Department("De1", "VietNam", "FE");
		em.setDepartment(department);
		
		JobInfo jobInfo = new JobInfo("Developer", "Employee", 2000);
		em.setJobInfo(jobInfo);
		
		boolean rs = emDao.addEmployee(em);
		System.out.println(rs);
		
		
//		2b)
//		Map<String, Integer> rs = emDao.getNumOfEmpsByPosition();
//		System.out.println(rs);
		
//		2c)
//		JobInfo jobInfo = new JobInfo("Developer", "Employee", 2000);
//		boolean rs = emDao.updateJobInfo("AGME11413", jobInfo);
//		System.out.println(rs);
	}

}
