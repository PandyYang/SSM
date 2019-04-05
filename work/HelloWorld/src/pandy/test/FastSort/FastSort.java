package pandy.test.FastSort;

public class FastSort {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		int[] a = {12,55,34,23,32,424,322,3323,232,3};
		int start = 0;
		int end = a.length-1;
		sort(a,start,end);
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void sort(int[] a,int low,int high) {
		int start = low;
		int end = high;
		int key = a[low];//������ߵ�Ԫ����Ϊÿ����Ҫ�Ƚϵ�ֵ
		
		
		while(end>start) {
			//�Ӻ���ǰ�Ƚ�
			while(end>start&&a[end]>=key)
				end--;
			if(a[end]<=key) {
				int temp = a[end];
				a[end] = a[start];
				a[start] = temp;
			}
			//��ǰ����Ƚ�
			while(end>start&&a[start]<=key)
				start++;
			if(a[start]>=key) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
			}
			//��ʱ������һ��ѭ�� �ؼ�ֵ��λ���Ѿ�ȷ�� ��ߵ�ֵ���ȹؼ�ֵС
			//�ұߵ�ֵ���ȹؼ�ֵ�� �����������ߵ�˳�����п��ܲ�һ��
			//���ڽ��еݹ����
			if(start>low) sort(a,low,start-1);
			if(end<high) sort(a,end+1,high);
		}
	}
}
