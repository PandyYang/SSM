package pandy.test.node;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		boolean or;
		int xz,xx;
		System.out.println("��ѡ�����ķ���:0:ͷ�巨,1:β�巨");
		xz=sc.nextInt();
		if(xz!=0)
			or=true;
		else
			or=false;
		System.out.println("���������Ľڵ����:");
		xx=sc.nextInt();
		LinkList L = new LinkList(xx,or);
		System.out.println("����������Ϊ:");
		L.display();
		System.out.println();
		System.out.println("����ĳ���:"+L.length());
		System.out.println("��������ҵĽڵ������:");
		Object x = sc.next();
		int position = L.indexOf(x);
		System.out.println("�ڵ������Ϊ:"+x+"��λ����:"+position);
		System.out.println("��������Ҫɾ���Ľڵ��λ��");
		int sr = sc.nextInt();
		L.remove(sr);
		L.display();
		System.out.println();
		System.out.println("����ĳ���:"+L.length());
	}
	
}
