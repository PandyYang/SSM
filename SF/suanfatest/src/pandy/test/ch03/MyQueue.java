package pandy.test.ch03;
/*
 * �ж���
 */
public class MyQueue {
	//�ײ�ʹ������
	private long[] arr;
	//��Ч���ݵĴ�С
	private int elements;
	//��ͷ
	private int front;
	//��β
	private int end;
	
	/*
	 * Ĭ�ϵĹ��췽��
	 * 
	 */
	public MyQueue() {
		arr=new long[10];
		elements = 0;
		front = 0;
		end = -1;
	}
	/*
	 * �������Ĺ��췽�� ����Ϊ����Ĵ�С
	 */
	public MyQueue(int maxsize) {
		arr = new long[maxsize];
		elements = 0;
		front = 0;
		end = -1;
	}
	/*
	 * ������� �ڶ����дӶ�β��������
	 * */
	public void insert(long value) {
		if(end==arr.length-1)//�������ݵ���ĩβ��ʱ�� ���´�ͷ��ʼ����
			end=-1;
		arr[++end] = value;
		elements++;
	}
	/*
	 * ɾ������ �Ӷ�ͷ����ɾ��
	 */
	public long remove() {
		long value = arr[front++];//��Ҫɾ�������ݳ���������ĳ��� ��������Ϊ0
		if(front==arr.length)
			front=0;
		elements--;
		return value;//���涨��ȫ�ֱ���  ȷ��ÿ���޸�֮�� ����ͬ������������֮��
	}
	/*
	 * �鿴���� �Ӷ�ͷ�鿴
	 * */
	public long peek() {
		return arr[front];
	}
	/*
	 * �ж��Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return elements == 0;
	}
	/*
	 * �ж��Ƿ�����
	 */
	public boolean isFull() {
		return elements==arr.length;
	}
}
