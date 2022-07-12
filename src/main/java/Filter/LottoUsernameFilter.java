package Filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/servlet/lotto"})//定義要管理的URL
public class LottoUsernameFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		   System.out.println("執行 LottoUserNameFilter");
		   req.setCharacterEncoding("utf-8");
		   res.setContentType("text/html;charset=urt-8");
		   res.setCharacterEncoding("utf-8");
		   
		   //PrintWriter out =res.getWriter();
		   //out.print("我是 LottoUserNameFilter");
		   chain.doFilter(req, res);
	}

	 
	 
	
	

}
