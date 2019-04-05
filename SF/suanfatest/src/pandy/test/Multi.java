package pandy.test;


public class Multi {
	public void printMulti() {
		for(int j=1;j<10;j++) {
			for(int i=1;i<=j;i++) {
				System.out.print(i+"*" +j+"="+i*j+"\t");
			}
			System.out.print("\t\n");//1乘的那一列 打印一句 换行
		}
		System.out.print("\n\n\n");//1 2 3 4 5 ...9各个列依次递减 中间是三个空格
	}
	public static void main(String[] args) {
		Multi m = new Multi();
		m.printMulti();
	}
}
