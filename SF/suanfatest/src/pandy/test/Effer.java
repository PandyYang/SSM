package pandy.test;

import java.util.Arrays;

/**
 * @author ASUS
 *ð������
 * ���������ð��������ƽ���������µ�ʱ�临�Ӷȶ���O(n^2)���������¶���O(n)���ռ临�Ӷ���O(1)
 */
public class Effer {
	public void efferArray(Integer []in) {
		int tem=0;
		int num = 0;
		int upnum =0;
		//�ǵ�ǰԪ�����Ļ�û���źõĲ��ֽ��в��� 
		//��ߵĲ����Ѿ������ض���˳���ź� ����ÿ�ε����ѭ�������ڲ�ѭ��������Ӧ�Ĵ���
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
