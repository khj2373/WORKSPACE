package test240717.object1;

import java.util.Scanner;

public class LibraryMenu {
	private LibraryController lc = new LibraryController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		char gender;
		while(true) {
			System.out.print("성별 : ");
			gender = sc.next().charAt(0);
			if(gender == 'm' || gender == 'f') {
				break;
			}
			System.out.println("잘못 입력하셨습니다.");
		}
		Member mem = new Member(name, age, gender);
		lc.insertMember(mem);
		
		
		while(true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여하기");
			System.out.println("9. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println(lc.myInfo().toString());
				break;
			case 2:
				selectAll();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				rentBook();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("잘못 입력하셨습니다.");
				
			}
		}
		
	}
	
	public void selectAll() {
		System.out.println();
		Book[] all = lc.selectAll();
		for(int i = 0; i < all.length; i++) {
			if(all[i] instanceof AniBook) {
				System.out.println(i + "번 도서 : " + ((AniBook)all[i]).toString());
			} else if(all[i] instanceof CookBook) {
				System.out.println(i + "번 도서 : " + ((CookBook)all[i]).toString());
			}
		}
	}
	
	public void searchBook() {
		System.out.println();
		System.out.print("검색할 제목의 키워드 : ");
		String keyword = sc.next();
		
		Book[] matchBook = lc.searchBook(keyword);
//		for(Book i : matchBook) {
//			if(i != null) {
//				break;
//			} else if(matchBook[matchBook.length - 1] == null) {
//				System.out.println("해당 키워드로 검색된 도서가 없습니다.");
//				return;
//			}
//		}
		
		for(int i = 0; i < matchBook.length; i++) {
			if(matchBook[i] == null) {
				continue;
			} else if(matchBook[i] instanceof AniBook) {
				System.out.println(i + "번 도서 : " + ((AniBook)matchBook[i]).toString());
			} else if(matchBook[i] instanceof CookBook) {
				System.out.println(i + "번 도서 : " + ((CookBook)matchBook[i]).toString());
			}
		}
		
		
	}
	
	public void rentBook() {
		int index = 0;
		selectAll();
		while(true) {
			System.out.print("대여할 도서 번호 선택 : ");
			index = sc.nextInt();
			if(index >= 0 && index <= 4) {
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		switch(lc.rentBook(index)) {
		case 1:
			System.out.println("나이 제한으로 대여 불가");
			break;
		case 2:
			System.out.println("성공적으로 대여 완료.");
			break;
		case 3:
			System.out.println("성공적으로 대여 완료, 요리학원 쿠폰 발급.");
			break;
		default :
		}
	}

}
