package jdbc;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/query/user/record")
public class QueryUserRecord extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String sql = "select id, name, age,createtime from user where id = ?";
		 try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			 pstmt.setInt(1,new Random().nextInt(39)+1);
			 ResultSet rs = pstmt.executeQuery();
			  
			 List<User> users = new ArrayList();
			 int count = 0;
			 while (rs.next()) {
				 User user = new User();
				 user.setId(rs.getInt("id"));
				 user.setName(rs.getString("name"));
				 
				 
			 }
			 //resp.getWriter().print("count ="+
			 //resp.getWriter().print(users);
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
