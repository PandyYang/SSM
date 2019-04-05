package pandy.test.d_springaop;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pandy.test.c_service.UserService;
//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器时使用哪个配置文件
@ContextConfiguration("classpath:pandy/test/d_springaop/applicationContext.xml")
public class Demo {
	//将名为user的对象注入到u变量中
	@Resource(name="userServiceTarget")
	private UserService us;
	@Test
	public void fun1() {
		
		us.save();
	}
}
