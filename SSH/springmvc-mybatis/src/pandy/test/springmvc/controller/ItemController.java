package pandy.test.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView updateItem(QueryVo vo){

		//修改
		itemService.updateItemsById(vo.getItems());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
		
	}
	
	
}
