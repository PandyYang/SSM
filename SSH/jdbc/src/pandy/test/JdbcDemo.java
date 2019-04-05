package pandy.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class JdbcDemo {
	public static void main(String[] args){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet resultset = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?character"
						+ "Encoding=utf-8", "root", "123");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sql="select * from user where username=?";
			try {
				pstmt= (PreparedStatement) conn.prepareStatement(sql);
				pstmt.setString(1, "ÍõÎå");
				resultset = pstmt.executeQuery();
				while(resultset.next()) {
					System.out.println(resultset.getString("id")+""+resultset.getString("username"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
}