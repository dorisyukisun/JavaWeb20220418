package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@WebServlet("/servlet/upload")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 2, //2MB
		maxFileSize =1024 *1024 * 10, // 	10MB
	    maxRequestSize =1024 * 1024 * 50 //50MB
	   
)
public class UploadServlet extends HttpServlet {

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;Charset=8");
		PrintWriter out =resp.getWriter();
		
		//cname, upload_file
		//找到 cname 的值
		req.getParts().stream()
		   .filter(part -> part.getName().equals("cnmae"))
		   .forEach(part ->{
			   try {
				    String cnmae= IOUtils.toString(part.getInputStream(),StandardCharsets.UTF_8.name());
				    out.print(part.getName() + ":" +cnmae);
			   }catch (Exception e) {
				   e.printStackTrace();
			   }
		   });
		
		//找到 upload_file 的值
		//將上傳圖片存放在 C: /upload
		req.getParts().stream()
		.filter (part -> part.getName().equals("upload_file"))
		.forEach(part ->{
			try {
				//製作base64 離線圖片碼
				//將inputStream -> byte[] --> base64 字串
				InputStream is = part.getInputStream();
				byte[] bytes =IOUtils.toByteArray(is);
				String base64 = Base64.getEncoder().encodeToString(bytes);
				// 建立HTML src 標籤 base64 融合
				String imageHtml ="<img src = 'data:image/png; base64, %S'>";
				//建立 HTML src 標籤 base64 融合
				out.print(String.format(imageHtml, base64));
				
				//取得上傳圖片檔名
				String fname = part.getSubmittedFileName();
				//存檔
				part.write("c:/upload/" +fname);
				} catch (Exception e) {
				// TODO: handle exception
			}
		});
		
	}
	
	
	
	

}
