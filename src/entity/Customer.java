package entity;

public class Customer {
	private Integer id;
	private String name;
	private String password;
	private String sex;
	private String icon;
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
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getPassword() {
		return password;
	}
	public String getSex() {
		return sex;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", icon=" + icon + "]";
	}
}
