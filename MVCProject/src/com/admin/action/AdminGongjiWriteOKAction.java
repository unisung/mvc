package com.admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.model.AdminGongjiDao;
import com.controller.action.Action;
import com.controller.action.ActionForward;
import com.gongji.model.GongjiBean;

public class AdminGongjiWriteOKAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String admin_id=(String)session.getAttribute("admin_id");
		if(admin_id==null) {
			out.print("<script>");
			out.print("alert('관리자 아이디로 로그인 하세요');");
			out.print("location='admin_login.do';");
			out.print("</script>");
		}else {
			String gongji_name=request.getParameter("gongji_name").trim();
			String gongji_title=request.getParameter("gongji_title").trim();
			String gongji_cont=request.getParameter("gongji_cont").trim();
			String gongji_pwd=request.getParameter("gongji_pwd").trim();
			
			GongjiBean g = new GongjiBean();
			g.setGongji_name(gongji_name);
			g.setGongji_title(gongji_title);
			g.setGongji_cont(gongji_cont);
			g.setGongji_pwd(gongji_pwd);
			AdminGongjiDao dao = AdminGongjiDao.getInstance();
			int re = dao.insertGongji(g);
			if(re>0) {
				out.print("<script>");
				out.print("alert('등록완료');");
				out.print("</script>");
				response.sendRedirect("admin_gongji_list.do");
			}else {
				out.print("<script>");
				out.print("alert('등록실패');");
				out.print("history.back();");
				out.print("</script>");
			}
		}
		
		return null;
	}

}
