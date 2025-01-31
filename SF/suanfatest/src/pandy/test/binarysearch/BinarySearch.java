package pandy.test.binarysearch;

import java.util.Scanner;

/**二分查找法
 * @author ASUS
 *
 */
//使用递归的方法实现
public class BinarySearch {
	public static int recursionBinarySearch(int arr[],int key,int low,int high) {
		if(key<arr[0]||key>arr[high]||low>high) {
			return -1;
		}
		int middle = (low+high)/2;//初始时的中间位置
		if(arr[middle]>key) {
			return recursionBinarySearch(arr,key,low,middle-1);//如果是从小到大次序 那么向下进行查找
		}else if(arr[middle]<key) {
			return recursionBinarySearch(arr,key,middle+1,high);//向上进行查找
		}else {
			return middle;
		}
	}
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9};
		int low = 0;
		int high =arr.length-1;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入需要查找的元素索引,你可以在"+0+"到"+String.valueOf(arr.length-1)+"之间查找");
		int key = sc.nextInt();
		int result = recursionBinarySearch(arr, key, low, high)+1;
		System.out.println("根据索引值查找到的元素是:"+result);
	}
}
