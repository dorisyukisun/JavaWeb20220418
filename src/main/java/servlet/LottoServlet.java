package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LottoService;

@WebServlet("/servlet/lotto")
public class LottoServlet extends HeaderServlet{
	
	private LottoService lottoService;
	
	@Override
	public void init() throws ServletException{
		lottoService = new LottoService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 //接收參數
		 int count = Integer.parseInt(req.getParameter("count"));
		 //產生lotto數字
		 List<Integer> lottos = lottoService.getLottos(count);
		 /*List<Integer> lottos = new ArrayList<>();
		 Random random = new Random();
		 for(int i=0; i<count;i++) {
			 lottos.add(random.nextInt(100)); //0-99			 
			  }*/
		 //透過重導到html/lotto_result.jsp 頁面並將lottos 物件傳進
		 req.setAttribute("lottos",lottos); //"lottos"=jsp裡面的${lottos}
		 RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/lotto_result.jsp");
		 rd.forward(req, resp);
	}

	
}
