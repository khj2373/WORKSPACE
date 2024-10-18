package com.kh.etc.opendata.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Run {
	public static final String SERVICE_KEY = "bYzy%2FtI5HWyhhmM1xluWrsyIwTpkUhJoFYWwha3QarWzJx3Pk9JIhzV50TiEojGuY6Nu8%2FWtoHAfp0IPnZiP%2Bg%3D%3D";
	
	public static void main(String[] args) throws IOException {
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		url += "?serviceKey=" + SERVICE_KEY;
		url += "&returnType=json";
		url += "&sidoName=" + URLEncoder.encode("서울", "UTF-8"); //요청값에 한글이 있으면 인코딩 작업 후 전송
		
		//System.out.println(url);
		
		//자바코드로 클라이언트 열할을 해서 서버로 요청을 보낼 때
		//HttpURLConnection객체를 이용해서 요청을 보냄
		
		//1. 요청하고자 하는 url을 전달하면서 java.net.URL객체 생성
		URL requestURL = new URL(url);
		
		//2. 만들어진 URL객체를 가지고 HttpURLConnection 객체 생성
		HttpURLConnection urlConnection = (HttpURLConnection)requestURL.openConnection();
		
		//3. 요청에 필요한 Header정보 생성하기
		urlConnection.setRequestMethod("GET");
		
		//4. 해당 API서버로 요청 보낸 후에 입력 데이터 읽어오기
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		String result = "";
		String line;
		while((line = br.readLine()) != null) {
			result += line;
		}
		System.out.println(result);
	}
}