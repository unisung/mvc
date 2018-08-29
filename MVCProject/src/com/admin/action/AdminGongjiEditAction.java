package com.admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.model.AdminGongjiDao;
import com.controller.action.Action;
import com.controller.action.ActionForward;
import com.gongji.model.GongjiBean;
import com.sun.xml.internal.ws.resources.AddressingMessages;

public class AdminGongjiEditAction implements Action {

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
			
			int gongji_no = Integer.parseInt(request.getParameter("gongji_no"));
			int page = Integer.parseInt(request.getParameter("page"));
			AdminGongjiDao dao = AdminGongjiDao.getInstance();
			GongjiBean g = dao.getGongjiCont(gongji_no);
			
			request.setAttribute("g", g);
			request.setAttribute("page", page);
			
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./admin/admin_gongji_edit.jsp");
			
			return forward;
		}
		
		return null;
	}

}
