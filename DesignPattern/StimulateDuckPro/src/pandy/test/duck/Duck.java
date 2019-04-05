package pandy.test.duck;

import pandy.test.FlyBehavior;
import pandy.test.QuackBehavior;

public abstract class Duck {
	
	//抽象类 中的接口实例
	FlyBehavior mFlyBehavior;
	QuackBehavior mQuackBehavior;
	
	//空参构造
	public Duck() {
		
	}
	
	//抽象类中使用接口的实例调用相应的方法
	public void Fly() {
		mFlyBehavior.fly();
	}
	
	public void Quack() {
		mQuackBehavior.quack();
	}
	
	public abstract void display();
	
	
	public void SetQuackBehavior(QuackBehavior qb) {
		mQuackBehavior = qb;
	}
	
	public void setFlyBehavior(FlyBehavior fb) {
		mFlyBehavior = fb;
	}
	
	public void swim() {
		System.out.println("~~~im swim~~~~");
	}
}
