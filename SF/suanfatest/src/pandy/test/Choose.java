package pandy.test;

public class Choose {
	public void chooseArray(Integer[] in) {
		int tem=0;
		int num =0;
		int upnum=0;
		int k = 0;
		for(int i=0;i<in.length;i++) {//从数组中依次拿出每个元素
			k = i;
			//从数据中取出每个元素  依次与外层循环中取出的比较 
			//已经取过的不必再取 两个元素之间两两比较 一层循环之后势必会选出当前层中的  数字中的最小的元素
			for(int j=k+1;j<in.length-1;j++) {
				if(in[j]<in[k]){//每次遇见一个比数组左边的值更小的值那么交换位置 直到指针移动到数组的右边
					k=j;
				} 
				num++;
				if(i!=k) {//也就是说此时的k不是i的本值
					tem=in[i];
					in[i]=in[k];
					in[k]=tem;
					upnum++;
				}
			}
		}
		for(int i=0;i<in.length;i++) {
			System.out.print(in[i]);
			if(i<in.length-1) {
				System.out.print(",");
			}
		}
		//循环与移动次数在此
	}
	public static void main(String[] args) {
		Choose ca = new Choose();
		Integer in[] = {1,3,7,120,9,44,2,323};
		ca.chooseArray(in);
	}
}
