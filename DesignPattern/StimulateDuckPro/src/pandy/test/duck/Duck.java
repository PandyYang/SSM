package pandy.test.duck;

import pandy.test.FlyBehavior;
import pandy.test.QuackBehavior;

public abstract class Duck {
	
	//������ �еĽӿ�ʵ��
	FlyBehavior mFlyBehavior;
	QuackBehavior mQuackBehavior;
	
	//�ղι���
	public Duck() {
		
	}
	
	//��������ʹ�ýӿڵ�ʵ��������Ӧ�ķ���
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
