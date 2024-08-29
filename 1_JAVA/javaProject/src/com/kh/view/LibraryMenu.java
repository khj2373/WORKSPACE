package com.kh.view;

import java.util.List;
import java.util.Scanner;

import com.kh.controller.BookController;
import com.kh.controller.RentController;
import com.kh.vo.Book;
import com.kh.vo.Member;

public class LibraryMenu {
	private Member loginUser;
	private Scanner sc;
	private BookController bc;
	private RentController rc;

	public LibraryMenu(Member loginUser, BookController bc, Scanner sc, RentController rc) {
		super();
		this.loginUser = loginUser;
		this.sc = sc;
		this.bc = bc;
		this.rc = rc;
	}

	public void menu() {

		while (true) {
			System.out.println("===================== 도서 관리 프로그램 =====================");
			System.out.println("1. 도서 등록");
			System.out.println("2. 도서 수정");
			System.out.println("3. 도서 목록");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 도서 검색");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 입력 : ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				insertBook();
				break;
			case 2:
				updateBook();
				break;
			case 3:
				allPrintBook();
				break;
			case 4:
				deleteBook();
				break;
			case 5:
				searchBook();
				break;
			case 9:
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void insertBook() {
		System.out.println("===================== 도서 등록 =====================");
		System.out.print("제목 입력 : ");
		String title = sc.nextLine();
		System.out.print("저자 입력 : ");
		String author = sc.nextLine();
		System.out.print("장르 입력 : ");
		String genre = sc.nextLine();
		
		Book b = new Book(title, author, genre);
		
		if(bc.insertBook(b)) {
			System.out.println("책 등록 완료");
		} else {
			System.out.println("책 등록 실패");
		}
	}
	
	public void updateBook() {
		System.out.println("===================== 도서 수정 =====================");
		int i = 0;
		
		while(i < 3) {
			System.out.print("수정할 책 제목 입력 : ");
			String updateTitle = sc.nextLine();
			
			//updateTitle과 같은 제목의 책이 있나
			Book searchBook = bc.searchBookTitle(updateTitle);
			if(searchBook == null) {
				System.out.println("해당 제목의 책이 존재하지 않습니다.");
				i++;
				continue;
			}
			
			System.out.print("수정할 제목 입력 : ");
			String title = sc.nextLine();
			
			System.out.print("수정할 저자 입력 : ");
			String author = sc.nextLine();
			
			System.out.print("수정할 장르 입력 : ");
			String genre = sc.nextLine();
			
			//searcBook -> 새로운 객체로 변경
			Book newBook = new Book(title, author, genre);
			if(bc.updateBook(searchBook, newBook)) {
				System.out.println("도서 수정에 성공하였습니다.");
			} else {
				System.out.println("도서 수정 실패");
			}
			return;
			
		}
	}
	public void allPrintBook() {
		System.out.println("===================== 전체 도서 목록 =====================");
		List<Book> bList = bc.getBookList();
		
		System.out.printf("%7s %12s %5s\n", "장 르", "제 목", "저 자");
		for(Book b : bList) {
			b.printInfo();
		}
	}
	
	public void deleteBook() {
		//모든 책 목록을 보여줌
		//삭제할 책 제목을 입력받는다
		//mc.deleteBook에 책 제목을 전달하여 책을 삭제한다
		//해당 책이 없다면 입력한 책을 찾을 수 없습니다
		//정상적으로 삭제했다면 책을 정상적으로 삭제하였습니다
		System.out.println("===================== 도서 삭제 =====================");
		this.allPrintBook();
		
		System.out.print("삭제할 책 제목 입력 : ");
		String title = sc.nextLine();
		
		Book b = bc.searchBookTitle(title);
		
		if(b == null) {
			System.out.println("입력한 책을 찾을 수 없습니다.");
			return;
		}
		
		if(bc.deleteBook(b)) {
			System.out.println("정상적으로 삭제하였습니다.");
		} else {
			System.out.println("삭제에 실패하였습니다.");
		}
	}
	
	public void searchBook() {
		//검색할 키워드를 입력해주세요
		//키워드를 mc.searchBook에 전달
		//제목 or 장르 or 저자에 해당 키워드가 포함되어 있는 모든책을 담은 리스트를 반환
		//검색결과 리스트 출력
		//단, 없을시에는 검색결과가 없습니다 출력
		System.out.println("===================== 도서 검색 =====================");
		System.out.print("검색할 키워드를 입력해주세요 : ");
		String keyword = sc.nextLine();
		
		List<Book> bookList = bc.searchBook(keyword);
		if(bookList.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			System.out.println("===================== 검색 도서 목록 =====================");
			System.out.printf("%7s %12s %5s\n", "장 르", "제 목", "저 자");
			for(Book b : bookList) {
				b.printInfo();
			}
		}
	}
}
