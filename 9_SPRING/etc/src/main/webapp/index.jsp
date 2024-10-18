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
<body onload="init()">
	<h1>실시간 대기오염 정보</h1>

    지역 :
    <select id="location">
        <option>서울</option>
        <option>대전</option>
        <option>대구</option>
        <option>부산</option>
    </select>

    <button id="btn1" class="btn btn-sm btn-primary" onclick="getAirStatusHandler()">해당지역 대기오염 정보</button>

    <br><br>

    <table class="table" id="result">
        <thead>
            <tr>
                <th>측정소명</th>
                <th>측정일시</th>
                <th>통합대기환경수치</th>
                <th>미세먼지농도</th>
                <th>일산화탄소농도</th>
                <th>일산화질소농도</th>
                <th>오존농도</th>
            </tr>
        </thead>
        <tbody>

        </tbody>
    </table>

    <script>
        function init(){
			document.getElementById("btn1").click();
		}

        function getAirStatusHandler(){
            //지역명 포함해서 서버로 ajax요청
            const location = document.querySelector("#location").value;

            getAirStatus({location: location}, function(airStatusList){
                const itemList = airStatusList.response.body.items;

                drawAirBody(document.querySelector("#result tbody"), itemList)
            })
        }

        function getAirStatus(data, callback){
            $.ajax({
                url: "air",
                data: data,
                success : function(result){
                    callback(result)
                },
                error: function(){
                    console.log("대기정보 api 요청 실패")
                }
            })
        }

        function drawAirBody(parent, itemArr){
            parent.innerHTML = "";

            for(const item of itemArr){
                parent.innerHTML += ("<tr>"
                                        + "<td>" + item.stationName + "</td>"
                                        + "<td>" + item.dataTime + "</td>"
                                        + "<td>" + item.khaiValue + "</td>"
                                        + "<td>" + item.pm10Value + "</td>"
                                        + "<td>" + item.coValue + "</td>"
                                        + "<td>" + item.noValue + "</td>"
                                        + "<td>" + item.o3Value + "</td>"
                                    + "<td>")
            }
        }
    </script>
</body>
</html>