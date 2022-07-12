package Filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/servlet/area")
//若要針對同一個URL 自訂Filter的順序,不可使用@WebFilter 配置,必須要在 web.xml中手動配置
public class AreaFilterA extends HttpFilter{

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		 System.out.println("AreaFilterA");
		 chain.doFilter(req, res);
	}
	
	

}
