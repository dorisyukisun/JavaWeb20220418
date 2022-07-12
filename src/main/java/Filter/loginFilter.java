package Filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/report/*", "/jsp/cart/*"})
public class loginFilter extends HttpFilter{

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)throws IOException, ServletException {
		 //1.判斷是否此人已經登入
		HttpSession session = req.getSession();
		Object data =session.getAttribute("pass");
		//2.判斷此人尚未登入或是登入已經過時
		if(data == null || Boolean.parseBoolean(data+"") !=true) { 
			//2.1 有把Username ,password  與 usercode 傳遞過來
			String username = req.getParameter("username")+"";
			String password = req.getParameter("password")+"";
			String userCode = req.getParameter("usercode")+"";
			String authCode = session.getAttribute("authCode")+"";
			
			if(username.equals("admin") && password.equals("1234") && userCode.equals(authCode)) {
				//寫入驗證通過Session資料
				session.setAttribute("pass",true);
				//通過驗證
				chain.doFilter(req, resp);
			 
			}else{
			//2.2重導到登入頁面
			RequestDispatcher  rd = req.getRequestDispatcher("/login");
			rd.forward(req, resp);
			}
			}else{
			//3.通過驗證
			chain.doFilter(req, resp);
		}
	}

		}
