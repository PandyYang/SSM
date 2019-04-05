package pandy.test;
/*
 * ��������
 */
public class QuickSort {
	
	public static void main() {
		long[] arr = new long[10];
		for(int i = 0;i<10;i++) {
			arr[i]=(long) (Math.random()*99);
		}
		QuickSort.partition(arr, 0, arr.length-1, 45);
		for(long t :arr) {
			System.out.println(t);
		}
	}

	/*
	 * ��������
	 * ����һ������ ָ����ʼλ�� ĩβλ�� �Լ��ؼ���
	 */
	public static  void partition(long arr[],int left,int right,int point) {
		int leftPtr = left-1;
		int rightPtr = right+1;
		while(true) {
			//��ѭ������ֱ�ӽ����������ж��Լ���ֵ�ĸ���
			while(leftPtr<rightPtr && arr[++leftPtr]<point);
			//
			while(rightPtr>leftPtr && arr[--rightPtr]>point);
			if(leftPtr>=rightPtr) {
				return;
			}else {
				long temp = arr[leftPtr];
				arr[leftPtr] = arr[rightPtr];
				arr[rightPtr]=temp;
			}
		}
		
	}
}
