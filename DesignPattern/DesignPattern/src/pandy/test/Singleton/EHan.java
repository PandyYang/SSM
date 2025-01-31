package pandy.test.Singleton;

/**
 * @author ASUS
 *单例模式根据实例化对象的时机不同分为饿汉单例与懒汉单例
 *以下是饿汉单例模式
 *其在单例类被加载时,就实例化一个对象交给自己的引用
 *而懒汉在调用取得实例方法的时候才会实例化对象
 */
public class EHan {
	//实例化对象 在单例类加载的时候就进行实例化
	private static EHan eHan = new EHan();
	//空参构造
	private EHan() {}
	
	public static EHan getInstance() {
		return eHan;
	}
}
