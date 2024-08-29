package test240711.object3;

import java.util.Scanner;

public class Library {
	private Scanner sc = new Scanner(System.in);
	private Book[] bArr = new Book[10];
	public void menu() {
		int menu = 0;
		while (menu != 9) {
			System.out.println("=========도서 관리 프로그램=========");
			System.out.println("1. 도서등록");
			System.out.println("2. 도서목록 출력");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 삭제");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			sc.nextLine();
			switch (menu) {
			case 1:
				this.addBook();
				break;
			case 2:
				this.printBookList();
				break;
			case 3:
				this.searchBook();
				break;
			case 4:
				this.printBookList();
				this.deleteBook();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				break;
			default :
				System.out.println("잘못입력했습니다");
			}
		}
	}
	
	public void addBook() {
		System.out.println("=========도서등록========");
		String name, genre, author;
		int bNo;
		System.out.print("도서 제목 : ");
		name = sc.nextLine();

		System.out.print("장르 : ");
		genre = sc.next();

		System.out.print("저자 : ");
		author = sc.next();

		System.out.print("책 번호 : ");
		bNo = sc.nextInt();

		for (int i = 0; i < bArr.length; i++) {
			if (bArr[i] == null) {
				bArr[i] = new Book(name, genre, author, bNo);

				System.out.println("=========등록 완료=========");
				System.out.println("책을 등록했습니다.");
				System.out.println(bArr[i].toString());
				break;
			} else if (i == (bArr.length - 1)) {
				System.out.println("이미 등록할 수 있는 책이 가득 찼습니다.");
			}
		}
		
	}
	
	public void printBookList() {
		System.out.println("=========등록 도서 목록=========");
		for (int i = 0; i < bArr.length; i++) {
			if (bArr[i] == null) {
				break;
			}
			System.out.println(bArr[i].toString());
		}
	}
	
	public void searchBook() {
		System.out.println("=========도서 검색=========");
		System.out.print("검색할 책 이름을 입력 : ");
		String search = sc.nextLine();

		for (int i = 0; i < bArr.length; i++) {
			if (bArr[i] == null) {
				if (i == (bArr.length - 1)) {
					System.out.println("입력하신 제목의 책은 등록되어 있지 않습니다.");
					break;
				}
				continue;
			} else if (search.equals(bArr[i].getName())) {
				System.out.println(bArr[i].toString());
				break;
			} else {
				System.out.println("입력하신 제목의 책은 등록되어 있지 않습니다.");
				break;
			}
		}
	}
	
	public void deleteBook() {
		System.out.print("삭제할 도서의 번호 입력 : ");
		int num = sc.nextInt();
		
		for(int i = 0; i < bArr.length; i++) {
			if(i == 9 && num == bArr[i].getbNo()) {
				bArr[9] = null;
				System.out.println("도서를 삭제했습니다.");
				break;
			} else if(i < 9 && num == bArr[i].getbNo()) {
				for(int j = i; j < bArr.length - 1; j++) {
					bArr[j] = bArr[j+1];
				}
				System.out.println("도서를 삭제했습니다.");
				break;
			} else if(bArr[i] == null) {
				System.out.println("해당하는 도서가 없습니다.");
				
			}
		}
	}

}
