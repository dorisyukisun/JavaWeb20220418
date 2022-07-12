package jdbc;

import java.util.Date;

public class User {

	private Integer id;
	private String name;
	private Integer age;
	private Date createTime;

	public User() {
		
	}

	public User(Integer id, String name, Integer age, Date createTime) {
		 
		this.id = id;
		this.name = name;
		this.age = age;
		this.createTime = createTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", createTime=" + createTime + "]";
	}
	
	
}
