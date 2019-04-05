package pandy.test.play;

/**
 * @author ASUS
 *ì³²¨ÄÇÆõÊıÁĞ 1 1 2 3 5 8 13 21...
 */
public class Exp2 {
	
	public static int f(int x) {
		if(x==1||x==2)
		 return 1;
		else
			return f(x-1)+f(x-2);
	}
	
	public static void main(String[] args) {
		int i=0;
		for(i=1;i<=20;i++)
			System.out.println(f(i));
	}
}	
