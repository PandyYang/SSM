package pandy.test.lock;

public class Test1 {
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			System.out.println("��ӡ"+i);
			try {
				Thread.sleep(2000);//�߳�˯��2��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}