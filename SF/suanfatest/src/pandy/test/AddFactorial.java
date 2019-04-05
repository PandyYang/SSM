package pandy.test;

/**
 * 求1!+2!+3!+...15!
 * @author ASUS
 *
 */
public class AddFactorial {
	int result=1;
	int maxResult;
	private void addFactorial() {//静态代码块中不能应用之外的非静态变量
		for(int i=1;i<16;i++) {//外层循环用于累加
			for(int j=1;j<=i;j++) {//内层的循环用于累乘 累乘需要i的值 其是累乘的边界
				result*=j;//初始值赋为0 是愚蠢的行为
			}
			maxResult +=result;
		}
		System.out.println(maxResult);
	}
	public static void main(String[] args) {
		AddFactorial af = new AddFactorial();
		af.addFactorial();
	}
}
