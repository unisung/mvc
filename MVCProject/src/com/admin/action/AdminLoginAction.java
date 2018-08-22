package com.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.action.Action;
import com.controller.action.ActionForward;

public class AdminLoginAction implements Action {
   //관리자 로그인 뷰 페이지 콘트롤러
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./admin/admin_login.jsp");
		System.out.println("action");
		return forward;
	}

}
