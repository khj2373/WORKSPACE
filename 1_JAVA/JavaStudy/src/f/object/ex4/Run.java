package f.object.ex4;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		// choi객체 생성 최지원, 15, 수학 : 70, 영어 : 60, 국어 : 80
		// kim객체 생성 김현준, 18, 수학 : 50, 영어 : 95, 국어 : 70
		
//		Student choi = new Student("최지원", 15, 70, 60, 80);
//		Student kim = new Student("김현준", 18, 50, 95, 70);
//		
//		//choi의 모든 과목의 평균을 출력
//		System.out.println(choi.getName() + "님의 평균 : " + choi.getEvg());
//		System.out.println(kim.getName() + "님의 평균 : " + kim.getEvg());
//		choi.printEvg();
		
		//사용자로부터 이름, 나이 영어점수, 수학점수, 국어점수를 입력받아
		//평균을 구하고 출력하는 프로그램 작성
		
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		
		System.out.print("국어 : ");
		int ko = sc.nextInt();
		
		Student choi = new Student(name, age, math, eng, ko);
		
		choi.printEvg();
		
		sc.close();
	}

}
