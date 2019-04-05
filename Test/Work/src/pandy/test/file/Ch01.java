package pandy.test.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ch01 {
	public static void main(String[] args) throws IOException {
		try {
			InputStream is = new FileInputStream("F:\\360MoveData\\Users\\ASUS\\Desktop\\1.txt");
			byte[] b = new byte[999];
			int i = 0;
			int index = 0;
			while((i=is.read())!=-1) {
				b[index] = (byte) i;
				index++;
			}
			System.out.println(new String(b));
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
