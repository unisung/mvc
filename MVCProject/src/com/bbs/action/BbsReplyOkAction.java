package com.bbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.model.BbsBean;
import com.bbs.model.BbsDao;
import com.controller.action.Action;
import com.controller.action.ActionForward;

public class BbsReplyOkAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BbsBean bbsbean = new BbsBean();
		BbsDao dao = BbsDao.getInstance();
		
		//파라미터 데이타 받기
		String bbs_name = request.getParameter("bbs_name");
		String bbs_pass = request.getParameter("bbs_pass");
		String bbs_subject = request.getParameter("bbs_subject");
		String bbs_content = request.getParameter("bbs_content");
		
		//히든 파라미터
		int bbs_num = Integer.parseInt(request.getParameter("bbs_num"));
		int bbs_re_ref = Integer.parseInt(request.getParameter("bbs_re_ref"));
		int bbs_re_lev = Integer.parseInt(request.getParameter("bbs_re_lev"));
		int bbs_re_seq = Integer.parseInt(request.getParameter("bbs_re_seq"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		
		bbsbean.setBbs_num(bbs_num);
		bbsbean.setBbs_re_ref(bbs_re_ref);
		bbsbean.setBbs_re_lev(bbs_re_lev);
		bbsbean.setBbs_re_seq(bbs_re_seq);
		bbsbean.setBbs_name(bbs_name);
		bbsbean.setBbs_pass(bbs_pass);
		bbsbean.setBbs_subject(bbs_subject);
		bbsbean.setBbs_content(bbs_content);
		
		//답변 db저장
		dao.bbsReply(bbsbean);

		response.sendRedirect("bbs_list.do?page="+page);
		return null;
	}

}
