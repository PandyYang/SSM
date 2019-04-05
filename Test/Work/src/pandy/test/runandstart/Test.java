package pandy.test.runandstart;

/**
 * @author ASUS
 * 系统通过调用线程类的start方法来启动一个线程 此时的线程处于就绪状态而不是运行状态 
 * 这就意味这个线程可以被JVM来调度执行 在调度执行的过程中 JVM通过 调用线程类的run方法来进行实际的操作 当run方法结束之后  该线程就会结束
 *如果直接调用线程的run方法就会被当成一个普通的函数进行调用 程序中还是只有主线程这一个线程 也就是说start方法可以异步得调用run方法
 *但是直接调用run方法却是同步的 因此也就无法达到多线程的目的
 *调用线程的start的方法可以真正达到多线程的目的 
 *
 */
public class Test {
	
	public static void test1() {
		System.out.println("test1 : begin");
		Thread t1 = new ThreadDemo();//向上转型
		t1.start();
		System.out.println("test1 : end");
	}
	public static void test2() {
		System.out.println("test2 : begin");
		Thread t1 = new ThreadDemo();
		t1.run();
		System.out.println("test2 : end");
}
	public static void main(String args[]) {
		test1();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		test2();
	}
}