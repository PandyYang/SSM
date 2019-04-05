package chapter1;
//使用object表示泛型
public class MemoryCell {
	private Object storedValue;
	public Object read() {return storedValue;}
	public void write(Object x) {storedValue = x;}
	
	
}
