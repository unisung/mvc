package com.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.action.Action;
import com.controller.action.ActionForward;
import com.member.model.MemberBean;
import com.member.model.MemberDao;

public class MemberLoginOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			              throws Exception {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberDao dao = MemberDao.getInstance();
		
		int result = dao.userCheck(id, pass);
		
		if(result==1) {
			MemberBean bean = dao.getMember(id);
			
			String name=bean.getMember_name();
			String nickname=bean.getMember_nickname();
			String addr1 = bean.getMember_addr1();
			String profile=bean.getMember_profilename();
			
			//session에 저장
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("nickname", nickname);
			session.setAttribute("addr", addr1);
			session.setAttribute("prifilename", profile);
			
			System.out.println("sessId="+session.getAttribute("id"));
			System.out.println("sessId="+session.getAttribute("name"));
			
            
			//이동 경로 설정
			ActionForward forward = new ActionForward();
			//redirect로 설정
			forward.setRedirect(true);
			forward.setPath("./index.do");
			
			return forward;
			
		}else if(result==0) {
			out.print("<script>");
			out.print("alert('비번이 일치하지 않습니다.');");
			out.print("history.back();");
			out.print("</script>");
		}else if(result==-1) {
			out.print("<script>");
			out.print("alert('등록되지 않은 id입니다.');");
			out.print("history.back();");
			out.print("</script>");
		}
		return null;
	}

}
