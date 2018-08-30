package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardBean;
import com.board.model.BoardDao;
import com.controller.action.Action;
import com.controller.action.ActionForward;

public class BoardEditAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       int no = Integer.parseInt(request.getParameter("no"));
       
       BoardDao dao = BoardDao.getInstance();
       BoardBean board = dao.getCont(no);
       
       
       System.out.println("게시글 내용:"+board.getBoard_cont());
       
       request.setAttribute("board", board);
       
       
       
       ActionForward forward = new ActionForward();
       forward.setRedirect(false);
       forward.setPath("./board/board_edit.jsp");

       return forward;
	}

}
