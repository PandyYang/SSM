package pandy.test.node;

/**
 * 先给链表建立节点类
 * @author ASUS
 *
 */
public class Node {
	public Object data;//存放节点数据值
	public Node next;//存放后继节点
	
	//无参构造函数
	public Node() {
		
	}
	
	//只有节点值的构造函数
	public Node(Object data) {
		this.data=data;
	}
	
	
	//带有节点值和后继节点的构造函数
	public Node(Object data,Node next) {
		this.data=data;
		this.next=next;
	}
	
	//
}
