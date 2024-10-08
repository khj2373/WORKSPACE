<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>1. 산술연산</h3>
	기존 : 10 + 3 = <%=(int)request.getAttribute("big") + (int)request.getAttribute("small")%>
	
	<br><br>
	
	EL방식 <br>
	10 + 3 = ${big + small}<br>
	10 - 3 = ${big - small}<br>
	10 * 3 = ${big * small}<br>
	10 / 3 = ${big / small} 또는 ${big div small}<br>
	10 % 3 = ${big % small} 또는 ${big mod small}<br>
	
	<h3>2. 대소비교</h3>
	10 &gt; 3 = ${big > small} 또는 ${big gt small}<br>
	10 &gt; 3 = ${big < small} 또는 ${big lt small}<br>
	10 &gt;= 3 = ${big >= small} 또는 ${big ge small}<br>
	10 &gt;= 3 = ${big <= small} 또는 ${big le small}<br>
	
	<h3>3. 동등비교</h3>
	<!-- el에서는 ==비교는 자바에서의 equals()와 같은 동작 -->
	sOne과 sTwo가 일치합니까? ${sOne == sTwo} 또는 ${sOne eq sTwo}<br>
	sOne과 sTwo가 일치하지 않습니까? ${sOne != sTwo} 또는 ${sOne ne sTwo}<br>
	
	big에 담긴 값이 10과 일치합니까? ${big == 10} 또는 ${big eq 10}<br>
	
	sThree에 담긴 값이 '안녕'과 일치합니까? ${sThree == "HI"} <br><br>
	<!-- el구문 안에서 문자열 리터럴 값은 홀따옴표 쌍따옴표를 가리지 않음 -->
	
	<h4>4. 객체가 null인지 아닌지 리스트가 비어있는지 비교</h4>
	pOne이 null입니까? ${pOne == null} 또는 ${pOne eq null} 또는 ${empty pOne}<br>
	pTwo가 null입니까? ${pTwo == null} 또는 ${pTwo eq null} 또는 ${empty pTwo}<br>
	
	pOne이 null이 아닙니까? ${pOne != null} 또는 ${pOne ne null} 또는 ${not empty pOne}<br>
	pTwo가 null이 아닙니까? ${pTwo != null} 또는 ${pTwo ne null} 또는 ${not empty pTwo}<br>
	
	aOne이 비어있습니까? ${empty aOne}<br>
	aTwo가 비어있습니까? ${empty aTwo}<br><br>
	
	<h4>5. 논리연산자</h4>
	true && true : ${true && true} 또는 ${true and true}<br>
	false && false : ${false && false} 또는 ${false and false}<br>
	
	true || false : ${true || false} 또는 ${true or false}<br>
	
	big이 small보다 크고 aOne이 비어있나?
	${big > small && empty aOne}
	${big gt small and empty aOne}
</body>
</html>