package pandy.test.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//@Controler @Service @Responsity与Component的用法一模一样 唯一的区别就是不同的名称表示不同的域

@Component("car2")
public class Car {
	@Value("Divo")
	private String name;
	@Value("black")
	private String color;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + "]";
	}
	
	
}	
