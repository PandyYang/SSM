package pandy.test.fastsort;

/**
 * @author ASUS
 *快速排序
 *找到一个关键值作为基准值 比基准值小的都在左边的序列 比基准值大的都在右边的序列
 *一般选择序列的第一个元素
 *一次循环的时候 从后往前比较 用基准值和最后一个值比较 如果比基准值小的交换位置
 *如果没有继续比较下一个 直到找到一个比基准值小的值才交换 找到这个值之后 又
 *从前往后比较 如果有比基准值大的则交换位置 如果没有继续比较下一个 直到找到比第一个基准值大的才交换
 *直到从前往后的比较所有大于从后往前的比较索引 结束第一次循环 此时对于基准值来说 左右两边就是都有序了
 *接着分别比较左右两边的序列 重复上述的循环步骤
 */
public class FastSort {
	public static void main(String[] args) {
		//初始化一个数组
		int[] a= {12,20,6,98,99,87,54,26,633};
		//定义一个开头
		int start  = 0;
		//定义数组的长度
		int end = a.length-1;
		//快速排序
		sort(a,start,end);
		//排序之后 打印出数组中的数据 现在是有序进行打印
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}
	

	public static void sort(int[] a,int low,int high) {
		int start = low;//低位开头设置为数组的首元素
		int end = high;//高位设置为数组的尾元素
		int key = a[low];//默认将第一个元素定为基准值
		
		while(end>start) {//排序的入口条件
			while(end>start&&a[end]>=key)//找到比基准元素大的值 交换到右边
				end--;
			if(a[end]<=key) {
				int temp = a[end];
				a[end] = a[start];
				a[start] = temp;
			}
			while(end>start&&a[start]<=key)//找到比基准元素小的值交换到左边
				start++;
			if(a[start]>=key) {
				int temp = a[start];
				a[start]=a[end];
				a[end]=temp;
			}
		}
		if(start>low) sort(a,low,start-1);//对基准元素的左边重复相同的步骤
		if(end<high) sort(a,end+1,high);//对右边重复相同的步骤
	}
}
