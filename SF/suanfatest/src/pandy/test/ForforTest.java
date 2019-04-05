package pandy.test;

public class ForforTest {
	public static void main(String[] args) {
		int x,y,z;
		for(x=0;x<10;x++) {//外层循环确定行数
			for(y=0;y<x;y++) {//前面的空格
				System.out.print(" ");
			}
				for(y=0;y<2*(10-x)-1;y++) {
					System.out.print("*");
			}
			System.out.println();
		}
	}
}
