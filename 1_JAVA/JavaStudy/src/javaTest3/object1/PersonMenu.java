package javaTest3.object1;

import java.util.Scanner;

public class PersonMenu {
	private Scanner sc = new Scanner(System.in);
	private PersonController pc = new PersonController();

	public void mainMenu() {
		while (true) {
			int[] pCnt = pc.personCount();
			for (int i = 0; i <= 1; i++) {
				if (i == 0) {
					System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
					System.out.println("현재 저장된 학생은 " + pCnt[i] + "명 입니다.");
				} else {
					System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
					System.out.println("현재 저장된 사원은 " + pCnt[i] + "명 입니다.");
				}
			}

			System.out.println("1. 학생 메뉴");
			System.out.println("2. 사원 메뉴");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				studentMenu();
				break;
			case 2:
				employeeMenu();
				break;
			case 9:
				System.out.println("종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		}

	}

	public void studentMenu() {
		while (true) {
			int[] pCnt = pc.personCount();

			if (pCnt[0] < 3) {
				System.out.println("1. 학생 추가");
			} else {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가 메뉴는 더 이상 활성화 되지 않습니다.");
			}

			System.out.println("2. 학생 보기");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int choice = sc.nextInt();
			if (pCnt[0] < 3) {
				switch (choice) {
				case 1:
					insertStudent();
					break;
				case 2:
					printStudent();
					break;
				case 9:
					System.out.println("메인으로 돌아갑니다.");
					return;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					break;
				}
			} else {
				switch (choice) {
				case 2:
					printStudent();
					break;
				case 9:
					System.out.println("메인으로 돌아갑니다.");
					return;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					break;
				}
			}

		}
	}

	public void employeeMenu() {
		while (true) {
			int[] pCnt = pc.personCount();

			if (pCnt[1] < 10) {
				System.out.println("1. 사원 추가");
			} else {
				System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가 메뉴는 더 이상 활성화 되지 않습니다.");
			}

			System.out.println("2. 사원 보기");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int choice = sc.nextInt();
			if (pCnt[1] < 10) {
				switch (choice) {
				case 1:
					insertEmployee();
					break;
				case 2:
					printEmployee();
					break;
				case 9:
					System.out.println("메인으로 돌아갑니다.");
					return;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					break;
				}
			} else {
				switch (choice) {
				case 2:
					printEmployee();
					break;
				case 9:
					System.out.println("메인으로 돌아갑니다.");
					return;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					break;
				}
			}

		}

	}

	public void insertStudent() {
		while(true) {
			int[] pCnt = pc.personCount();
			if(pCnt[0] < 3) {
				System.out.print("학생 이름 : ");
				String name = sc.next();
				System.out.print("학생 나이 : ");
				int age = sc.nextInt();
				System.out.print("학생 키 : ");
				double height = sc.nextDouble();
				System.out.print("학생 몸무게 : ");
				double weight = sc.nextDouble();
				System.out.print("학생 학년 : ");
				int grade = sc.nextInt();
				System.out.print("학생 전공 : ");
				String major = sc.next();
				pc.insertStudent(name, age, height, weight, grade, major);
			} else {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생 메뉴로 돌아갑니다.");
				return;
			}
			System.out.print("그만 하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			String choice = sc.next();
			if(choice.equals("N") || choice.equals("n")) {
				break;
			}
		}
		

	}

	public void printStudent() {
		Student[] print = pc.printStudent();
				for(Student i : print) {
					if(i == null) {
						break;
					}
					System.out.println(i.toString());
				}

	}

	public void insertEmployee() {
		while(true) {
			int[] pCnt = pc.personCount();
			if(pCnt[1] < 10) {
				System.out.print("사원 이름 : ");
				String name = sc.next();
				System.out.print("사원 나이 : ");
				int age = sc.nextInt();
				System.out.print("사원 키 : ");
				double height = sc.nextDouble();
				System.out.print("사원 몸무게 : ");
				double weight = sc.nextDouble();
				System.out.print("사원 급여 : ");
				int salary = sc.nextInt();
				System.out.print("사원 부서 : ");
				String dept = sc.next();
				pc.insertEmployee(name, age, height, weight, salary, dept);
			} else {
				System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가를 종료하고 사원 메뉴로 돌아갑니다.");
				return;
			}
			System.out.print("그만 하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			String choice = sc.next();
			if(choice.equals("N") || choice.equals("n")) {
				break;
			}
		}

	}

	public void printEmployee() {
		Employee[] print = pc.printEmployee();
		for(Employee i : print) {
			if(i == null) {
				break;
			}
			System.out.println(i.toString());
		}

	}
}
