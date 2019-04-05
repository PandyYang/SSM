package pandy.test.ch03;

public class TestMyQueue {
	public static void main(String[] args) {
		MyQueue mq = new MyQueue(5);
		mq.insert(1);
		mq.insert(2);
		mq.insert(3);
		mq.insert(4);
		mq.insert(5);
		System.out.println(mq.peek());
		while(!mq.isEmpty())
			System.out.println(mq.remove());
		System.out.println(mq.isFull());
		System.out.println(mq.isEmpty());
	}
}
