package com.bbs.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.model.BbsBean;
import com.bbs.model.BbsDao;
import com.controller.action.Action;
import com.controller.action.ActionForward;

public class BbsListAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BbsDao dao = BbsDao.getInstance();
		int page = 1;// 현재 페이지
		int limit = 10;// 한 페이지당 보여지는 목록 수

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		int listcount = dao.getListCount();
		List<BbsBean> bbsList = dao.getBbsList(page, limit);//페이지번호, 페이지당 글수 

		// 총 페이지 수 113/10 -> 11 3 -> 12, 113%10 >0 -> 1, ceil(113/10)
		int maxpage = (int) ((double) listcount / limit + 0.95);// 0.95를 더해서 올림
		
		// 현재 페이지에 보여줄 시작번호
		int startpage = (((int) ((double) page /limit + 0.9)) - 1) * limit + 1;
		
		// 현재 페이지에 보여줄 마지막 페이지 수(10,20,30..)
		int endpage = maxpage;
		if (endpage < startpage + limit - 1) {
			endpage = startpage + limit - 1;
		}
		
		// 보낼 데이타를 request에 설정
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("bbslist", bbsList);
		request.setAttribute("endpage", endpage);
		request.setAttribute("limit", limit);

		//view page
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./bbs/bbs_list.jsp");
		
		return forward;
	}

}
