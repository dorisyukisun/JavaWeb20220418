<%@ page import="entity.Employee" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!	// 加上!是可以在jsp裡面當function 呼叫
		 static List<Employee> employees = new ArrayList();
		 class Employee {
			 String name;
			 int salary;
			 boolean fulltime;
			 Employee(String name, int salary, boolean fullTime){
				 this.name = name; this.salary = salary;this.fulltime = fullTime;
		 }
}
		public void jspInit() { 
		 	employees.add(new Employee("Mary" ,42000, true));
			employees.add(new Employee("John" ,35000, false));
			employees.add(new Employee("Bob" ,72000, true));
			employees.add(new Employee("Alice" ,28000, false));
			employees.add(new Employee("Jim" ,55000, true));
	
		}
		
			List<Employee> getEmployees() {
				return employees;
	
	}

%>
<%
//取得表單傳來的資料
 
   String flag = request.getParameter("flag");
    //判斷 flag 是否有資料
    if(flag != null){

    	String name = request.getParameter("name");
        String salary =request.getParameter("salary");
        String fullTime =request.getParameter("fullTime");
    	//建立 employee 物件
    	Employee emp = new Employee(name,Integer.parseInt(salary),(fullTime == null ? false:true));
    	//將表單資料加入集合
    	employees.add(emp);
    }
	


%>
<!DOCTYPE html>

<html>
<head>


<meta charset="UTF-8">
<title>員工薪資表</title>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['table']});
      google.charts.setOnLoadCallback(drawBegin);
      
      function drawBegin(){
    	 drawTable();
    	 drawChart();
      }

      function drawTable() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Name');
        data.addColumn('number', 'Salary');
        data.addColumn('boolean', 'Full Time Employee');
        data.addRows([
        	<% for(Employee emp : getEmployees()) {%>
        		['<%=emp.name %>,<%=emp.salary %>, <%=emp.fulltime%>'], 
        	<%} %>
          ['Mike', 10,000, true],
           
        ]);

        var table = new google.visualization.Table(document.getElementById('table_div'));

        table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
        google.visualization.events.addListener(table, 'select', selectHandler);

      }
      function SelectHandler(e){
    	  alert('A table row was selected:'+ e);
    	  console.log(e);
      }
       function drawChart(){
    	   var data = google.visualization.arrayToDataTable([
               ['Name', 'Salary'],
               <% for(Employee emp : getEmployees()) {%>
       		['<%=emp.name %>,<%=emp.salary %>, <%=emp.fulltime%>'], 
       	<%} %>  
      ]};
      
      var barchart = new google.visualization.BarChart(document.getElementById('barchart'));
      
      barchart.draw(data, options);
      
	}
      
    </script>

 

</head>

<body style = "padding:15px">
		<form class= "pure-form" method="post">
		<legend> Employee From</legend>
		<input type="text" placeholder="請輸入名稱" name="name" /><p/ >
		<input type="number" placeholder="請輸入薪資" name="salary" /><p/ >
		<input type="checkbox"  value="ture" name= "fullTime" />Full-time<p/ >
		<input type="hidden" value ="ture" name="flag" />
		<button type="submit" class="pure-button pure-button-primary">Add</button>	
		</form>
	 <div id ="table_div"></div>
</body>
</html>