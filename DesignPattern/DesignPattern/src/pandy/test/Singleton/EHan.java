package pandy.test.Singleton;

/**
 * @author ASUS
 *����ģʽ����ʵ���������ʱ����ͬ��Ϊ������������������
 *�����Ƕ�������ģʽ
 *���ڵ����౻����ʱ,��ʵ����һ�����󽻸��Լ�������
 *�������ڵ���ȡ��ʵ��������ʱ��Ż�ʵ��������
 */
public class EHan {
	//ʵ�������� �ڵ�������ص�ʱ��ͽ���ʵ����
	private static EHan eHan = new EHan();
	//�ղι���
	private EHan() {}
	
	public static EHan getInstance() {
		return eHan;
	}
}
