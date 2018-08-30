package com.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDao;
import com.controller.action.Action;
import com.controller.action.ActionForward;

public class BoardDeleteOkAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		String db_pwd = request.getParameter("db_Pwd");
		String del_pwd = request.getParameter("del_pwd");
		PrintWriter out = response.getWriter();
		ActionForward forward =null;
		if(db_pwd.equals(del_pwd)) {//비번이 맞을 때
			BoardDao dao = BoardDao.getInstance();
			int result = dao.deleteBoard(no);
			if(result>0) {//정상삭제
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./board_list.do");
			}else {//오류발생
				out.print("<script>");
				out.print("alert('삭제 처리 중 오류 발생');");
				out.print("history.back();");
				out.print("</script>");				
			}
		}else {//비번이 틀릴때
			out.print("<script>");
			out.print("alert('입력한 비번이 올바르지 않습니다.');");
			out.print("history.back();");
			out.print("</script>");	
		}
		return forward;
	}
}
