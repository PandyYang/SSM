package pandy.test.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ASUS
 *Lock的实现主要有 ReentrantLock ReadLock和writeLock
 *ReentrantLock位于并发类包中的locks子包下 它实现了lock的接口 他是可序列化的  序列的意思就是将字符流转化成可以自由传输的字节流
 *反序列化其实是以上过程可逆 它还有一个AbstractQueuedSynchronizer的引用 默认支持两种模式 一种是公平锁 一种是非公平锁 默认是非公
 *下面的lock方法会忽略interrupt引发的异常
 */
public class Test {
	public static void main(String[] args) throws InterruptedException {
		final Lock lock = new ReentrantLock();
		lock.lock();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					lock.lockInterruptibly();
				}catch(InterruptedException e) {
					System.out.println("interrupted");
				}
			}
			
		});
		t1.start();
		t1.interrupt();
		Thread.sleep(1);
	}
}
