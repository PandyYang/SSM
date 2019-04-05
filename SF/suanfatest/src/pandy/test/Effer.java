package pandy.test;

import java.util.Arrays;

/**
 * @author ASUS
 *冒泡排序
 * 插入排序和冒泡排序在平均和最坏情况下的时间复杂度都是O(n^2)，最好情况下都是O(n)，空间复杂度是O(1)
 */
public class Effer {
	public void efferArray(Integer []in) {
		int tem=0;
		int num = 0;
		int upnum =0;
		//是当前元素与别的还没有排好的部分进行部分 
		//左边的部分已经按照特定的顺序排好 所以每次的外层循环会让内层循环减少相应的次数
		for(int i=0;i<in.length;i++) {
			for(int j=0;j<in.length-1-i;j++) {
				if(in[j]>in[j+1]) {
					tem=in[j+1];
					in[j+1]=in[j];
					in[j]=tem;
				}
			}
		}
	}
	public static void main(String[] args) {
		Effer ea = new Effer();
		Integer in[] = {1,6,3,9,4,99,5};
		ea.efferArray(in);
		System.out.println(Arrays.toString(in));
	}
}
