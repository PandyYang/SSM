package pandy.test;

public class ForforTest {
	public static void main(String[] args) {
		int x,y,z;
		for(x=0;x<10;x++) {//���ѭ��ȷ������
			for(y=0;y<x;y++) {//ǰ��Ŀո�
				System.out.print(" ");
			}
				for(y=0;y<2*(10-x)-1;y++) {
					System.out.print("*");
			}
			System.out.println();
		}
	}
}
