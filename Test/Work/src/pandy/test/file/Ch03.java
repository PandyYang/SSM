package pandy.test.file;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Ch03 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String i1 = in.nextLine();
		File file = new File(i1);
		if(!file.exists()) {
			System.out.println("�ļ��в����ڣ�");
			return;

		}
		File[] fileList = file.listFiles();//����ʹ��һ������������ָ���ļ����е��ļ�
		File[] Dirlist = file.listFiles();
		for(int i=0;i<fileList.length;i++) {
			if(fileList[i].isDirectory()) {
				System.out.println("�ļ��е�����:" + fileList[i].getName());
				for(int j = 0;j<fileList[i].length();j++) {
					Dirlist = fileList[j].listFiles();
					System.out.println(Dirlist.getClass());
				}
				continue;
			}
		}
	}
}
