package pandy.test.sort;

import java.util.Arrays;
//找出第一小和第二小  然后进行比较
public class ChooseSort {
	public static void chooseSort(long[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int minIndex = i;
			for(int j=minIndex+1;j<arr.length;j++) {
				if(arr[j]<arr[minIndex]) {
					minIndex = j;
				}
			}
			int temp = (int) arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex] = temp;
		}
	}
	public static void main(String[] args) {
		long[] arr = new long[] {1,9,8,5,0,3,6};
		ChooseSort.chooseSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
