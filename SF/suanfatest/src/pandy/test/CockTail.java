package pandy.test;

import java.util.Arrays;

/**
 * @author ASUS
 *	涟漪排序
 *确保左右排序的同时进行 就必须确保
 *1.数组的长度不能发生变化
 *2.在一次循环中先排左边 然后排右边 两个方向的排序在while循环中处于同一优先级上
 *3.两者同时向中间逼近 最后一个数字 肯定会被左边或者右边排走 要么就是不用排 但是程序在这一步还是要进行运算判断的
 */
public class CockTail {
	public static void main(String[] args) {
		int[] arr = {5,34,88,2,344,999,746,35,3,43,4,36};
		CockTail.cockTail_sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void cockTail_sort(int[] arr) {
		int i,left=0;
		int right = arr.length-1;
		int temp;
		while(left<right) {
			//从左边的排序开始 只要左边小于右边 i+ 然后判断大小关系 将左边排好
			for(i=left;i<right;i++) 
				if(arr[i]>arr[i+1]) {
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				}
				//循环中左边累加的时候 要将右边累减  确保数组的长度不变
			right--;
			for(i=right;i>left;i--) 
				if(arr[i-1]>arr[i]) {
					temp = arr[i-1];
					arr[i-1] = arr[i];
					arr[i] = temp;
				}
			left++;
		}
	}
}
