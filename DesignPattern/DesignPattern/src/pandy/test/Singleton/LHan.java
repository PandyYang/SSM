package pandy.test.Singleton;

/**
 * @author ASUS
 *��������ʽ���� 
 *ֻ���ڵ���ȡ��ʵ��������ʱ��Ż�ʵ��������
 */
public class LHan {
	private static LHan lHan;
	private LHan() {}
	public static synchronized LHan getInstance() {
		if(lHan==null) {
			lHan = new LHan();
		}
		return lHan;
	}
}
