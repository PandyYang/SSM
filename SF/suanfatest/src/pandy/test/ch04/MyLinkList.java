package pandy.test.ch04;
/*
 * 链表 相当于火车
 * */
public class MyLinkList {
	//头结点
	private Node first;
	
	public MyLinkList() {
		first=null;
	}
	
	/*
	 * 插入一个节点 在头结点之后插入
	 * 只需要改变插入节点的指针与 头一个节点的指针
	 */
	public void insertFirst(long value) {
		Node node = new Node(value);//创建一个新的节点
		node.next=first;//first在其中已经保留了 指向下一个的指针
		first=node;//然后将节点的值传递
	}
	/*
	 * 删除一个节点 在头结点之后进行删除
	 * 将头节点的指针直接指向下下一个node
	 */
	public Node deleteFirst() {
		//返回删除的节点
		Node tmp = first;
		first=tmp.next;//将中间要删除的部分直接跳过
		return tmp;
	}
	/*
	 * 显示方法 用来显示节点中的数据
	 */
	public void display() {
		Node current = first;
		while(current!=null) {//链表上面还有数据的话
			current.display();
			current=current.next;//跳到下一个节点
		}
		
	}
	/*
	 * 查找方法
	 */
	public Node find(long value) {
		Node current=first;
		while(current.data!=value) {
			if(current.next==null) {
				return null;
			}
			current = current.next;//当前节点的指向下一个节点的指针  next的定义已经创建都是为了表示这个
		}
		return current;
	}
	/*
	 * 删除方法 根据数据进行删除
	 */
	public Node delete(long value) {
		Node current = first;
		Node previous = first;
		while(current.data!=value) {
			if(current.next==null) {
				return null;
			}
			previous = current;
			current = current.next;
		}
		if(current==first) {//如果删除的是第一个节点 直接用下一个节点覆盖当前节点的指针 后删除
			first = first.next;
		}else {
			previous.next=current.next;//前一个节点的指针 给当前的节点 这个是前删除
		}
		return current;
	}
}
