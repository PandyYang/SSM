package test;


import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;




public class IHDFS 
{
    private static String HDFSUri = "hdfs://localhost:9000";//设置全局静态变量
	public static FileSystem getCorSys() 
	{
		Configuration conf = new Configuration();//读取配置文件
		
		FileSystem coreSys = null;//文件系统
		String hdfsUri = HDFSUri;
		if ("".equals(hdfsUri)) 
		{
			try // 返回默认文件系统  如果在 Hadoop集群下运行，使用此种方法可直接获取默认文件系统
			{
				coreSys = FileSystem.get(conf);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		else 
		{
			try // 返回指定的文件系统,如果在本地测试，需要使用此种方法获取文件系统
			{
				URI uri = new URI(hdfsUri.trim());
				coreSys = FileSystem.get(uri, conf);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return coreSys;
	}
	
//查找文件或目录	

    public static  void search(String filename)
    {
        char ch,ch1;
        if ("".equals(filename))//如果输入的路径为空即没有输入，直接结束并返回false；
        {
        	System.out.println("检测到您输入的路径为空，请重新输入！！！"  );
        }
        try
        {
        	Path path = new Path(filename);
            FileSystem coreSys = getCorSys();//获得文件指针，打开文件系统；
            if (!coreSys.exists(path))//若文件地址为空则创建；
            {
            	System.out.println("检测不到您的文件，是否创建目录？（Y/N）" + "\n"  );
            	ch = (char)System.in.read();
                if ('y'==ch || 'Y'==ch)
                {
                	coreSys.mkdirs(path);
                	System.out.println("创建目录成功！" + "\n" );
                	System.out.println("是否显示已创建的目录？（Y/N）" + "\n" );
                	Scanner sc14 = new Scanner(System.in);
                    ch1 =sc14.next().charAt(0);
                	if ('y'==ch1 || 'Y'==ch1)
                    {
                		System.out.println("以下为显示内容" + "\n" );
                		ShowFiles(path);
                    }
                }
            }

            if (coreSys.isDirectory(path))//判断是否是文件夹（目录）
            {
            	System.out.println("检测到您的目录，目录地址为:" + "\n"  + HDFSUri + filename );
            }
            else
            {
            	System.out.println("检测到您的文件，文件地址为:" + "\n"  + HDFSUri + filename );
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    //创建目录
    public static boolean createDir(String path)
    {
        FileSystem coreSys=getCorSys();
        System.out.println("文件路径为："+path);
        try 
        {
            return coreSys.mkdirs(new Path(path));
        } 
        catch (IOException e) 
        {
            return false;
        }
        finally 
        {
            try 
            {
                coreSys.close();//关闭文件指针，关闭系统
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }

//修改目录\文件
    
    public static boolean renameDir(String oldPath,String newPath)
    {
        FileSystem coreSys=getCorSys();
        try 
        {
            return coreSys.rename(new Path(oldPath),new Path(newPath));//将两个地址进行交换；
        } 
        catch (IOException e) 
        {
            return false;
        }
        finally 
        {
            try 
            {
                coreSys.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }

//删除目录或者文件
    
    public static boolean delDir(String path)
    {
        FileSystem coreSys=getCorSys();
        try 
        {
            return coreSys.delete(new Path(path),true);
        } 
        catch (IOException e) 
        {
            return false;
        }
        finally 
        {
            try 
            {
                coreSys.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
    /**
     * 
     * 
     * @param path 文件路径
     */
    public static void ShowFiles(Path path)
    {
        try
        {
        	FileSystem coreSys=getCorSys(); //打开文件系统；
            FileStatus[] files = coreSys.listStatus(path);//获取文件列表；
            for (int i = 0; i < files.length; i++) //展示文件信息；
            {
                try
                {
                    if(files[i].isDirectory())
                    {
                    	System.out.println("********************************************************************************************");
                        System.out.println(">>>路径：" + files[i].getPath()
                                + "                     所有者 :" + files[i].getOwner() 
                                + "               修改时间：" + files[i].getModificationTime()
                                +"\n");
                        //递归调用
                        ShowFiles(files[i].getPath());
                    }
                    else if(files[i].isFile())
                    {
                        System.out.println("     路径：" + files[i].getPath()
                                + "            文件大小:" + files[i].getLen() + "字节"
                                + "          所有者:" + files[i].getOwner() 
                                + "        修改时间：" + files[i].getModificationTime());
                        
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

//文件上传
    
    public static boolean uploadFile(String srcPath,String desPath)
    {
        FileSystem coreSys=getCorSys();
        try 
        {
            if(coreSys.isDirectory(new Path(desPath)))//新建一个Path类型，然后将字符串类型转换为地址
            {
                coreSys.copyFromLocalFile(new Path(srcPath),new Path(desPath));
                return true;
            }
            else 
            {
                throw new IOException("本地文件不存在！");
            }
        } catch (IOException e) 
        {
            return false;
        }finally 
        {
            try 
            {
                coreSys.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
    
//文件下载
    
    public static boolean downloadFile(String srcPath,String desPath)
    {
        FileSystem coreSys=getCorSys();
        try 
        {
            coreSys.copyToLocalFile(new Path(srcPath),new Path(desPath));
            return true;
        } 
        catch (IOException e) 
        {
            return false;
        }
        finally 
        {
            try 
            {
                coreSys.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }

//读取函数
    
    public static void readFile(String filePath) throws IOException
    {
    	FileSystem coreSys=getCorSys();//打开文件系统
        FSDataInputStream is=coreSys.open(new Path(filePath));//打开文件
        IOUtils.copyBytes(is, System.out, 2048, false); //复制到标准输出流
        coreSys.close();
    }
    
//主函数测试
    
    public static void main(String[] args) throws Exception 
    {
    //FileSystem coreSys=getCorSys();//连接fs
    //System.out.println(coreSys.getUsed());
    	char ch;
    	do{
    		System.out.println("***********************************************");
    		System.out.println("****1、创建");
    		System.out.println("****2、上传");
    		System.out.println("****3、下载");
    		System.out.println("****4、显示");
    		System.out.println("****5、查询");
    	    System.out.println("****6、删除");
    	    System.out.println("****7、读取");
    	    System.out.println("****8、重命名");
    	    System.out.println("***********************************************");
    	    System.out.println("请输入数字（1~8）选择操作：");
    	    Scanner sc = new Scanner(System.in);
    	    int i = sc.nextInt();
    	    while(i<1||i>8) 
    	    {
    	    	System.out.println("请重新输入（1~8）");
    	    	Scanner sc12 = new Scanner(System.in);
        	    i = sc12.nextInt();
    	    }
    	    switch (i)
    	    {
    	    case 1:  
    	    	System.out.println("********************创建********************");
    	    	System.out.println("请输入你喜欢的目录名：" + "\n" + "格式如：user" + "\n");
    	    	Scanner sc1 = new Scanner(System.in);
    	    	String fliename = sc1.nextLine();
    	    	createDir("/" + fliename);
    	    	System.out.println("创建完成！" + "\n");
    	    	ShowFiles(new Path("/"));
    	    	break;
    	    case 2:
    	    	System.out.println("********************上传********************");
    	    	System.out.println("请输入你要上传的文件地址：" + "\n" + "格式如：D:\\dev" + "\n");
    	    	Scanner sc2 = new Scanner(System.in);
    	    	String srcPath = sc2.nextLine();//接收字符串地址；
    	    	ShowFiles(new Path("/"));
    	    	System.out.println("\n" + "请输入你要上传到服务器的地址：" + "\n" + "格式如：/user" + "\n");
    	    	Scanner sc3 = new Scanner(System.in);
    	    	String desPath = sc3.nextLine();
    	    	uploadFile(srcPath,desPath);
    	    	System.out.println("上传完成！" + "\n");
    	    	ShowFiles(new Path("/"));
    	    	break;
    	    case 3:
    	    	System.out.println("********************下载********************");
    	    	ShowFiles(new Path("/"));
    	    	System.out.println("\n" + "请输入你要从服务器下载的文件地址：" + "\n" + "格式如：/user" + "\n");
    	    	Scanner sc4 = new Scanner(System.in);
    	    	String srcPath1 = sc4.nextLine();//接收字符串地址；
    	    	System.out.println("请输入你要下载到本地的地址：" + "\n" + "格式如：D:\\dev" + "\n");
    	    	Scanner sc5 = new Scanner(System.in);
    	    	String desPath1 = sc5.nextLine();
    	    	downloadFile(srcPath1,desPath1);
    	    	System.out.println("下载完成！");
    	    	break;
    	    case 4:
    	    	System.out.println("********************显示********************");
    	    	System.out.println("请输入你要显示的目录：" + "\n" + "格式如：/user" + "\n");
    	    	Scanner sc6 = new Scanner(System.in);
    	    	String path = sc6.nextLine();
    	    	ShowFiles(new Path(path));
    	    	break;
    	    case 5:
    	    	System.out.println("********************查询********************");
    	    	System.out.println("请输入你要查询的目录：" + "\n" + "格式如：user" + "\n");
    	    	Scanner sc7 = new Scanner(System.in);
    	    	String findpath = sc7.nextLine();
    	    	//System.out.println(existDir("/" + findpath,true));
    	    	search("/" + findpath);
    	    	break;
    	    case 6:
    	    	System.out.println("********************删除********************");
    	    	System.out.println("\n" + "请输入你要删除的目录：" + "\n" + "格式如：user" + "\n");
    	    	ShowFiles(new Path("/"));
    	    	Scanner sc8 = new Scanner(System.in);
    	    	String deletepath = sc8.nextLine();
    	    	delDir("/" + deletepath);
    	    	System.out.println("删除成功！");
    	    	break;
    	    case 7:
    	    	System.out.println("********************读取********************");
    	    	System.out.println("\n" + "请输入你要读取的文件：" + "\n" + "格式如：/user/1.txt" + "\n");
    	    	ShowFiles(new Path("/"));
    	    	Scanner sc9 = new Scanner(System.in);
    	    	String readpath = sc9.nextLine();
    	    	System.out.println("读取成功！" + "\n" + "以下为显示结果：" + "\n");
    	    	readFile(readpath);
    	    	System.out.println("\n");
    	    	break;
    	    case 8:
    	    	System.out.println("********************重命名********************");
    	    	System.out.println("\n" + "请输入你要重命名的目录或文件：" + "\n" + "格式如：user" + "\n");
    	    	ShowFiles(new Path("/"));
    	    	Scanner sc10 = new Scanner(System.in);
    	    	String name = sc10.nextLine();
    	    	System.out.println("请输入之后的目录名或文件名：" + "\n" + "格式如：wr" + "\n");
    	    	Scanner sc11 = new Scanner(System.in);
    	    	String rename = sc11.nextLine();
    	    	renameDir("/" + name,"/" + rename);
    	    	System.out.println("重命名成功！" + "\n" + "以下为显示结果：" + "\n");
    	    	ShowFiles(new Path("/"));
    	    	break;
    	    }
    	    System.out.println("是否要继续？（Y/N）：");
    	    ch = (char)System.in.read();
    	}while(ch == 'y' || ch == 'Y'  );
    }

	
}