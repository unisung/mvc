package com.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.action.Action;
import com.controller.action.ActionForward;
import com.gongji.model.GongjiBean;
import com.gongji.model.GongjiDao;

public class AdminGongjiContAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        GongjiDao gongjidao = GongjiDao.getInstance();
		int gongji_no = Integer.parseInt(request.getParameter("gongji_no"));
     int page=1;
     if(request.getParameter("page")!=null) {
    	 page = Integer.parseInt(request.getParameter("page"));
     }
        //공지글 조회수 증가
      	gongjidao.updateGongjigHit(gongji_no);
      	//공지글 내용 가져오기
      	GongjiBean gongji=gongjidao.getGongjiCont(gongji_no);
      	//request에 저장
      	request.setAttribute("page", page);
      	request.setAttribute("gongji", gongji);
      	
      	//포워드 처리
      	ActionForward forward = new ActionForward();
      	forward.setPath("./admin/admin_gongji_cont.jsp");
      	forward.setRedirect(false);
		
		return forward;//실제 페이지 이동
	}

}
