package pandy.test.file;

import java.io.File;

public class CH02 {
	public static void main(String[] args) {
		File file = new File("E:\\");
		if(!file.exists()) {
			System.out.println("没有找到相关文件");
			return;
		}
		File[] fileList = file.listFiles();
		for(int i=0;i<fileList.length;i++) {
			if(fileList[i].isDirectory()) {
				System.out.println("directory is:" + fileList[i].getName());
			}else {
				System.out.println("file is" + fileList[i].getName());
			}
				
		}
	}
}
