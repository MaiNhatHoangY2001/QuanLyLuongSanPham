//STT07_19474251_MaiNhatHoang
package entity;

import org.bson.codecs.pojo.annotations.BsonId;

public class Employee {
	
	private String email;
	private String firstName;
	private String lastName;
	private String gender;
	@BsonId
	private String id;
	
	private String phone;
	
	private JobInfo jobInfo;
	private Department department;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public JobInfo getJobInfo() {
		return jobInfo;
	}
	public void setJobInfo(JobInfo jobInfo) {
		this.jobInfo = jobInfo;
	}
	public Employee(String email, String firstName, String gender, String id, String lastName, String phone) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.gender = gender;
		this.id = id;
		this.lastName = lastName;
		this.phone = phone;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [email=" + email + ", firstName=" + firstName + ", gender=" + gender + ", id=" + id
				+ ", lastName=" + lastName + ", phone=" + phone + ", jobInfo=" + jobInfo + ", departmentID=" + department.getId()
				+ "]";
	} 
	
	
}
