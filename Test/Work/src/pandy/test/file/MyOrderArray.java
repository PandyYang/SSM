package pandy.test.file;

public class MyOrderArray {
	private long[] arr;
	private int elements;
	public MyOrderArray() {
		arr = new long[50];
	}
	public MyOrderArray(int maxsize) {
		arr = new long[maxsize];
	}
	/*
	 * Ìí¼ÓÊý¾Ý
	 * */
	public void insert(long value) {
		int i;
		for(i=0;i<elements;i++) {
			if(arr[i]>value) {
				break;
			}
			for(int j=elements;j>i;j--) {
				arr[j] =arr[i-1];
				arr[i]=value;
				elements++;
			}
		}
	}
}
