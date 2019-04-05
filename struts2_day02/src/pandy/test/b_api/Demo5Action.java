package pandy.test.b_api;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Demo5Action extends ActionSupport {

	@Override
	public String execute() throws Exception {
		//request域=》map
		//不推荐使用
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		//推荐使用
		ActionContext.getContext().put("name", "requestname!");
		//session域=>map
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("name", "sessionname");
		//application域=>map
		Map<String, Object> application = ActionContext.getContext().getApplication();
		application.put("name", "applicationname");
		return SUCCESS;
	}
	
}
