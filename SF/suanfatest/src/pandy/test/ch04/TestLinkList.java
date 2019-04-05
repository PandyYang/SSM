package pandy.test.ch04;

public class TestLinkList {
	public static void main(String[] args) {
		MyLinkList linkList = new MyLinkList();
		linkList.insertFirst(34);
		linkList.insertFirst(33);
		linkList.insertFirst(45);
		linkList.insertFirst(343);
		
		linkList.display();
		Node node = linkList.find(33);
		node.display();
	}
}
