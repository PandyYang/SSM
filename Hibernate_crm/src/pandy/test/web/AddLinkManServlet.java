package pandy.test.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import pandy.test.domain.LinkMan;
import pandy.test.service.LinkManService;
import pandy.test.service.impl.LinkManServiceImpl;

/**
 * Servlet implementation class AddLinkManServlet
 */
public class AddLinkManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LinkManService lms = new LinkManServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLinkManServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		/*//1>获得参数并封装到LinkMan对象中
		LinkMan lm = new LinkMan();
		try {
			BeanUtils.populate(lm,request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2>调用service保存LinkMan对象
		lms.save(lm);
		//3>重定向到LinkMan的列表中
		response.sendRedirect(request.getContextPath()+"/ListLinkManServlet");*/
		
		
		
		//1> 获得参数并封装LinkMan对象中
				LinkMan lm = new LinkMan();
				try {
					BeanUtils.populate(lm, request.getParameterMap());//获取reques的键值关系 如果键有值得话  将值赋给lm
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				//2> 调用Service保存LinkMan对象
				lms .save(lm);
				//3> 重定向到LinkMan的列表(404)
				response.sendRedirect(request.getContextPath()+"/ListLinkManServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
