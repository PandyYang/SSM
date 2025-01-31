﻿package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;
import com.itheima.domain.Cart;
import com.itheima.domain.CartItem;
import com.itheima.domain.Category;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.domain.User;
import com.itheima.service.ProductService;
import com.itheima.utils.CommonsUtils;
import com.itheima.utils.JedisPoolUtils;
import com.itheima.utils.PaymentUtil;

import redis.clients.jedis.Jedis;

public class PrdocutServlet extends BaseServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//获得我的订单
	public void myOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//校验用户是否已经登录
		HttpSession session = request.getSession();
		//如果用户没有登录  下面的代码都不会执行
		User user = (User) session.getAttribute("user");
		if(user==null) {
			//没有登录 request.getContextPath可以获得站点的根路径
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		
		//查询该用户的所有的订单信息单表  查询orders表
		ProductService service = new ProductService();
		//集合中的每一个order对象的数据是不完整的 缺少orderItems
		List<Order> orderList = service.findAllOrders(user.getUid());
		//循环所有的订单 为每个订单填充订单项的集合信息
		if(orderList!=null) {
			for(Order order:orderList) {
				//获得每一个订单的oid
				String oid = order.getOid();
				//查询该订单的所有的订单项  --mapList中封装的是多个map 是多个订单项 和其中的商品
				List<Map<String,Object>> mapList = service.findAllOrderItemByOid(oid);
				//将mapList转换成List<OrderItem> orderItems
				for(Map<String,Object> map:mapList) {
					
					try {
						
						//从map中取出count subtotal orderitem中
						OrderItem item = new OrderItem();
						//item.setCount(Integer.parseInt(map.get("count").toString()));
						BeanUtils.populate(item, map);
						//还需要从map中取出pimage pname pshop_price 封装到product中
						Product product = new Product();
						BeanUtils.populate(product, map);
						//jiang product封装到OrderItem中
						item.setProduct(product);
						//将orderItem封装到order中的orderItemList
						order.getOrderItems().add(item);
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		//orderList封装完整
		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("/order_list.jsp").forward(request, response);
	}
	
	
	//确认订单 更新收货人信息 在线支付 
	public void confirmOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		 //接受前台传递过来的表单
		//使用order进行封装
		//1.更新收货人的信息
		Map<String, String[]> properties = request.getParameterMap();
		Order order = new Order();
		try {
			BeanUtils.populate(order, properties);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ProductService service = new ProductService();
		service.updateOrderAddr(order);
		
		//2.在线支付
		//获得选择的银行
		//radio中的值依次与选中的每个银行的特定号码进行比较 比较完了之后进行判断
		//String pd_FrpId = request.getParameter("pd_FrpId");
		/*if(pd_FrpId.equals("")) {
			接入该银行的接口
		}*/
		//只接入一个接口 该接口已经集成了所有的银行接口 这个接口由第三方平台提供
		// 获得 支付必须基本数据
				String orderid = request.getParameter("oid");
				//String money = order.getTotal()+"";//支付金额
				String money = "0.01";//支付金额
				// 银行
				String pd_FrpId = request.getParameter("pd_FrpId");

				// 发给支付公司需要哪些数据
				String p0_Cmd = "Buy";
				String p1_MerId = ResourceBundle.getBundle("merchantInfo").getString("p1_MerId");
				String p2_Order = orderid;
				String p3_Amt = money;
				String p4_Cur = "CNY";
				String p5_Pid = "";
				String p6_Pcat = "";
				String p7_Pdesc = "";
				// 支付成功回调地址 ---- 第三方支付公司会访问、用户访问
				// 第三方支付可以访问网址
				String p8_Url = ResourceBundle.getBundle("merchantInfo").getString("callback");
				String p9_SAF = "";
				String pa_MP = "";
				String pr_NeedResponse = "1";
				// 加密hmac 需要密钥
				String keyValue = ResourceBundle.getBundle("merchantInfo").getString(
						"keyValue");
				String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
						p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
						pd_FrpId, pr_NeedResponse, keyValue);


				String url = "https://www.yeepay.com/app-merchant-proxy/node?pd_FrpId="+pd_FrpId+
						"&p0_Cmd="+p0_Cmd+
						"&p1_MerId="+p1_MerId+
						"&p2_Order="+p2_Order+
						"&p3_Amt="+p3_Amt+
						"&p4_Cur="+p4_Cur+
						"&p5_Pid="+p5_Pid+
						"&p6_Pcat="+p6_Pcat+
						"&p7_Pdesc="+p7_Pdesc+
						"&p8_Url="+p8_Url+
						"&p9_SAF="+p9_SAF+
						"&pa_MP="+pa_MP+
						"&pr_NeedResponse="+pr_NeedResponse+
						"&hmac="+hmac;

				//重定向到第三方支付平台
				response.sendRedirect(url);
		
	}	
	
	
	
	/*public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获得请求的哪个方法的method
		String methodName = request.getParameter("method");
		if("productList".equals(methodName)){
			productList(request,response);
		}else if("categoryList".equals(methodName)){
			categoryList(request,response);
		}else if("index".equals(methodName)){
			index(request,response);
		}else if("productInfo".equals(methodName)){
			productInfo(request,response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	 */

	//提交订单
	public void submitOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		HttpSession session = request.getSession();
		//如果用户没有登录  下面的代码都不会执行
		User user = (User) session.getAttribute("user");
		if(user==null) {
			//没有登录 request.getContextPath可以获得站点的根路径
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		
		//web层中的目的就是封装好一个order对象 并且传递给service
		Order order = new Order();
		/*private String oid;//该订单的订单号
		private Date ordertime;//下单的时间
		private double total;//该订单的总金额
		private int state;//订单的支付状态 1代表已经付款 0代表还未付款
		//注意当前的登录者  与收货人可能不是一个人
		private String address;//收货地址
		private String name;//收货人
		private String telephone;//收货人电话
		private User user;//该订单属于哪个用户
		 */
		//CommonsUtils中只有一个static的获取String类型的uuid的方法
		String oid = CommonsUtils.getUUID();
		
		order.setOid(oid);
		order.setOrdertime(new Date());
		
		//获得购物车
		Cart cart = (Cart) session.getAttribute("cart");
		double total = cart.getTotal();
		order.setTotal(total);
		
		order.setState(0);
		
		order.setAddress(null);
		
		order.setName(null);
		
		order.setTelephone(null);
		
		order.setUser(user);
		
		//List<OrderItem> orderItems = new ArrayList<OrderItem>();//该订单中可能包含多个订单项
		//获得购物车中的购物项的集合map
		Map<String, CartItem> cartItems = cart.getCartItems();
		for(Map.Entry<String, CartItem> entry:cartItems.entrySet()) {
			//取出购物车中的每一个购物项
			CartItem cartItem = entry.getValue();
			OrderItem orderItem = new OrderItem();
			
			/*private String itemid;
			private int count;
			private double subtotal;
			private String pid;//作废 对应下面的product
			private String oid;//作废 对应下面的order
			private Product product;
			private Order order;*/
			orderItem.setItemid(CommonsUtils.getUUID());
			orderItem.setCount(cartItem.getBuyNum());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			
			//将该订单项添加到订单的订单项集合中
			order.getOrderItems().add(orderItem);
		}
		
		//order对象封装完成
		//传递数据到service
		ProductService service = new ProductService();
		service.submitOrder(order);
	
		session.setAttribute("order", order);
		//页面跳转
		response.sendRedirect(request.getContextPath()+"/order_info.jsp");
	
	}
	
	
	
	
	//清空购物车
	public void clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("cart");

		//跳转回cart.jsp
		response.sendRedirect(request.getContextPath()+"/cart.jsp");

	}

	//删除单一商品
	public void delProFromCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得要删除的item的pid
		String pid = request.getParameter("pid");
		//删除session中的购物车中的购物项集合中的item
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart!=null){
			Map<String, CartItem> cartItems = cart.getCartItems();
			//需要修改总价
			cart.setTotal(cart.getTotal()-cartItems.get(pid).getSubtotal());
			//删除
			cartItems.remove(pid);
			cart.setCartItems(cartItems);

		}

		session.setAttribute("cart", cart);

		//跳转回cart.jsp
		response.sendRedirect(request.getContextPath()+"/cart.jsp");
	}


	//将商品添加到购物车
	public void addProductToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		ProductService service = new ProductService();


		//获得要放到购物车的商品的pid
		String pid = request.getParameter("pid");
		//获得该商品的购买数量 //将字符串转化为整数
		int buyNum = Integer.parseInt(request.getParameter("buyNum"));

		//获得product对象
		Product product = service.findProductByPid(pid);
		//计算小计
		double subtotal = product.getShop_price()*buyNum;
		//封装CartItem 商品 购买数量 总价值
		CartItem item = new CartItem();
		item.setProduct(product);
		item.setBuyNum(buyNum);
		item.setSubtotal(subtotal);

		//获得购物车---判断是否在session中已经存在购物车
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart==null){
			cart = new Cart();
		}

		//将购物项放到车中---key是pid
		//先判断购物车中是否已将包含此购物项了 ----- 判断key是否已经存在
		//如果购物车中已经存在该商品----将现在买的数量与原有的数量进行相加操作
		Map<String, CartItem> cartItems = cart.getCartItems();

		double newsubtotal = 0.0;

		if(cartItems.containsKey(pid)){
			//取出原有商品的数量
			CartItem cartItem = cartItems.get(pid);
			int oldBuyNum = cartItem.getBuyNum();
			oldBuyNum+=buyNum;
			cartItem.setBuyNum(oldBuyNum);
			cart.setCartItems(cartItems);
			//修改小计
			//原来该商品的小计
			double oldsubtotal = cartItem.getSubtotal();
			//新买的商品的小计
			newsubtotal = buyNum*product.getShop_price();
			cartItem.setSubtotal(oldsubtotal+newsubtotal);

		}else{
			//如果车中没有该商品
			cart.getCartItems().put(product.getPid(), item);
			newsubtotal = buyNum*product.getShop_price();
		}

		//计算总计
		double total = cart.getTotal()+newsubtotal;
		cart.setTotal(total);


		//将车再次访问session
		session.setAttribute("cart", cart);

		//直接跳转到购物车页面 注意不能使用转发 否则界面刷新一次 就添加一次购物车
		response.sendRedirect(request.getContextPath()+"/cart.jsp");
	}

	//显示商品的类别的的功能
	public void categoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service = new ProductService();

		//先从缓存中查询categoryList 如果有直接使用 没有在从数据库中查询 存到缓存中
		//1、获得jedis对象 连接redis数据库
		Jedis jedis = JedisPoolUtils.getJedis();
		String categoryListJson = jedis.get("categoryListJson");
		//2、判断categoryListJson是否为空
		if(categoryListJson==null){
			System.out.println("缓存没有数据 查询数据库");
			//准备分类数据
			List<Category> categoryList = service.findAllCategory();
			Gson gson = new Gson();
			categoryListJson = gson.toJson(categoryList);
			jedis.set("categoryListJson", categoryListJson);
		}

		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(categoryListJson);
	}

	//显示首页的功能
	//显示商品的类别的的功能
	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service = new ProductService();

		//准备热门商品---List<Product>
		List<Product> hotProductList = service.findHotProductList();

		//准备最新商品---List<Product>
		List<Product> newProductList = service.findNewProductList();

		//准备分类数据
		//List<Category> categoryList = service.findAllCategory();

		//request.setAttribute("categoryList", categoryList);
		request.setAttribute("hotProductList", hotProductList);
		request.setAttribute("newProductList", newProductList);

		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	//显示商品的详细信息功能
	public void productInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获得当前页
		String currentPage = request.getParameter("currentPage");
		//获得商品类别
		String cid = request.getParameter("cid");

		//获得要查询的商品的pid
		String pid = request.getParameter("pid");

		ProductService service = new ProductService();
		Product product = service.findProductByPid(pid);

		request.setAttribute("product", product);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("cid", cid);


		//获得客户端携带cookie---获得名字是pids的cookie
		String pids = pid;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cookie : cookies){
				if("pids".equals(cookie.getName())){
					pids = cookie.getValue();
					//1-3-2 本次访问商品pid是8----->8-1-3-2
					//1-3-2 本次访问商品pid是3----->3-1-2
					//1-3-2 本次访问商品pid是2----->2-1-3
					//将pids拆成一个数组
					String[] split = pids.split("-");//{3,1,2}
					List<String> asList = Arrays.asList(split);//[3,1,2]
					LinkedList<String> list = new LinkedList<String>(asList);//[3,1,2]
					//判断集合中是否存在当前pid
					if(list.contains(pid)){
						//包含当前查看商品的pid
						list.remove(pid);
						list.addFirst(pid);
					}else{
						//不包含当前查看商品的pid 直接将该pid放到头上
						list.addFirst(pid);
					}
					//将[3,1,2]转成3-1-2字符串
					StringBuffer sb = new StringBuffer();
					for(int i=0;i<list.size()&&i<7;i++){
						sb.append(list.get(i));
						sb.append("-");//3-1-2-
					}
					//去掉3-1-2-后的-
					pids = sb.substring(0, sb.length()-1);
				}
			}
		}


		Cookie cookie_pids = new Cookie("pids",pids);
		response.addCookie(cookie_pids);

		request.getRequestDispatcher("/product_info.jsp").forward(request, response);

	}

	//根据商品的类别获得商品的列表
	public void productList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获得cid
		String cid = request.getParameter("cid");

		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		int currentCount = 12;

		ProductService service = new ProductService();
		PageBean pageBean = service.findProductListByCid(cid,currentPage,currentCount);

		request.setAttribute("pageBean", pageBean);
		request.setAttribute("cid", cid);

		//定义一个记录历史商品信息的集合
		List<Product> historyProductList = new ArrayList<Product>();

		//获得客户端携带名字叫pids的cookie
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if("pids".equals(cookie.getName())){
					String pids = cookie.getValue();//3-2-1
					String[] split = pids.split("-");
					for(String pid : split){
						Product pro = service.findProductByPid(pid);
						historyProductList.add(pro);
					}
				}
			}
		}
		//将历史记录的集合放到域中
		request.setAttribute("historyProductList", historyProductList);

		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}
}