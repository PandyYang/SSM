package pandy.test.FastSort;

public class FastSort {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		int[] a = {12,55,34,23,32,424,322,3323,232,3};
		int start = 0;
		int end = a.length-1;
		sort(a,start,end);
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void sort(int[] a,int low,int high) {
		int start = low;
		int end = high;
		int key = a[low];//将最左边的元素作为每次需要比较的值
		
		
		while(end>start) {
			//从后向前比较
			while(end>start&&a[end]>=key)
				end--;
			if(a[end]<=key) {
				int temp = a[end];
				a[end] = a[start];
				a[start] = temp;
			}
			//从前往后比较
			while(end>start&&a[start]<=key)
				start++;
			if(a[start]>=key) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
			}
			//此时结束第一次循环 关键值的位置已经确定 左边的值都比关键值小
			//右边的值都比关键值大 但是左右两边的顺序还是有可能不一样
			//现在进行递归调用
			if(start>low) sort(a,low,start-1);
			if(end<high) sort(a,end+1,high);
		}
	}
}
