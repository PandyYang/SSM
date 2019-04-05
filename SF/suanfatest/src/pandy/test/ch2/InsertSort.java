package pandy.test.ch2;

/**
 * @author ASUS
 *插入排序
 *插入排序应用的局限性 很大 只能往已经有序的列表中进行添加
 *可以考虑使用插入排序构造一个有序的列表
 */
public class InsertSort {
	public void insertSort(int [] a) {
		int len = a.length;
		int insertNum;
		for(int i=1;i<len;i++) {
			insertNum=a[i];
			int j = i-1;
			while(j>=0&&a[j]>insertNum) {
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=insertNum;
		}
	}
	public static void main(String[] args) {
		InsertSort is = new InsertSort();
		int a[] = {1,4,6,8,9};
		is.insertSort(a);
	}
}
