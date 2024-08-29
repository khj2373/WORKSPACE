package com.kh.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kh.vo.Book;
import com.kh.vo.Member;
import com.kh.vo.RentBook;

public class RentController {
	private List<RentBook> rentBookList = new ArrayList<>(); 

	public List<Book> getRentAble(List<Book> bList){
		//모든 책 목록 중 rentBookList에 있는 책 목록을 제외
		
		List<Book> ableList = new ArrayList<>();
		for(Book b : bList) {
			if(!checkBook(b)) { //빌린 기록이 없을 때
				ableList.add(b);
			}
		}
		return ableList;
	}
	
	
	//빌린 기록이 있으면 true
	//빌린 기옥이 없으면 false
	public boolean checkBook(Book b) {
		for(RentBook rent : rentBookList) {
			if(rent.getTitle().equals(b.getTitle())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean insertRentBook(Book b, Member m) {
		return rentBookList.add(new RentBook(b.getTitle(), m.getUserNo(), new Date()));
	}
}
