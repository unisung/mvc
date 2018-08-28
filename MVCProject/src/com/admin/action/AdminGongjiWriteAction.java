package com.admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.action.Action;
import com.controller.action.ActionForward;

public class AdminGongjiWriteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	 PrintWriter out=response.getWriter();
	 HttpSession session = request.getSession();
	 String admin_id = (String)session.getAttribute("admin_id");
	 
	 if(admin_id==null) {
		 out.print("<script>");
		 out.print("alert('관리자 아이디로 로그인 하세요');");
		 out.print("location='admin_login.do';");
		 out.print("</script>");
	 }else {
		 ActionForward forward = new ActionForward();
		 forward.setRedirect(false);
		 forward.setPath("./admin/admin_gongji_write.jsp");
		 return forward;
	 }
		return null;
	}

}
