package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//WebServlet 配置資訊
@WebServlet("/servlet/TimeStampServlet")

public class TimeStampServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {//既成一個通用型的servlet
		 Date today = new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss E");// a是判定上午下午 E是日期
		 String todayString = sdf.format(today);
		 System.out.println(todayString);
		 
		 //邊寫到http的第四層
		 
		 //Server  端編碼utf-8
		 res.setCharacterEncoding("utf-8");
		 //Server端回應給瀏覽器的文件格式與編碼
		 res.setContentType( "text/html;charset=urf-8");//告訴brower的瀏覽器是文字編碼
		 //res.setContentType("text/image);
		 //res.setContentType("application/octet-stream");
		 PrintWriter out = res.getWriter();
		 out.println("<HTML>");
		 out.println("<HEAD>");
		 //out.println("<meta charset='utf-8'>");
		 out.println("</HEAD>");
		 
		 
		 out.println("<BODY>");
		 out.println("<H1 Style='color:red'>");
		 out.println(todayString);
		 out.println("</H1>");
		 out.println("<BODY>");
		 out.println("</HTML>");
		 
		 
		 
		
	}

}
