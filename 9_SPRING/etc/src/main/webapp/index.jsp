<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- JavaScript -->
    <script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>

    <!-- CSS -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
    <!-- Default theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
    <!-- Semantic UI theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css"/>
    <!-- Bootstrap theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/bootstrap.min.css"/>
    
    
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<h3>공공 데이터 활용</h3>
	<h5><a href="detail?page=publicData">view -></a></h5>
	
	<h3>텍스트 에디터 활용</h3>
	<h5><a href="detail?page=summernote">view -></a></h5>
	
	<h3>채팅창 : websocket</h3>
    <h5>닉네임: <input type="text" id="nick"></h5>
	<h5><button onclick="moveChat()">view -></button></h5>
	
	<h3>소셜로그인: 네이버</h3>
	<h5><a href="detail?page=naver">view -></a></h5>
	
	<script>
        function moveChat(){
            const nick = document.querySelector("#nick").value;
            location.href = "detail?page=chat&nick=" + nick;
        }
	</script>
</body>
</html>