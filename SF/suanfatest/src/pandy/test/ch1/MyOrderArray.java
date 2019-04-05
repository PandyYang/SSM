package pandy.test.ch1;

public class MyOrderArray {
	private long[] arr;
	//��ʾ��Ч�����ݳ���
	private int elements;
	public MyOrderArray() {
		arr = new long[5];
	}
	public MyOrderArray(int maxsize) {
		arr= new long[maxsize];
	}
	/*
	 * ������� װֵ �ı��С
	 * */
	public void insert1(long value1) {
		arr[elements] = value1;
		elements++;
	}
	public void insert(long value) {
		int i;
		for(i = 0; i <elements;i++) {
			if(arr[i]>value)
				break;
			for(int j=elements;j>i;j--) {
				arr[j] = arr[j-1];
			}
			arr[i]=value;
			elements++;
		}
		/*
		 * ��ʾ����
		 * */
	}
	public void display() {
		System.out.print("[");
		for(int i =0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("]");
	}
	public static void main(String[] args) {
		MyOrderArray mo = new MyOrderArray();
		mo.insert1(1);
		mo.insert1(2);
		mo.insert1(2);
		mo.display();
	}
}	
