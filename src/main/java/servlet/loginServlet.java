package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	

	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//將重蹈命令直接由server 端來執行
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/login_form.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		  doHandle(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		doHandle(req, resp);
	}
	

}
