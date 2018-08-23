package com.admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.action.Action;
import com.controller.action.ActionForward;

public class AdminLogoutOkAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, 
			                HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		session.invalidate();//세션 속성 만료
		
		out.print("<script>");
		out.print("alert('관리자 로그아웃 되었습니다.');");
		out.print("location='./index.jsp'");
		out.print("</script>");
		
		return null;
	}

}
