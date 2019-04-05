package pandy.test;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//import com.utils.Md5;

public class CheckLoginServlet2 extends GenericServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text.html;charset=UTF-8");
		PrintWriter pw	= resp.getWriter();
		String id = null!=req.getParameter("id")?req.getParameter("id"):"";
		String name = null !=req.getParameter("name")?req.getParameter("name"):"";
		//String mipwd=Md5.tomd5(upwd);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","123");
			PreparedStatement ps= con.prepareStatement("select * from admin where id=?and name=? limit 1");
			ps.setString(1, id);
			ps.setString(2, name);
			ResultSet rs = ps.executeQuery();
			System.out.println(id+name);
			
			if(rs.next()) {
				 pw.println("<script>alert('yes');window.location='success.html';</script>");
			}
			else {
				pw.print("<script>alert('no');window.location='index.html';</script>");
			}
			
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}

}
