package com.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardBean;
import com.board.model.BoardDao;
import com.controller.action.Action;
import com.controller.action.ActionForward;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   BoardDao dao = BoardDao.getInstance();
	   List<BoardBean> list = dao.getBoardList();
	   
	   System.out.println(list.get(0).getBoard_regdate());
	   
	   request.setAttribute("LIST", list);
	   ActionForward forward = new ActionForward();
	   forward.setRedirect(false);
	   forward.setPath("./board/board_list.jsp");
		
		return forward;
	}

}
