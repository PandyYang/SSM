package pandy.test.duck;

import pandy.test.GaGaQuack;
import pandy.test.GaGaQuackBehavior;
import pandy.test.GoodFlyBehavior;
import pandy.test.QuackBehavior;

public class GreenHeadDuck extends Duck {

	public GreenHeadDuck() {
		mFlyBehavior = new GoodFlyBehavior();
		mQuackBehavior = (QuackBehavior) new GaGaQuackBehavior();
	}
	
	
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("***GreenHead***");
	}

}
