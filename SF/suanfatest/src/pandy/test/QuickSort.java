package pandy.test;
/*
 * 快速排序
 */
public class QuickSort {
	
	public static void main() {
		long[] arr = new long[10];
		for(int i = 0;i<10;i++) {
			arr[i]=(long) (Math.random()*99);
		}
		QuickSort.partition(arr, 0, arr.length-1, 45);
		for(long t :arr) {
			System.out.println(t);
		}
	}

	/*
	 * 划分数组
	 * 定义一个数组 指定起始位置 末尾位置 以及关键字
	 */
	public static  void partition(long arr[],int left,int right,int point) {
		int leftPtr = left-1;
		int rightPtr = right+1;
		while(true) {
			//在循环体中直接进行条件的判断以及新值的赋予
			while(leftPtr<rightPtr && arr[++leftPtr]<point);
			//
			while(rightPtr>leftPtr && arr[--rightPtr]>point);
			if(leftPtr>=rightPtr) {
				return;
			}else {
				long temp = arr[leftPtr];
				arr[leftPtr] = arr[rightPtr];
				arr[rightPtr]=temp;
			}
		}
		
	}
}
