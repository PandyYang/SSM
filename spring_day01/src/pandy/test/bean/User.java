package pandy.test.bean;

public class User {
	
	
	public User(String name, Car car) {
		System.out.println("函数构造");
		this.name = name;
		this.car = car;
	}
	public User(Integer name, Car car) {
		System.out.println("函数构造");
		this.name = name+"";
		this.car = car;
	}
	public User(Car car, String name) {
		System.out.println("函数构造");
		this.name = name;
		this.car = car;
	}
	public User() {
		System.out.println("User对象空参构造方法！！！");
		// TODO Auto-generated constructor stub
	}
	private String name;
	private Integer age;
	private Car car;
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
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
	public void init() {
		System.out.println("我是创建方法");
	}
	public void destory() {
		System.out.println("我是销毁方法");
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
	
}
