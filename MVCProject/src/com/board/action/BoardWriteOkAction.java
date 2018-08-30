package com.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardBean;
import com.board.model.BoardDao;
import com.controller.action.Action;
import com.controller.action.ActionForward;

public class BoardWriteOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, 
			                     HttpServletResponse response)
			throws Exception {
		String board_name=request.getParameter("board_name");
		String board_title=request.getParameter("board_title");
		String board_cont=request.getParameter("board_cont");
		String board_pwd=request.getParameter("board_pwd");
		
		BoardBean board = new BoardBean();
		board.setBoard_name(board_name);
		board.setBoard_title(board_title);
		board.setBoard_cont(board_cont);
		board.setBoard_pwd(board_pwd);
		
		BoardDao dao = BoardDao.getInstance();
		PrintWriter out = response.getWriter();
		ActionForward forward =null;
		
		if(dao.insertBoard(board)>0) {
		   forward = new ActionForward();
		   forward.setRedirect(true);
		   forward.setPath("./board_list.do");
		}else {
			out.print("<script>");
			out.print("alert('저장 중 오류 발생');");
			out.print("history.back();");
			out.print("<script>");
		}
		return forward;
	}

}
