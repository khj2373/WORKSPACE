<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="login">
		<input type="submit" value="로그인">
		<input type="button" onclick="naverLogin()" value="네이버 로그인">
	</form>
	
	<script>
		function naverLogin(){
			const clientId="APZ3vX5XxNp986ez6qw5";
			//리다이렉트 URL을 UTF-8로 인코딩해서 저장
			const redirectURL = encodeURIComponent("http://localhost:7777/etc/naver-login");

			const state = Math.random().toString(36).substring(2);

			let apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
			apiURL += "&client_id=" + clientId;
			apiURL += "&redirect_uri=" + redirectURL;
			apiURL += "&state=" + state;

			location.href = apiURL;
		}
	</script>
</body>
</html>