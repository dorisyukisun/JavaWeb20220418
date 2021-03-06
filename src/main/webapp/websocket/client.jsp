<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>	
<html>
<head>
	<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<meta charset="UTF-8">
<title>WebSocket 聊天室</title>
<script>
		//當網頁元件載入完成之後才執行
		window.onload = function(){
			var webSocket = null;
			//獲取 DOM元件
			var username = document.getElementById("username");
			var loginBtn = document.getElementById("loginBtn");
			var chatRoomForm = document.getElementById("chatRoomForm");
			var messageInput = document.getElementById("messageInput");
			var count =document.getElementById("count");
			
			// 註冊元件的監聽器
			loginBtn.addEventListener("click", function() {
				setWebSocket();
			});
			
			// Form 表單內的 submit button 監聽 
			chatRoomForm.addEventListener("submit", function() {
				sendMessage();
			});
			
				
			
			//設置WebSocket
			function setWebSocket(){
				var url = 'ws://' + window.location.hostname + ':8080${pageContext.request.contextPath}/websockettest'
				//開始 WebSocket連線
				webSocket = new WebSocket(url);
				//以下可以開始偵測 WebSocket的各種事件
			    //連線成功
			    
			    webSocket.onOpen =function(event)
			    {
					console.log('連線成功');
					//關閉username 不可輸入
					username.disabled = true;
					//關閉loginBtn 
					loginBtn.disabled = true;
					var message = {
						username: username.value,
						message: '大家好,我進來摟'
					};
					// JSON.stringfly 將message 物件轉成json字串
					 webSocket.send(JSON.stringfly(message));
				};
				//連線失敗
				WebSocket.onerror = function(event)
				{
					console.log('連線失敗');
				};
				//接收訊息
				webSocket.onmessage = function(event)
				{	//JSON.parse 將JSON字串轉成物件,以便分析
					var messageObject = JSON.parse(event.data);
					console.log(messageObject);//訊息資料 object是物件
					//messageDisplay.innerHTML += messageObject.username + " 說: " +  messageObject.message + "<br>";
					if(messageObject.username == '_count'){
						count.innerHTML = messageObject.message;
					}else{
							var content = messageObject.username + " 說: " +  messageObject.message + "<br>";
							messageDisplay.insertAdjacentHTML('afterbegin', content);
					} 
				};
				
				
			}
				
				/// 傳送訊息	
			function sendMessage() {	
				// 檢查 WebSocket 的狀態	
				if(webSocket) {	
					var message = {	
						username: username.value,	
						message: messageInput.value	
					};	
					webSocket.send(JSON.stringify(message));	
				} else {	
					alert('Socket 尚未登入');	
				}	
			}	
		
		}


</script>
</head>
<body style="padding:10px">
			<form class="pure-form" id="chatRoomForm" onsubmit="return false;">
			<fieldset>
				<legend>WebSocket Client(人數: <span id="count">0</span>)</legend>
				<input type="text" id="username" placeholder="請輸入名稱">
				<button type="button" class="pure-button pure-button-primary" id="loginBtn">
					Socket 登入
				</button>
				<p />
				<input type="text" id="messageInput" placeholder="請輸入名稱">
				<button type="submit" class="pure-button pure-button-primary">
					送出訊息 
				</button>
				
		   </fieldset>
		</form>
		<div id="messageDisplay"></div>
</body>
</html>