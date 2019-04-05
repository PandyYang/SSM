package pandy.test.Singleton;

/**
 * @author ASUS
 *这是懒汉式单例 
 *只有在调用取得实例方法的时候才会实例化对象
 */
public class LHan {
	private static LHan lHan;
	private LHan() {}
	public static synchronized LHan getInstance() {
		if(lHan==null) {
			lHan = new LHan();
		}
		return lHan;
	}
}
