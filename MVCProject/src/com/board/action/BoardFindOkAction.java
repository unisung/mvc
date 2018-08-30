package com.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardBean;
import com.board.model.BoardDao;
import com.controller.action.Action;
import com.controller.action.ActionForward;

public class BoardFindOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String find_field = request.getParameter("find_field");
		String find_name = request.getParameter("find_name");
		
		find_name="%"+find_name+"%";
		
		BoardDao dao = BoardDao.getInstance();
		
		List<BoardBean> list=dao.findBoard(find_name, find_field);
		
		   request.setAttribute("LIST", list);
		   ActionForward forward = new ActionForward();
		   forward.setRedirect(false);
		   forward.setPath("./board/board_list.jsp");
		
		return forward;
	}

}
