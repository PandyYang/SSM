package pandy.test.ch03;

public class MyStack {
	//底层的实现是一个数组
	private long[] arr;
	private int top;
	/*
	 * 默认的构造方法
	 */
	public MyStack() {
		arr = new long[10];
		top = -1;//默认的是没有数据的
	}
	/*
	 * 带参数的构造方法 参数是数组的初始化大小
	 * */
	public MyStack(int maxsize) {
		arr=new long[maxsize];
		top=-1;
	}
	/*
	 * 向栈中添加数据
	 */
	public void push(int value) {
		arr[++top] = value;
	}
	/*
	 * 移除数据
	 */
	public long pop() {
		return arr[top--];
	}
	/* 
	 * 查看数据
	 */
	public long peek() {
		return arr[top];
	}
	/*
	 * 判断是否是空
	 */
	public boolean isEmpty() {
		return top==-1;//为空是true  否则的话就是false
	}
	/*
	 * 判断是否已满
	 */
	public boolean isFull() {
		return top==arr.length-1;
	}
	/*
	 * 
	 */
}
