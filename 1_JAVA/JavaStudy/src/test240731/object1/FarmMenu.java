package test240731.object1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FarmMenu {
	private Scanner sc = new Scanner(System.in);
	private FarmController fc = new FarmController();
	
	public void mainMenu() {
		System.out.println("========== KH 마트 ==========");
		
		while(true) {
			System.out.println("\n******* 메인 메뉴 *******");
			
			System.out.println("1. 직원 메뉴");
			System.out.println("2. 손님 메뉴");
			System.out.println("9. 종료");
			
			System.out.print("메뉴 번호 선택 : ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				adminMenu();
				break;
			case 2:
				customerMenu();
				break;
			case 9:
				System.out.println("프로그램 종료.");
				return;
			default :
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}	
	}
	
	public void adminMenu() {
		while(true) {
			System.out.println("\n******* 직원 메뉴 *******");
			
			System.out.println("1. 새 농산물 추가");
			System.out.println("2. 종류 삭제");
			System.out.println("3. 수량 수정");
			System.out.println("4. 농산물 목록");
			System.out.println("9. 메인으로 돌아가기");
			
			System.out.print("메뉴 번호 선택 : ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				addNewKind();
				break;
			case 2:
				removeKind();
				break;
			case 3:
				changeAmount();
				break;
			case 4:
				printFarm();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				return;
			default :
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}			
	}
	
	public void customerMenu() {
		while(true) {
			System.out.println("\n******* 직원 메뉴 *******");
			
			System.out.println("1. 농산물 구매");
			System.out.println("2. 농산물 빼기");
			System.out.println("3. 구입한 농산물 보기");
			System.out.println("9. 메인으로 돌아가기");
			
			System.out.print("메뉴 번호 선택 : ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				buyFarm();
				break;
			case 2:
				removeFarm();
				break;
			case 3:
				printBuyFarm();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				return;
			default :
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
		
	}
	
	public void addNewKind() {
		while(true){
			System.out.println("\n1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("추가할 종류 번호 : ");
			int kind = sc.nextInt();
			sc.nextLine();
			
			if(kind != 1 && kind != 2 && kind != 3) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				continue;
			}
		
		
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("수량 : ");
			int amount = sc.nextInt();
			sc.nextLine();
			
			Farm f = null;
			boolean isTrue = false;
			switch(kind) {
			case 1:
				f = new Fruit("과일", name);
				break;
			case 2:
				f = new Vegetable("채소", name);
				break;
			case 3:
				f = new Nut("견과", name);
			}
			
			isTrue = fc.addNewKind(f, amount);
			if(isTrue) {
				System.out.println("새 농산물이 추가되었습니다.");
				break;
			} else {
				System.out.println("새 농산물 추가에 실패하였습니다.");
			}
		}
	}
	
	public void removeKind() {
		while(true) {
			System.out.println("\n1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("삭제할 종류 번호 : ");
			int kind = sc.nextInt();
			sc.nextLine();
			
			if(kind != 1 && kind != 2 && kind != 3) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				continue;
			}
			
			System.out.print("이름 : ");
			String name = sc.nextLine();
			
			Farm f = null;
			boolean isTrue = false;
			switch(kind) {
			case 1:
				f = new Fruit("과일", name);
				break;
			case 2:
				f = new Vegetable("채소", name);
				break;
			case 3:
				f = new Nut("견과", name);
			}
			
			isTrue = fc.removeKind(f);
			if(isTrue) {
				System.out.println("농산물 삭제에 성공하였습니다.");
				break;
			} else {
				System.out.println("농산물 삭제에 실패하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void changeAmount() {
		while(true) {
			System.out.println("\n1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("변경할 종류 번호 : ");
			int kind = sc.nextInt();
			sc.nextLine();
			
			if(kind != 1 && kind != 2 && kind != 3) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				continue;
			}
			
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("변경 수량 : ");
			int amount = sc.nextInt();
			sc.nextLine();
			
			Farm f = null;
			boolean isTrue = false;
			switch(kind) {
			case 1:
				f = new Fruit("과일", name);
				break;
			case 2:
				f = new Vegetable("채소", name);
				break;
			case 3:
				f = new Nut("견과", name);
			}
			
			isTrue = fc.changeAmount(f, amount);
			if(isTrue) {
				System.out.println("농산물의 수량이 변경되었습니다.");
				break;
			} else {
				System.out.println("농산물 수량변경에 실패하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void printFarm() {
		HashMap<Farm, Integer> farmMap = fc.printFarm();
		System.out.println("현재 KH마트 농산물 수량");
		for(Farm f : farmMap.keySet()) {
			System.out.printf("%s(%d개)\n", f.toString(), farmMap.get(f));
		}
	}
	
	public void buyFarm() {
		while(true){
			System.out.println("\n1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("구매할 종류 번호 : ");
			int kind = sc.nextInt();
			sc.nextLine();
			
			if(kind != 1 && kind != 2 && kind != 3) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				continue;
			}
		
		
			System.out.print("이름 : ");
			String name = sc.nextLine();;
			
			Farm f = null;
			boolean isTrue = false;
			switch(kind) {
			case 1:
				f = new Fruit("과일", name);
				break;
			case 2:
				f = new Vegetable("채소", name);
				break;
			case 3:
				f = new Nut("견과", name);
			}
			
			isTrue = fc.buyFarm(f);
			if(isTrue) {
				System.out.println("구매에 성공하였습니다.");
				printFarm();
				break;
			} else {
				System.out.println("마트에 없는 물건이나 수량이 없습니다.");
			}
		}
	}
	
	public void removeFarm() {
		while(true){
			System.out.println("\n1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("취소할 종류 번호 : ");
			int kind = sc.nextInt();
			sc.nextLine();
			
			if(kind != 1 && kind != 2 && kind != 3) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				continue;
			}
		
		
			System.out.print("이름 : ");
			String name = sc.nextLine();;
			
			Farm f = null;
			boolean isTrue = false;
			switch(kind) {
			case 1:
				f = new Fruit("과일", name);
				break;
			case 2:
				f = new Vegetable("채소", name);
				break;
			case 3:
				f = new Nut("견과", name);
			}
			
			isTrue = fc.removeFarm(f);
			if(isTrue) {
				System.out.println("구매 취소에 성공하였습니다.");
				printFarm();
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void printBuyFarm() {
		ArrayList<Farm> list = fc.printBuyFarm();
		for(Farm f : list) {
			System.out.println(f.toString());
		}
	}
}
