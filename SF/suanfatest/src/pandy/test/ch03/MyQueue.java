package pandy.test.ch03;
/*
 * 列队类
 */
public class MyQueue {
	//底层使用数组
	private long[] arr;
	//有效数据的大小
	private int elements;
	//队头
	private int front;
	//队尾
	private int end;
	
	/*
	 * 默认的构造方法
	 * 
	 */
	public MyQueue() {
		arr=new long[10];
		elements = 0;
		front = 0;
		end = -1;
	}
	/*
	 * 带参数的构造方法 参数为数组的大小
	 */
	public MyQueue(int maxsize) {
		arr = new long[maxsize];
		elements = 0;
		front = 0;
		end = -1;
	}
	/*
	 * 添加数据 在队列中从队尾插入数据
	 * */
	public void insert(long value) {
		if(end==arr.length-1)//插入数据到达末尾的时候 重新从头开始插入
			end=-1;
		arr[++end] = value;
		elements++;
	}
	/*
	 * 删除数据 从队头进行删除
	 */
	public long remove() {
		long value = arr[front++];//需要删除的数据超出了数组的长度 将其重置为0
		if(front==arr.length)
			front=0;
		elements--;
		return value;//上面定义全局变量  确保每次修改之后 都能同步到整个队列之中
	}
	/*
	 * 查看数据 从队头查看
	 * */
	public long peek() {
		return arr[front];
	}
	/*
	 * 判断是否为空
	 */
	public boolean isEmpty() {
		return elements == 0;
	}
	/*
	 * 判断是否满了
	 */
	public boolean isFull() {
		return elements==arr.length;
	}
}
