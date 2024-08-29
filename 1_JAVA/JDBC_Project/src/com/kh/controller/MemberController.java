package com.kh.controller;

import java.util.List;

import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;
import com.kh.view.MemberMenu;

// Controller : View를 통해서 사용자가 요청한 기능에 대해 처리를 담당
//				해당 메소드로 전달된 데이터를 가공처리 후 dao로 전달하여 호출
//				dao로부터 반환받은 결과가 성공인지 실패인지에 따라서 응답화면 결정(View 메소드 호출)
public class MemberController {

	/**
	 * 사용자 추가 요청을 추가해주는 메소드
	 * @param userId ~ hobby : 사용자가 입력했던 정보들이 담겨있는 매개변수
	 */
	public void insertMember(String userId, String userPwd, String userName, String gender, String age, String email, String phone,
			String address, String hobby) {
		//view에서 전달받은 값을 바로 dao쪽으로 전달x
		//하나의 Member(vo) 객체로 반들어서 전달 
		
		Member m = new Member(userId, userPwd, userName, gender,
				Integer.parseInt(age),
				email, phone, address, hobby);
		
		int result = new MemberDao().insertMember(m);
		
		if (result > 0) { //추가 성공 -> 성공 화면 출력
			new MemberMenu().displaySuccess("성공적으로 회원 정보 추가 되었습니다.");
		} else { //추가 실패 -> 실패 화면 출력
			new MemberMenu().displayFail("회원 정보 추가에 실패하였습니다.");
		}
	}
	
	
	/**
	 * 회원을 전부 조회하는 메소드
	 */
	public void selectMemberList() {
		List<Member> list = new MemberDao().selectMemberList();
		
		//조회된 결과에 따라서 사용자가 보게될 응답화면 지정
		if(list.isEmpty()) { //list가 비어있을 경우
			new MemberMenu().displayNoData("전체 조회 결과가 없습니다");
		} else { //list에 데이터가 있을 경우
			new MemberMenu().displayMemberList(list);
		}
	}
	
	public void updateMember(String userId, String userPwd, String email, String phone, String address) {
		
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		
		int result = new MemberDao().updateMember(m);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원 정보가 수정되었습니다.");
		} else {
			new MemberMenu().displayFail("회원 정보 수정에 실패하였습니다.");
		}
	}
	
	public void deleteMember(String userId) {
		int result = new MemberDao().deleteMember(userId);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원 정보가 삭제되었습니다.");
		} else {
			new MemberMenu().displayFail("회원 정보 삭제에 실패하였습니다.");
		}
	}
}
