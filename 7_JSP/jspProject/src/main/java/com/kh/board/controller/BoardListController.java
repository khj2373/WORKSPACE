package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.kh.board.model.vo.Board;
import com.kh.board.service.BoardService;
import com.kh.common.PageInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardListController
 */
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//views/board/boardListView.jsp 포워딩
		//board데이터 전달
		
		//------------------------ 페이징 처리 ------------------------
		int listCount; //현재 총 게시글 수
		int currentPage; //현재 페이지(사용자가 요청한 페이지)
		int pageLimit = 10; //페이지 하단에 보여질 페이징바의 수
		int boardLimit = 10; //한 페이지 내에 보여질 게시글 최대 갯수
		//위 4개의 값을 기준으로 아래 3개의 값을 구할 수 있다
		
		int maxPage; //가장 마지막 페이지(총 페이지의 수)
		int startPage; //페이징바의 시작 수
		int endPage; //페이징바의 마지막 수
		
		// listCount : 총 게시글 수
		listCount = new BoardService().selectListCount();
		
		//현재 페이지(사용자가 요청한 페이지)
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		/**
		 * maxPage : 제일 마지막 페이지 수
		 * 
		 * listCount : 107
		 * boardLimit : 10
		 * 
		 * 총 게시글 수 / 한 페이지에 보여줄 게시글 수 -> 올림
		 */
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		/**
		 * startPage : 페이징바 시작 수
		 * 
		 * currentPage : 1
		 * pageLimit : 10
		 * startPage : 1
		 * 
		 * currentPage : 1
		 * pageLimit : 10
		 * startPage : 2
		 * 
		 * startPage = ((currentPage - 1) / pageLimit) * pageLimit + 1
		 */
		
		startPage = ((currentPage - 1) / pageLimit) * pageLimit + 1;
		
		/**
		 * endPage : 페이징바의 끝 수
		 * 
		 * startPage : 1 -> 10
		 * startPage : 11 -> 20
		 */
		
		endPage = startPage + pageLimit - 1;
		
		//startPage가 11이면 endPage는 20이다(maxPage가 13이라면?)
		endPage = endPage > maxPage ? maxPage : endPage;
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		ArrayList<Board> list = new BoardService().selectList(pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/board/boardListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}