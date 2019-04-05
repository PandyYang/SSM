package pandy.test.thread;

//java实现多线程的方式1
/*public class MyThread extends Thread {
	public void run() {
		System.out.println("Thread body");
	}
}*/


//java实现多线程的方式2
public class MyThread implements Runnable {
	public void run() {
		System.out.println("Thread body");
	}
}