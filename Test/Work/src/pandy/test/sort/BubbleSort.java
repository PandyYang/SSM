package pandy.test.sort;

import java.util.Arrays;

public class BubbleSort {
	public static void sort(long[] arr) {
		long tmp =0;
		for(int i= 0;i<arr.length-1;i++) {//冒泡次数
			for(int j=0;j<arr.length-1-i;j++) {//比较的次数
				if(arr[j]>arr[j+1]) {//加入前面的元素小于后面的元素 调换位置
					tmp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
				}
			}
		}
	}
	public static void sort1(long[] arr) {
		long tmp=0;
		for(int i= 0;i<arr.length-1;i++) {//冒泡次数
			for(int j=0;j<arr.length-1-i;j++) {//比较的次数
				if(arr[j]<arr[j+1]) {//加入前面的元素大于后面的元素 调换位置
					tmp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
				}
			}
		}
	}
	public static void main(String[] args) {
		long[] arr= new long[] {1,4,2,56,6,3,0};
		//BubbleSort.sort(arr);//正序
		BubbleSort.sort1(arr);//倒序
		System.out.println(Arrays.toString(arr));
	}
}