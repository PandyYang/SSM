package pandy.test.ch2;

/**
 * @author ASUS
 *��������
 *��������Ӧ�õľ����� �ܴ� ֻ�����Ѿ�������б��н������
 *���Կ���ʹ�ò���������һ��������б�
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
