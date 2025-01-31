package pandy.test.node;

import java.util.Scanner;

/**
 * 建立链表以及对其进行操作
 * @author ASUS
 *
 */
public class LinkList {
	public Node head;//单链表的头指针
	
	//构造函数初始化头结点
	public LinkList() {
		head = new Node();
	}
	
	//构造函数构造长度为n的单链表
	public LinkList(int n,boolean Order) throws Exception {
		this();
		if(Order)
			create1(n);//头插法顺序建立单链表
		else
			create2(n);//尾插法逆序建立单链表
	}
	
	//头插法顺序建立单链表
	public void create1(int n) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入节点的数据(头插法)");
		for(int i=0;i<n;i++) {
			insert(0,sc.next());
		}
	}
	//尾插法逆序建立单链表
	public void create2(int n) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入节点的数据(尾插法)");
		for(int i=0;i<n;i++) {
			insert(length(),sc.next());
		}
	}
	
	//将链表置空
	public void clear() {//节点数据值销毁 指针销毁
		head.data=null;
		head.next=null;
	}
	
	//判断链表是否为空
	public boolean isEmpty() {
		return head.next==null;//头指针当前节点
	}
	
	//返回链表长度
	public int length() {
		Node p = head.next;
		int length=0;
		while(p!=null) {
			p=p.next;//指针移动
			length++;
		}
		return length;
	}
	
	//读取并返回第i个位置的元素
	public Object get(int i) throws Exception {
		Node p =head.next;
		int j;
		//从首节点开始向后查找 直到p指向第i个节点或者p为null
		for(j=0;j<i&&p!=null;j++) {
			p=p.next;
		}
		if(j>i||p==null) {//i不合法的时候抛出异常 例如i<=0
			throw new Exception("第"+i+"个数据元素不存在");
		}
		return p.data;	
	}
	
	//插入x作为第i个元素
	public void insert(int i,Object x) throws Exception {
		Node p = head;
		int j=-1;
		//寻找第i个节点的前驱i-1
		while(p!=null&&j<i-1) {
			p=p.next;//指针移动 计算出位置 无论用作什么 只是将位置计算出来 现在根据上面的判断条件 是计算出要插入位置的前一个的顺序
			j++;
		}
		if(j>i-1||p==null) {//i<0的时候 显然不是链表中的合法数据名 但是倒序不一定
			throw new Exception("插入位置不合法");
		}else {
			Node s = new Node(x);//新构建一个要插入新数据的节点
			s.next=p.next;//指针指向
			p.next=s;
		}
	}
	
	//删除第i个元素
	public void remove(int i) throws Exception {
		Node p = head;
		int j=-1;
		while(p!=null&&j<i-1) {//删除首先判断链表不为空 进而判断位置
			p=p.next;
			j++;
		}
		if(j>i-1||p.next==null)
			throw new Exception("删除的位置不合法");
		p.next=p.next.next;
	}
	
	//返回元素x首次出现的位置
	public int indexOf(Object x) {
		Node p = head.next;
		int j=0;
		while(p!=null&&!p.data.equals(x)) {
			p=p.next;
			j++;
		}
		if(p!=null)
			return j;
		else
			return -1;
	}
	
	public void display() {
		Node p = head.next;
		while(p!=null) {
			if(p.next==null)
				System.out.println(p.data);
			else
				System.out.println(p.data+"->");
			p=p.next;
		}
	}
}
