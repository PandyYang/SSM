package pandy.test.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pandy.test.springmvc.pojo.Items;

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
	//value相当于一个命名空间 即访问该controller下的所有方法都要带上这个命名空间
	@RequestMapping(value="/item/itemlist.action")
	//将请求交给handler 处理器映射器  然后这个处理器映射器会返回 包名 方法 类名
	//然后处理器映射器又返回 处理器执行链给 前端控制器  然后执行给
	public ModelAndView itemList() {
		// 创建页面需要显示的商品数据
		List<Items> list = new ArrayList<Items>();
		list.add(new Items(1, "1华为 荣耀8", 2399f, new Date(), "质量好！1"));
		list.add(new Items(2, "2华为 荣耀8", 2399f, new Date(), "质量好！2"));
		list.add(new Items(3, "3华为 荣耀8", 2399f, new Date(), "质量好！3"));
		list.add(new Items(4, "4华为 荣耀8", 2399f, new Date(), "质量好！4"));
		list.add(new Items(5, "5华为 荣耀8", 2399f, new Date(), "质量好！5"));
		list.add(new Items(6, "6华为 荣耀8", 2399f, new Date(), "质量好！6"));
		ModelAndView mav = new ModelAndView();
		//addObject就相当于setAttribute 
		//setAttribute是操作对象类型 setParameter是页面提交参数  
		mav.addObject("itemList", list);
		/*mav.setViewName("/WEB-INF/jsp/itemList.jsp");*/
		mav.setViewName("itemList");
		return mav;
	}
	
}
