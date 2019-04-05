package pandy.test.b_api;

import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.http11.Http11AprProtocol;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Demo6Action extends ActionSupport {
	//以下方式并不推荐
	@Override
	public String execute() throws Exception {
		
		//原生request
		HttpServletRequest request = ServletActionContext.getRequest();
		//原生session
		HttpSession session = request.getSession();
		//原生response
		HttpServletResponse response = ServletActionContext.getResponse();
		//原生servletContext
		ServletContext servletContext = ServletActionContext.getServletContext();
		return SUCCESS;
	}
	
}
