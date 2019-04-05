package pandy.test.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component("user")
	/*@Service("user")//service层
	@Controller("user")//web层
	@Repository("user")//dao层
*///以上注解的意思就是<bean name="user" class="pandy.test.bean.User">
@Scope(scopeName="singleton")//指定对象的作用范围，默认是单例singleton
public class User {
	
	/*@Value("pandy")*/
	private String name;
	
	private Integer age;
	//@Autowired//自动装配
	//问题：如果匹配到多个对象  将无法选择具体注入哪一个对象
	//通过以下语句  进行指定装配
	//@Qualifier("car2")
	
	@Resource(name="car2") //使用手动注入，指定注入那个对象 此方法是推荐方法
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
	@Value("pandy")
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@PostConstruct //在对象创建后进行调用 init-method
	public void init() {
		System.out.println("我是创建方法");
	}
	@PreDestroy //在对象销毁之前进行调用
	public void destory() {
		System.out.println("我是销毁方法");
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
	
}
