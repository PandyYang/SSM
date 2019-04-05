package pandy.test.ch1;

public class MyArray {
	public long[] arr;
	//表示有效的数据长度
	private int elements;
/*	public MyArray() {
		arr = new long[5];
	}
	public MyArray(int maxsize) {
		arr = new long[maxsize];
	}*/
	/*
	 * 添加数据
	 * */
	public void insert(long value) {
		
		arr[elements] = value;
		elements++;
	}
	/*
	 * 显示数据
	 * */
	public void display() {
		System.out.print("[");
		for(int i=0;i<elements;i++) {
			System.out.print("\t"+arr[i]  );
		}
		System.out.print("   ]");
	}
	/*
	 * 查找数据
	 * */
	public int search(long value) {
		int i;
		for(i=0;i<elements;i++) {
			if(value==arr[i]) {
				break;
			}
		}
		if(i==elements) {
			return -1;
		}else {
			return i;
		}
	}
	
	/*
	 * 查找数据
	 * */
	public long get(int index) throws Exception {
		if(index>=elements||index<0) {
			throw new Exception();
		}else {
			return arr[index];
		}
	}
	/*
	 * 删除数据
	 * */
	public void delete(int index) throws Exception {
		if(index>=elements||index<0) {
			throw new Exception();
		}else {
			for(int i= index;i<elements;i++) {
				arr[index] = arr[index+1];
			}
			elements--;
		}
	}
	/*
	 * 更新数据
	 * */
	public void change(int index,int newvalue) throws Exception {
		if(index>=elements||index<0) {
			throw new Exception();
		}else {
			arr[index] = newvalue;
		}
	}
	public static void main(String[] args) {
		MyArray am = new MyArray();
		am.insert(3);
		am.insert(2);
		am.insert(1);
		am.insert(5);
		am.insert(4);
		am.display();
		
	}
}
