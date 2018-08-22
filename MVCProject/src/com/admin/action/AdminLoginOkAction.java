package com.admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.model.AdminDao;
import com.controller.action.Action;
import com.controller.action.ActionForward;

public class AdminLoginOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그인 처리
		request.setCharacterEncoding("utf-8");//현재페이지로 넘어오는 요청객체의 문자셋 설정
		response.setContentType("text/html;charset=utf-8");//보내는 페이지의 문자셋 설정
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		String admin_id
		 = request.getParameter("admin_id").trim();
		String admin_pwd
		 = request.getParameter("admin_pwd").trim();
		AdminDao dao = AdminDao.getInstance();
		 int re = dao.adminCheck(admin_id,admin_pwd);
		 if(re==1) {
			 session.setAttribute("admin_id", admin_id);
			 ActionForward forward=new ActionForward();
			 forward.setRedirect(false);
			 forward.setPath("./admin/admin_main.jsp");
			 return forward;
		 }else if(re==-1) {
			 out.print("<script>");
			 out.print("alert('등록되지 않은 관리자 id입니다.);");
			 out.print("history.back();");
			 out.print("</script>");
		 }else if(re==0) {
			 out.print("<script>");
			 out.print("alert('비번이 틀립니다.);");
			 out.print("history.back();");
			 out.print("</script>");
		 }
		
		return null;
	}

}
