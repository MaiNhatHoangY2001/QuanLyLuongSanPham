//STT07_19474251_MaiNhatHoang
package entity;

public class JobInfo {
	private String jobTitle;
	private String position;
	private double salary;

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public JobInfo(String jobTitle, String position, double salary) {
		super();
		this.jobTitle = jobTitle;
		this.position = position;
		this.salary = salary;
	}

	public JobInfo() {
		super();
	}

	@Override
	public String toString() {
		return "JobInfo [jobTitle=" + jobTitle + ", position=" + position + ", salary=" + salary + "]";
	}

}
