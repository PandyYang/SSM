package pandy.test.a_interceptor;



import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

//拦截器第三种实现方式
//方法过滤拦截器 功能：定制过滤器拦截的方法 定制那些方法需要拦截 还可以定制那些方法不需要拦截
public class MyInterceptor3 extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//前处理
		System.out.println("MyInterceptor3的前处理");
		
		//放行-->递归调用链一直调用下去
		invocation.invoke();//invoke 的英文意思 引起
		
		//后处理
		System.out.println("MyInterceptor3的后处理");
		
		//不放行 直接跳转到一个结果页面 不执行后续的拦截器以及Action 直接交给result 处理结果
		return "success";
	}

}
