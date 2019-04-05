package pandy.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author ASUS
 *Callable可以在任务结束之后提供一个返回值 Runnable无法提供这个功能
 *Callable中的call方法可以抛出异常 Runnable中的run方法不能抛出异常
 */
public class CallableTest implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "Hello Word";
	}
	
	public static void main(String[] args) {
		
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		//启动线程 使用future来见监视目标线程调用call方法的情况 当调用future方法以获取结果的时候 当前线程就会阻塞 知道call方法结束返回结果
		Future<String> future = threadPool.submit(new CallableTest());
		try {
			System.out.println("waiting thread to finish!");
			System.out.println(future.get());//等待线程结束并且返回结果
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
