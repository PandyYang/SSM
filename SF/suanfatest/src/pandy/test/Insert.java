package pandy.test;

public class Insert {
	public static void main(String[] args) {
		Insert sf = new Insert();
		Integer in[] = {3,55,2,3323,56,88,64,3,0,423,555};
		sf.insertArray(in);
	}
	
	public void insertArray(Integer []in) {
		int tem=0;
		int num =0;
		int upnum=0;
		//所有的元素都将遍历循环一次
		for(int i=1;i<in.length;i++) {
			//插入排序循环的次数
			for(int j=i-1;j>=0;j--) {//插入的次序总是逐渐递减的 左边已经排好序就不用排了 
				num++;
				//按照从小大到大的顺序排序 记录移动的次数 两个相邻元素之间依次进行比较
				//以及排好的部分不用再进行比较
				//每次循环有多次移动 
				if(in[j+1]<in[j]) {
					tem=in[j+1];
					in[j+1]=in[j];
					in[j]=tem;
					upnum++;
				}
				//一次遍历结束 代表排好一个元素 比如 找出最小的值  第二小的值  直到最大的值等等
				//每次外层循环都是找到一个值
				//每次内层循环都是将这个值放到对应的位置之中
				else {
					break;
				}
			}
		}
		//排序完成后 将元素依次取出
		for(int i=0;i<in.length;i++) {
			System.out.print(in[i]);
			if(i<in.length-1) {
				System.out.print(",");
			}
		}
		System.out.println();
		System.out.println("插入排序循环的次数"+ num);
		System.out.println("移动的次数"+upnum);
		System.out.println("\n\n\n");
	}
}
