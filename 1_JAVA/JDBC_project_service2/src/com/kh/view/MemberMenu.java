package com.kh.view;

import java.util.List;
import java.util.Scanner;

import com.kh.controller.LottoController;
import com.kh.controller.MemberController;
import com.kh.model.vo.Member;

public class MemberMenu {
	
	Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	private LottoController lc = new LottoController();
	
	public void titleMenu() {
		
		System.out.println("**********************************************");
		System.out.println(
			 " \n\n ##        ####    ######   ######    ####  \r\n"
				+ " ##       ##  ##     ##       ##     ##  ## \r\n"
				+ " ##       ##  ##     ##       ##     ##  ## \r\n"
				+ " ##       ##  ##     ##       ##     ##  ## \r\n"
				+ " ######    ####      ##       ##      #### ");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("**********************************************\n");
		
		while(true) {
			System.out.println("\n================== 타이틀 메뉴 ==================");
			System.out.println("[1] 로그인");
			System.out.println("[2] 회원가입");
			System.out.println("[0] 프로그램 종료.");
			System.out.print("번호 입력 : ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				this.loginMenu();
				break;
			case 2:
				this.insertMember();
				break;
			case 0:
				System.out.println("\n프로그램을 종료합니다 이용해주셔서 감사합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다 다시 입력해주세요.");
			}
		}
	}
	
	public void loginMenu() {
		System.out.println("\n================== 로그인 ==================");
		System.out.print("[ID] : ");
		String id = sc.nextLine();
		System.out.print("[PASSWORD] : ");
		String pwd = sc.nextLine();
		
		Member m = mc.loginMember(id, pwd);
		
		if(m != null) {
			this.mainMenu(m);
		}
	}
	
	public void insertMember() {
		System.out.println("\n================== 회원가입 ==================");
		
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String userPwd = sc.nextLine();
		
		System.out.print("이름 : ");
		String userName = sc.nextLine();
		
		System.out.print("성별(M, F) : ");
		String gender = sc.nextLine().toUpperCase();
		
		System.out.print("나이 : ");
		String age = sc.nextLine();
		
		if(Integer.parseInt(age) < 20) {
			System.out.println("\n*미성년자는 로또를 구매할 수 없습니다.*");
			return;
		}
		
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		System.out.print("취미(,로 이어서 작성) : ");
		String hobby = sc.nextLine();
		
		mc.insertMember(userId, userPwd, userName, gender, age, email, phone, address, hobby);
	}
	
	public void mainMenu(Member m) {
		while(true) {
			System.out.println("\n================== 메인 메뉴 ==================");
			System.out.println(m.getUserId());
			System.out.println("[1] 로또 구매");
			System.out.println("[2] 구매 및 당첨 정보");
			System.out.println("[3] 회원 정보");
			System.out.println("[9] 회원 탈퇴");
			System.out.println("[0] 로그아웃");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				this.buyLotto(m);
				break;
			case 2:
				this.insertMember();
				break;
			case 3:
				break;
			case 9:
			case 0:
				System.out.println("\n프로그램을 종료합니다 이용해주셔서 감사합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다 다시 입력해주세요.");
			}
		}
	}
	
	public void buyLotto(Member m) {
		System.out.println("\n================== 로또 구매 ==================");
		System.out.println("1~9까지 숫자로 6개의 숫자를 입력해주세요");
		String[] n = new String[6];
		int i = 1;
		while(i <= 6) {
			System.out.print(i + "번째 번호 입력 : ");
			n[i-1] = sc.nextLine();
			try {
				if(Integer.parseInt(n[i-1]) >= 1 && Integer.parseInt(n[i-1]) <= 9 && n[i-1].length() == 1) {
					i++;
					continue;
				}
			} catch(NumberFormatException e){
				
			}
			System.out.println("잘못된 입력입니다 다시 입력해주세요.");
		}
		
		System.out.print("입력하신 번호 : ");
		for(String arr : n) {
			System.out.print(arr + " ");
		}
		System.out.print("입력하신 번호로 추첨을 진행하시겠습니까?(Y, N) : ");
		char yn = sc.nextLine().toUpperCase().charAt(0);
		
		if(yn == 'Y') {
			int rs = lc.drawingLotto(m, n);
			
			System.out.println("일치하는 숫자의 갯수 : " + rs);
			System.out.println();
			
			switch(rs) {
			case 0:
				System.out.println("아쉽게도 낙첨되셨습니다.");
				break;
			case 1:
				System.out.println("아쉽게도 낙첨되셨습니다.");
				break;
			case 2:
				System.out.println("5등 당첨!");
				break;
			case 3:
				System.out.println("4등 당첨!");
				break;
			case 4:
				System.out.println("3등 당첨! 축하드립니다.");
				break;
			case 5:
				System.out.println("2등 당첨! 축하드립니다!");
				break;
			case 6:
				System.out.println("1등 당첨! 축하드립니다!!!");
				break;
			}
		}
	}
	
	

	//-----------------------응답 화면-----------------------
	/**
	 * 서비스 요청 후 처리를 성공적으로 완료했을 때 보게 될 응답화면
	 * @param message : 성공메세지
	 */
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message);
	}
	
	/**
	 * 서비스 요청 후 처리를 성공적으로 완료하지 못했을 때 보게 될 응답화면
	 * @param message : 실패메세지
	 */
	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message);
	}
	
	
	/**
	 * 조회서비스 요청시 결과가 없을 경우 보게 될 화면
	 * @param message
	 */
	public void displayNoData(String message) {
		System.out.println("\n" + message);
	}

	/**
	 * 조회서비스 요청시 결과가 여러행일 경우 보게 될 화면
	 * @param list
	 */
	public void displayMemberList(List<Member> list) {
		for(Member m : list) {
			System.out.println(m);
		}
	}
	
	public void displayMember(Member m) {
		System.out.println("\n조회된 데이터는 다음과 같습니다.");
		System.out.println(m);
	}
	
	public void lottoResult(String[] n) {
		System.out.println("5초 후 당첨결과가 출력됩니다.");
		lc.loading();
		
		System.out.println("\n================== 당첨 결과 ==================");
		System.out.print("당첨 번호 : ");
		for(String arr : n) {
			System.out.print(arr + " ");
		}
		System.out.println();
	}
}
