package com.gongji.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.action.Action;
import com.controller.action.ActionForward;
import com.gongji.model.GongjiBean;
import com.gongji.model.GongjiDao;

public class GongjiListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GongjiDao gongjidao = GongjiDao.getInstance();
		//페이징
		  int page=1;//현재페이지
		  int limit=10;//페이지당 글 수
		  
		  if(request.getParameter("page")!=null) {
			  page=Integer.parseInt(request.getParameter("page"));
		  }
		  int listcount = gongjidao.getListCount();//전체 건수
		  List<GongjiBean> gongjiList = gongjidao.getGongjiList(page, limit);
		  List<GongjiBean> gList2=new ArrayList<>();
		  
		  String gongji_title=null;
	   
		  for(int i=0;i<gongjiList.size();i++) {
			  GongjiBean g = gongjiList.get(i);// 공지 목록 
			  gongji_title = g.getGongji_title();//공지 제목저장
			  
			  if(gongji_title.length()>=24) {
				  gongji_title=gongji_title.substring(0, 24)+"...";
			  }
			  GongjiBean g2 = new GongjiBean();
			  g2.setGongji_title(gongji_title);
			  g2.setGongji_regdate(g.getGongji_regdate());
			  g2.setGongji_no(g.getGongji_no());
			  g2.setGongji_name(g.getGongji_name());
			  g2.setGongji_hit(g.getGongji_hit());
			   gList2.add(g2);
		  }
		  //총 페이지 수   113/10 -> 11 3 -> 12, 113%10 >0 -> 1, ceil(113/10)
		  int maxpage = (int)((double)listcount/limit+0.95);//0.95를 더해서 올림
		  //현재 페이지에 보여줄 시작번호
	      int startpage=(((int)((double)page/10+0.9))-1)*10+1;
	      //현재 페이지에 보여줄 마지막 페이지 수(10,20,30..)
	      int endpage = maxpage;
	      if(endpage<startpage+10-1) {
	    	  endpage=startpage+10-1;
	      }
	      //보낼 데이타를 request에 설정
	      request.setAttribute("page", page);
	      request.setAttribute("maxpage", maxpage);
	      request.setAttribute("startpage", startpage);
	      request.setAttribute("listcount", listcount);
		  request.setAttribute("gongjiList", gList2);
		  request.setAttribute("endpage", endpage);

		  //페이지 이동 처리
		  ActionForward forward = new ActionForward();
		  forward.setRedirect(false);//forward처리
		  forward.setPath("./gongji/gongji_list.jsp");//이동할 페이지
		  
		return forward;//이동 
	}

}
