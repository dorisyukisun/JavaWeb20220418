package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConnectionListener implements ServletContextListener {

	
	//Server 啟動時要執行的程式
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Tomcat啟動中");
		//資料庫放置位置
		String db_path ="/Users/doris/eclipse-workspace/JavaWeb-20220418/DB";
		//資料庫名稱
	    String db_name="webdb.db";
		//建立資料庫連線參數
		String db_url = "jdbc:sqlite:"+db_path +"/"+db_name;
	    //資料庫連線物件
				 Connection conn = null;
				 try
				 {
				  //建立 driver
					 Class.forName("");
					 conn = DriverManager.getConnection(db_url);
					 //將conn 物件放到context(Application)scope 變數中
					 sce.getServletContext().setAttribute("conn", conn);
					
			     }catch(Exception e) {
			    	 e.printStackTrace();
					 
			     }

	 
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		 Object connObj =sce.getServletContext().getAttribute("conn");
		 if(connObj !=null) {
			 try {
				 if(connObj instanceof Connection) {
					 ((Connection)connObj).close();
					 System.out.println("conn 物件 已關閉");
				 }
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
		 }
	}

}
