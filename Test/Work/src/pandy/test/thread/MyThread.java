package pandy.test.thread;

//javaʵ�ֶ��̵߳ķ�ʽ1
/*public class MyThread extends Thread {
	public void run() {
		System.out.println("Thread body");
	}
}*/


//javaʵ�ֶ��̵߳ķ�ʽ2
public class MyThread implements Runnable {
	public void run() {
		System.out.println("Thread body");
	}
}