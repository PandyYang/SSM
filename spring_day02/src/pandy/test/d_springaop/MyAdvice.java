package pandy.test.d_springaop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
	
	//前置通知
	//后置通知（如果出现异常不会调用）
	//环绕通知
	//异常拦截通知
	//后置通知（无论是否出现异常都会调用）
	public void before() {
		
		System.out.println("前置通知");
	}
	public void afterReturning() {
		
		System.out.println("后置通知");
	}
	public Object around( ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("环绕通知之前");
		Object proceed = pjp.proceed();
		System.out.println("环绕通知之后");
		return proceed;
	}
	public void afterException() {
		
		System.out.println("异常拦截通知");
	}
	public void after() {
		
		System.out.println("后置通知");
	}
}
