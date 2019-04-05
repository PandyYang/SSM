package pandy.test.file;

import java.io.File;
import java.util.LinkedList;

public class Ch04 {
	public static void readFilesDir(String path) {
		LinkedList<File> Dirlist = new LinkedList<File>();
		LinkedList<String> Filelist = new LinkedList<String>();
		File dir = new File(path);
		File[] files = dir.listFiles();
		
		for(File file:files) {
			if(file.isDirectory()) {
				Dirlist.add(file);
				for(int i = 0;i<Dirlist.size();i++) {
					System.out.println(Dirlist.get(i));
					}
			}else {
				Filelist.add(file.getAbsolutePath());
				System.out.println(file.getAbsolutePath());
			}
		}
		File temp;
		while(!Dirlist.isEmpty()) {
			temp = Dirlist.removeFirst();
			if(temp.isDirectory()) {
				files = temp.listFiles();
				if(files==null)continue;
				for(File file : files) {
					if(file.isDirectory()) {
						Dirlist.add(file);
						for(int i = 0;i<Dirlist.size();i++) {
							System.out.println(Dirlist.get(i));
						}
					}else {
						Filelist.add(file.getAbsolutePath());
						System.out.println(file.getAbsolutePath());
					}
				}
			}else {
				System.out.println("-------------");
			}
		}
	}
	public static void main(String[] args) {
		String path = "C:\\";
		readFilesDir(path);
	}
}
