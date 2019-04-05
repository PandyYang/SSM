package pandy.test.sort;

import java.util.Arrays;

public class InsertSort {
	public static void sort(long[] arr) {
		long tmp = 0;
		for(int i=1;i<arr.length;i++) {
			tmp =arr[i];
			int j =i;
			while(j>0&&arr[j]>=tmp) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j]=tmp;
		}
	}
	public  static void main(String[] args) {
		long[] tmp = new long[] {1,2,5,7,4,3};
		InsertSort.sort(tmp);
		System.out.println(Arrays.toString(tmp));
	}
}
