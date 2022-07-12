<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cart</title>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
</head>
<body Style="padding= 20px">
		<form class ="pure-form">
			<fieldset>
			
			  <legend>Cart</legend>
			  ${sessionScope.products }
			  
			  <p />
			  
			   <button type="button"
							onclick=location.href='/JavaWeb-20220418/servlet/cart/clear';
							class="pure-button pure-button-primary">
	
	            clear
	         </button>
	          <button type="button"
							onclick=location.href='/JavaWeb-20220418/jsp/cart/buy.jsp';
							class="pure-button pure-button-primary">
	 
	   
	  		  back
	         </button>
			
			
			
			
			</fieldset>
		
		
		
		
		</form>
		

</body>
</html>