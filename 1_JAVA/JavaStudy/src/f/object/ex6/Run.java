package f.object.ex6;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		
		System.out.print("반 : ");
		int classroom = sc.nextInt();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("신장 : ");
		double height = sc.nextDouble();
		
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0);
		
		Student s1 = new Student(grade, classroom, name, height, gender);
		
		s1.information();
		
		sc.close();

	}

}
