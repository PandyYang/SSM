package pandy.test.fastsort;

/**
 * @author ASUS
 *��������
 *�ҵ�һ���ؼ�ֵ��Ϊ��׼ֵ �Ȼ�׼ֵС�Ķ�����ߵ����� �Ȼ�׼ֵ��Ķ����ұߵ�����
 *һ��ѡ�����еĵ�һ��Ԫ��
 *һ��ѭ����ʱ�� �Ӻ���ǰ�Ƚ� �û�׼ֵ�����һ��ֵ�Ƚ� ����Ȼ�׼ֵС�Ľ���λ��
 *���û�м����Ƚ���һ�� ֱ���ҵ�һ���Ȼ�׼ֵС��ֵ�Ž��� �ҵ����ֵ֮�� ��
 *��ǰ����Ƚ� ����бȻ�׼ֵ����򽻻�λ�� ���û�м����Ƚ���һ�� ֱ���ҵ��ȵ�һ����׼ֵ��ĲŽ���
 *ֱ����ǰ����ıȽ����д��ڴӺ���ǰ�ıȽ����� ������һ��ѭ�� ��ʱ���ڻ�׼ֵ��˵ �������߾��Ƕ�������
 *���ŷֱ�Ƚ��������ߵ����� �ظ�������ѭ������
 */
public class FastSort {
	public static void main(String[] args) {
		//��ʼ��һ������
		int[] a= {12,20,6,98,99,87,54,26,633};
		//����һ����ͷ
		int start  = 0;
		//��������ĳ���
		int end = a.length-1;
		//��������
		sort(a,start,end);
		//����֮�� ��ӡ�������е����� ������������д�ӡ
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}
	

	public static void sort(int[] a,int low,int high) {
		int start = low;//��λ��ͷ����Ϊ�������Ԫ��
		int end = high;//��λ����Ϊ�����βԪ��
		int key = a[low];//Ĭ�Ͻ���һ��Ԫ�ض�Ϊ��׼ֵ
		
		while(end>start) {//������������
			while(end>start&&a[end]>=key)//�ҵ��Ȼ�׼Ԫ�ش��ֵ �������ұ�
				end--;
			if(a[end]<=key) {
				int temp = a[end];
				a[end] = a[start];
				a[start] = temp;
			}
			while(end>start&&a[start]<=key)//�ҵ��Ȼ�׼Ԫ��С��ֵ���������
				start++;
			if(a[start]>=key) {
				int temp = a[start];
				a[start]=a[end];
				a[end]=temp;
			}
		}
		if(start>low) sort(a,low,start-1);//�Ի�׼Ԫ�ص�����ظ���ͬ�Ĳ���
		if(end<high) sort(a,end+1,high);//���ұ��ظ���ͬ�Ĳ���
	}
}
