/*package spider;	
public class MainActivity extends AppCompatActivity {
    private Thread t;//线程
    private static int page = 0;//页数
    private static int countPage = 1;//总数
    private static int downloading = 0;//下载数
    private EditText et_main_url;
    private Button btn_main_download;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_main_url = (EditText) findViewById(R.id.et_main_url);
        btn_main_download = (Button) findViewById(R.id.bt_main_download);
        if (Build.VERSION.SDK_INT >= 23) { //安卓6.0以上需要允许授权才能写入图片到本地
            int REQUEST_CODE_CONTACT = 101;
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
            //验证是否许可权限
            for (String str : permissions) {
                if (this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                    //申请权限
                    this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
                }
            }
        }
 
    }
    //按钮的点击事件
    public void download(View v){
       String text = et_main_url.getText().toString();
        if(text != null && !"".equals(text)) {
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){//判断是否有读写权限
                Toast.makeText(MainActivity.this, "开始下载...", Toast.LENGTH_SHORT).show();
                new MainActivity().getAllLinks(text);
                btn_main_download.setEnabled(false);//设置按钮不能点击
                btn_main_download.setText("正在下载");//设置文字
            }else {
                Toast.makeText(this, "没有权限!", Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(MainActivity.this, "链接不能为空!", Toast.LENGTH_LONG).show();
        }
    }
 
    *//**
     * 获取所有图片链接
     * @return
     *//*
   public void getAllLinks(final String str){
        //因为安卓不能在主线程执行耗时的网络操作，所以需要开个分线程
         t =new Thread(() ->{ //jdk1.8新特性lambda表达式
                 try {
                     int count = 0;//定义一个变量控制链接的截取和给总页数赋值
                     for (; page < countPage; page++) {
                         String link = str;//将传入的参数赋值给link
                         String page_no = link.substring(link.indexOf("page_no"));//字符串截取
                         if(count == 0) {
                             //当第一次进入方法时，将用户输入的链接页数截取出来
                             page = Integer.valueOf(page_no.substring(page_no.indexOf("=") + 1, page_no.indexOf("&")));
                         }
                         //将链接截取拼接成新的链接
                         page_no = page_no.substring(0, page_no.indexOf("=") + 1);
                         link = link.substring(0, link.lastIndexOf("page_no"));
                         link = link + page_no + page;
                         //连接到url
                         Document doc = Jsoup.connect(link).timeout(10000).ignoreContentType(true).get();
                         //将返回回来的json字符串转换
                         JSONObject json = JSONObject.fromObject(doc.text());
                         //如果是第一页，就获取主题的图片
                         if (page == 1) {
                             String theme = json.getJSONObject("post").getString("images");//主题的图片
                         }
                         //如果是第一进入方法就获取总页数的值，并将count的值改变
                         if(count == 0) {
                             countPage = json.getInt("totalPage");//获取总页数
                             count = count + 1;
                         }
                         //获取装有图片的json数组
                         JSONArray jsonArray = json.getJSONArray("comments");
                         //遍历json数组
                         for (int i = 0; i < jsonArray.size(); i++) {
                             //获取到图片的链接，因为是多个图片连接的，所以将链接拆分
                             String images = jsonArray.getJSONObject(i).getString("images");
                             String imgLink = images.replaceAll("\\[", "").replaceAll("]", "");
                             if (imgLink != null && !"".equals(imgLink)) {
                                 //以","将链接分成一个数组
                                 String[] strs = imgLink.split(",");
                                 for (int j = 0; j < strs.length; j++) {
                                    //链接格式有问题，需要处理
                                     strs[j] = strs[j].substring(1, strs[j].lastIndexOf("\""));
                                     download(strs[j]);//调用下载方法
                                 }
                             }
                         }
                     }
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
         });
        t.start();
    }
 
    *//**
     * 下载图片
     * @param link
     *//*
    public void download(String link){
        try {
            URL url = new URL(link);//定义一个URL
            //输入流，读取图片
            DataInputStream dis = new DataInputStream(url.openStream());
            byte[] bytes = new byte[1024];
            //截取后缀
            String suffix = link.substring(link.lastIndexOf("."));
            //获取用户的sd卡目录
            File directory = Environment.getExternalStorageDirectory();
            File file = new File(directory + "/guyun/");
            if(!file.exists()){
                file.mkdirs();
            }
            Log.e("输出目录",file.getAbsolutePath());
            //输出流，用时间的毫秒值当图片名称
            FileOutputStream fos = new FileOutputStream(new File(file.getAbsolutePath()+ "/" +  new Date().getTime() + suffix));
            ByteArrayOutputStream baos =  new ByteArrayOutputStream();
            //写出图片
            int len = -1;
            while ((len = dis.read(bytes)) != -1){
                baos.write(bytes,0,len);
            }
            fos.write(baos.toByteArray());
            downloading ++;
            dis.close();
            baos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/