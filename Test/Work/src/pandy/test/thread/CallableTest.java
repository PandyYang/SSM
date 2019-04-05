package pandy.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author ASUS
 *Callable�������������֮���ṩһ������ֵ Runnable�޷��ṩ�������
 *Callable�е�call���������׳��쳣 Runnable�е�run���������׳��쳣
 */
public class CallableTest implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "Hello Word";
	}
	
	public static void main(String[] args) {
		
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		//�����߳� ʹ��future��������Ŀ���̵߳���call��������� ������future�����Ի�ȡ�����ʱ�� ��ǰ�߳̾ͻ����� ֪��call�����������ؽ��
		Future<String> future = threadPool.submit(new CallableTest());
		try {
			System.out.println("waiting thread to finish!");
			System.out.println(future.get());//�ȴ��߳̽������ҷ��ؽ��
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
