package pandy.test.ch03;

public class MyStack {
	//�ײ��ʵ����һ������
	private long[] arr;
	private int top;
	/*
	 * Ĭ�ϵĹ��췽��
	 */
	public MyStack() {
		arr = new long[10];
		top = -1;//Ĭ�ϵ���û�����ݵ�
	}
	/*
	 * �������Ĺ��췽�� ����������ĳ�ʼ����С
	 * */
	public MyStack(int maxsize) {
		arr=new long[maxsize];
		top=-1;
	}
	/*
	 * ��ջ���������
	 */
	public void push(int value) {
		arr[++top] = value;
	}
	/*
	 * �Ƴ�����
	 */
	public long pop() {
		return arr[top--];
	}
	/* 
	 * �鿴����
	 */
	public long peek() {
		return arr[top];
	}
	/*
	 * �ж��Ƿ��ǿ�
	 */
	public boolean isEmpty() {
		return top==-1;//Ϊ����true  ����Ļ�����false
	}
	/*
	 * �ж��Ƿ�����
	 */
	public boolean isFull() {
		return top==arr.length-1;
	}
	/*
	 * 
	 */
}
