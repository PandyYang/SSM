package pandy.test.sort;

import java.util.Arrays;

public class BubbleSort {
	public static void sort(long[] arr) {
		long tmp =0;
		for(int i= 0;i<arr.length-1;i++) {//ð�ݴ���
			for(int j=0;j<arr.length-1-i;j++) {//�ȽϵĴ���
				if(arr[j]>arr[j+1]) {//����ǰ���Ԫ��С�ں����Ԫ�� ����λ��
					tmp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
				}
			}
		}
	}
	public static void sort1(long[] arr) {
		long tmp=0;
		for(int i= 0;i<arr.length-1;i++) {//ð�ݴ���
			for(int j=0;j<arr.length-1-i;j++) {//�ȽϵĴ���
				if(arr[j]<arr[j+1]) {//����ǰ���Ԫ�ش��ں����Ԫ�� ����λ��
					tmp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
				}
			}
		}
	}
	public static void main(String[] args) {
		long[] arr= new long[] {1,4,2,56,6,3,0};
		//BubbleSort.sort(arr);//����
		BubbleSort.sort1(arr);//����
		System.out.println(Arrays.toString(arr));
	}
}