package pandy.test.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pandy.test.springmvc.pojo.Items;
import pandy.test.springmvc.pojo.QueryVo;
import pandy.test.springmvc.service.ItemService;

/**
 * @author ASUS
 *商品管理
 *在springmvc.xml中进行配置 用来扫描该注解
 *
 *请求发出之后由前端处理器进行拦截 然后将拦截到的页面转给一个页面处理器
 *该页面处理器会根据requestmapping中的路径进行访问下面的特定方法  该方法会返回一个
 *处理结果给前端控制器 前端控制器认识ModelView 然后前端控制器将结果转发给jsp 再到页面进行显示
 *其实jsp还要转化成html 然后再交给前端控制器 由前端控制器给用户
 *其实每一个步骤都要和前端控制器打交道  然后由前端控制器负责命令的分发以及处理
 *
 *
 *
 *1.ModelAndView 无敌的 带着数据 返回视图路径
 *2.String 返回视图路径 官方推荐此种方式 解耦 数据 视图分离 mvc
 *3.void ajax请求 json数据格式 跳转视图使用原生态的Servlet语句 getRequestDispatcher
 */
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	//value相当于一个命名空间 即访问该controller下的所有方法都要带上这个命名空间
	//在没有这个注解之前由action层service层配合web.xml进行处理
	//现在一切的核心配置都在spring容器之中
	//点击链接之后跳转到视图 现在就是在点击修改之后
	//跳转到item.Edit.action然后改路径已经和WEB-INF/jsp/itemList.jsp相绑定
	@RequestMapping(value="/item/itemlist.action")
	
	public ModelAndView itemList() {
		
		List<Items> list = itemService.selectItemsList();
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("itemList", list);
		//在spring/mvc层中已经将jsp页面进行拼装返回的时候返回的是相关路径之中的值
		mav.setViewName("itemList");
		return mav;
	}
	//绑定默认类型 根据id查询商品信息
/*	@RequestMapping(value="/itemEdit.action")
	public ModelAndView toEdit(HttpServletRequest request,HttpServletResponse response
			,HttpSession session,Model model ) {
		//Servlet
		String id = request.getParameter("id");
		
		//查询一个商品
		Items items = itemService.selectItemsById(Integer.parseInt(id));
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", items);
		//跳转视图 完整的视图名已经在springmvc.xml中进行配置过
		mav.setViewName("editItem");
		return mav;
	}*/
	
	//绑定基本类型
	//直接在参数类型之中设置 会自动获取到页面传输的值 然后对值进行处理
	//但是前提是在页面中传输的值 是指定取得的
	//如果跟传输的值不一致的情况就要使用@RequestParam(value = "id")进行手动绑定
	//之后integer什么类型都是可以正常使用的
	//这样做之后 传值是就成了必须的  如果不想传值得话 设置@RequestParam(value="id",required=false)
	//但是没有值传进来就要考虑设置分页 提供一个默认值 @RequestParam(value="id",required=false,defaultValue="1")
	@RequestMapping(value="/itemEdit.action")
	public ModelAndView toEdit(Integer id,HttpServletRequest request,HttpServletResponse response
			,HttpSession session,Model model ) {
		//Servlet
		//String id = request.getParameter("id");
		
		//查询一个商品
		Items items = itemService.selectItemsById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", items);
		//跳转视图 完整的视图名已经在springmvc.xml中进行配置过
		mav.setViewName("editItem");
		return mav;
	}
	
	//提交修改页面 入参为Items对象
	//页面name属性的name与items中属性的名字一致 updateitem.action
/*	@RequestMapping(value="/updateitem.action")
	public ModelAndView updateItem(Items items) {
		
		//修改
		itemService.updateItemsById(items);
		
		ModelAndView mav = new ModelAndView();
		//update 没有返回类型 不用进行传递
		//mav.addObject();
		mav.setViewName("success");
		return mav;
	}*/
/*	@RequestMapping(value="/updateitem.action")
	public ModelAndView updateItem(QueryVo vo) {
	//注意跟QueryVo没有关系  而是跟其中的Items的属性有关系
		//所以跟上面不同 上面是直接去items中调用 现在要经过一层queryvo  所以现在需要将
		//表单中的name等属性修改为 前面加上items.{
		
		//修改
		itemService.updateItemsById(vo.getItems());
		
		ModelAndView mav = new ModelAndView();
		//update 没有返回类型 不用进行传递
		//mav.addObject();
		mav.setViewName("success");
		return mav;
	}*/
	
	
	@RequestMapping(value = "/updateitem.action")
//	public ModelAndView updateitem(Items items){
	public String updateItem(QueryVo vo,MultipartFile pictureFile){

			
		//保存图片到d盘 D:\\upload
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		//获取文件的扩展名
		String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
		try {
			pictureFile.transferTo(new File("D:\\upload\\" + name + "." +ext));
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		vo.getItems().setPic(name + "." +ext);
		//修改
		itemService.updateItemsById(vo.getItems());
		
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("success");
		//return mav;
		//return "forward:/item/itemlist.action";  //如果返回值是String类型  那么就使用这句话
		return "redirect:/itemEdit.action?id="+vo.getItems().getId();
		
	}
	//删除多个商品
	@RequestMapping(value="/deletes.action")
	//注意  在jsp页面中的form中创建了一个选择框 其中的形参是ids
	//ids就是选择的一个或者多个商品的id号  现在用一个integer类型的数组进行接收
	//但是为什么会取得前端页面传输的值呢 springmvc会默认帮我们绑定  如果有特殊需求需要名称不一样  看上面代码块中的解决方法
	public ModelAndView deletes(Integer ids) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
/*	//使用包装类型删除多个商品
	@RequestMapping(value="/deletes.action")
	//我们在进行参数绑定的时候 完全可以在pojo层创建一个类 这个类负责接收页面传过来的值
	//在进行绑定的时候就可以直接利用相关的pojo  进行值得获取 取值的时候记得调用vo.getIds()方法
	//queryvo中将会接受到一个数组
	public ModelAndView deletes(QueryVo vo) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}*/
	//去登录
	//外界响应时 跳转到登录页面进行登录
	@RequestMapping(value="/login.action",method=RequestMethod.GET)
	public String login() {
		
		return "login";
	}
	//登录完成之后
	//在登陆页面点击提交之后 将用户名注入到session中 然后跳转到list主界面
	@RequestMapping(value="/login.action",method=RequestMethod.POST)
	public String login(String username,HttpSession httpSession) {
		httpSession.setAttribute("USER_SESSION", username);
		return "redirect:/item/itemlist.action";
	}
}
