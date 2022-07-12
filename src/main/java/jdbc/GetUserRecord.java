package jdbc;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//單筆查詢
@WebServlet("/get/user/record")
public class GetUserRecord extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String sql = "select id, name, age,createtime from user where id = ?";
		 try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			 pstmt.setInt(1,new Random().nextInt()+1);//int資料庫筆數
			 ResultSet rs = pstmt.executeQuery();
			 if(rs.next()) {
//				 User.user = new User();
//				 user.setId(rs.getInt("Id"));
//				 user.setName=(rs.getString("name"));
//				 user.setAge(rs.getInt("age"));
//				 user.setCreatetime(rs.getDate("createTime"));
//				 resp.getWriter().print(user);
				 
			 }else {
				 resp.getWriter().print("No record");
			 }
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
