package pandy.test.ch04;
/*
 * ���ӵ� �൱���ǳ���
 */
public class Node {
	//������
	public long data;
	//ָ����
	public Node next;
	
	public Node(long value) {
		this.data=value;
	}
	
	/*
	 * ��ʾ����
	 */
	public void display() {
		System.out.println(data + " ");
	}
	
}
