package l.io.ex3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileChar {
	/*
	 * "문자기반 스트림"을 활용한 입출력
	 * 
	 * -문자기반스트림 : 데이터를 2바이트 단위로 전송하는 통로
	 * 
	 * xxxReader : 입력용 스트림
	 * xxxWriter : 출력용 스트림
	 */
	
	public void fileSave() {
		//1. 객체생성
		try(FileWriter fw = new FileWriter("char_test.txt", true);) {
			//2. writer메소드를 활용하여 데이터 출력
			fw.write("IO가 너무너무 재밌다");
			fw.write("\n");
			fw.write("HI");
			fw.write(" ");
			
			char[] arr = {'저', '는', ' ', '김', '현', '준', '입', '니', '다'};
			fw.write(arr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		try(FileReader fr = new FileReader("char_test.txt");) {
			
			int value = 0;
			while((value = fr.read()) != -1) {
				System.out.print((char)value);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
