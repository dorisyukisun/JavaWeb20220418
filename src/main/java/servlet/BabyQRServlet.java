package servlet;

import java.beans.beancontext.BeanContextServiceRevokedListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 得到在 (路徑)的圖片並呈現在網頁上

@WebServlet("/servlet/baby/qr/image")
public class BabyQRServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("image/png"); //可以在網路上找ContentType的PDF  ...就可以出現寫法
		 File file = new File(" ");
		 ServletOutputStream out = resp.getOutputStream();
		 Files.copy(file.toPath(),out);
		 out.close();
		 
	}
	
	

}
