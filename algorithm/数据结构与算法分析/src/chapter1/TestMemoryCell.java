package chapter1;
/*
 * 将37写入到MemoryCell中然后进行读取，为了能读取必须进行正确的类型转换
 * 但是现在不必进行 他因为toString方法可以对任意对象都能够进行正确的读取
 * */
public class TestMemoryCell {
	public static void main(String[] args) {
		MemoryCell m = new MemoryCell();
		m.write("37");
		String val = (String) m.read();
		System.out.println("Contents are: "+val);
	}
}
