//STT07_19474251_MaiNhatHoang
package entity;

import org.bson.codecs.pojo.annotations.BsonId;

public class Department {
	@BsonId
	private String id;
	private String location;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department(String id, String location, String name) {
		super();
		this.id = id;
		this.location = location;
		this.name = name;
	}

	public Department() {
		super();
	}

	public Department(String id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", location=" + location + ", name=" + name + "]";
	}

}
