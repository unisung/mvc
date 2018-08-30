package com.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardBean;
import com.board.model.BoardDao;
import com.controller.action.Action;
import com.controller.action.ActionForward;

public class BoardEditOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, 
			                    HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		String db_pwd = request.getParameter("db_pwd");
		String board_title = request.getParameter("board_title");
		String board_cont = request.getParameter("board_cont");
		String board_pwd = request.getParameter("board_pwd");
		
		BoardBean board = new BoardBean();
		board.setBoard_no(no);
		board.setBoard_title(board_title);
		board.setBoard_cont(board_cont);
		board.setBoard_pwd(board_pwd);
		
		
		PrintWriter out = response.getWriter();
		ActionForward forward = null;
		
		//db에 업데이트
		BoardDao dao = BoardDao.getInstance();
		
	   if(db_pwd.equals(board_pwd)) {//글의 비번과 입력한 비번이 같을때
		int result = dao.boardEdit(board);
		System.out.println("result="+result);
		if(result>0) {//정상수정 처리
			forward = new ActionForward();
		    forward.setRedirect(true);
		    forward.setPath("./board_cont.do?no="+no);
		}else {//수정 실패
			out.print("<script>");
			out.print("alert('수정 처리 중 오류 발생');");
			out.print("history.back();");
			out.print("</script>");
		}
	   }else {//글의 비번과 입력한 비번이 다를 때
		   out.print("<script>");
		   out.print("alert('입력한 비밀번호가 올바르지 않습니다.');");
		   out.print("history.back();");
		   out.print("</script>");
	   }
		
		
		return forward;
	}

}
