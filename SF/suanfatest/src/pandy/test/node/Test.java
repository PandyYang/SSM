package pandy.test.node;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		boolean or;
		int xz,xx;
		System.out.println("请选择插入的方法:0:头插法,1:尾插法");
		xz=sc.nextInt();
		if(xz!=0)
			or=true;
		else
			or=false;
		System.out.println("请输入插入的节点个数:");
		xx=sc.nextInt();
		LinkList L = new LinkList(xx,or);
		System.out.println("建立的链表为:");
		L.display();
		System.out.println();
		System.out.println("链表的长度:"+L.length());
		System.out.println("请输入查找的节点的数据:");
		Object x = sc.next();
		int position = L.indexOf(x);
		System.out.println("节点的数据为:"+x+"的位置是:"+position);
		System.out.println("请输入需要删除的节点的位置");
		int sr = sc.nextInt();
		L.remove(sr);
		L.display();
		System.out.println();
		System.out.println("链表的长度:"+L.length());
	}
	
}
