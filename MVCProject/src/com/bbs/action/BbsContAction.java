package com.bbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.model.BbsBean;
import com.bbs.model.BbsDao;
import com.controller.action.Action;
import com.controller.action.ActionForward;

public class BbsContAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int num = Integer.parseInt(request.getParameter("num"));
		int page = Integer.parseInt(request.getParameter("page"));
		String state = request.getParameter("state");
		
		BbsDao dao = BbsDao.getInstance();
		if(state.equals("cont")) {
			dao.bbsHit(num);//조회수 증가
		}
		BbsBean bbs = dao.getCont(num);
		
		System.out.println("bbsContent="+bbs.getBbs_content());
		
		request.setAttribute("bbsbean", bbs);
		request.setAttribute("page", page);
		
		//ActionForward 
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		if(state.equals("cont")) {//내용보기
			forward.setPath("./bbs/bbs_cont.jsp");
		}else if(state.equals("edit")) {//수정
			forward.setPath("./bbs/bbs_edit.jsp");
		}else if(state.equals("delete")) {//삭제
			forward.setPath("./bbs/bbs_delete.jsp");
		}else if(state.equals("reply")) {//답변
			forward.setPath("./bbs/bbs_reply.jsp");
		}
		
		return forward;
	}

}
