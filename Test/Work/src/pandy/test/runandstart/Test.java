package pandy.test.runandstart;

/**
 * @author ASUS
 * ϵͳͨ�������߳����start����������һ���߳� ��ʱ���̴߳��ھ���״̬����������״̬ 
 * �����ζ����߳̿��Ա�JVM������ִ�� �ڵ���ִ�еĹ����� JVMͨ�� �����߳����run����������ʵ�ʵĲ��� ��run��������֮��  ���߳̾ͻ����
 *���ֱ�ӵ����̵߳�run�����ͻᱻ����һ����ͨ�ĺ������е��� �����л���ֻ�����߳���һ���߳� Ҳ����˵start���������첽�õ���run����
 *����ֱ�ӵ���run����ȴ��ͬ���� ���Ҳ���޷��ﵽ���̵߳�Ŀ��
 *�����̵߳�start�ķ������������ﵽ���̵߳�Ŀ�� 
 *
 */
public class Test {
	
	public static void test1() {
		System.out.println("test1 : begin");
		Thread t1 = new ThreadDemo();//����ת��
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