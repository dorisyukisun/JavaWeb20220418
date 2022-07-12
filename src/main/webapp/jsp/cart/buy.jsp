<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy</title>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
<meta charset="UTF-8">
</head>
<body style = "padding:20px">
	<form class=oure-form" method="post" action="/JavaWeb-20220418/servlet/cart/buy">
	
			<fieldset>
			 <legend>Buy</legend>
			 品名:
			 <select name="product">
			    <option value="iphone">iPhone</option>
			   <option value="Android">Android</option>
			     <option value="Bubble">Bubble</option>
			       <option value="SuperMario">SuperMario</option>  
			       <option value="Nintando">Nintando</option>
			  </select> <p />
			  <button type ="submit" class="pure-button pure-button-primary">
			  Buy
			  </button>
			  <button type="button"
							onclick="location.href='/JavaWeb-20220418/servlet/cart/view';"
							class="pure-button pure-button-primary">
	
	         cart
	         </button>
	
	</fieldset>
	
	</form>



</body>
</html>