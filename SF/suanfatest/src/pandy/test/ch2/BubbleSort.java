package pandy.test.ch2;

import java.util.Arrays;

/**
 * @author ASUS
 *ð������
 */
public class BubbleSort {
	public static void sort(long[] arr) {
		long temp;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					temp=arr[j];
					arr[j]=arr[j+1];//��С�ķ���ǰ��  ��С�����������
					arr[j+1]=temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		long[] arr=new long[] {1,3,2,8,4,6,9};
		BubbleSort.sort(arr);
		System.out.println(Arrays.toString(arr));
		}
	}
