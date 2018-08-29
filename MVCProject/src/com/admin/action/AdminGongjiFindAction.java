package com.admin.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.model.AdminGongjiDao;
import com.controller.action.Action;
import com.controller.action.ActionForward;
import com.gongji.model.GongjiBean;
import com.gongji.model.GongjiDao;

public class AdminGongjiFindAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session;
		PrintWriter out =response.getWriter();
		session = request.getSession();
		
		String admin_id = (String)session.getAttribute("admin_id");
		if(admin_id==null) {
			out.print("<script>");
			out.print("alert('관리자 아이디로 로그인 하세요');");
			out.print("location='admin_index.do';");
			out.print("</script>");
		}else {
		
		AdminGongjiDao gongjidao = AdminGongjiDao.getInstance();
		//페이징
		  int page=1;//현재페이지
		  int limit=7;//페이지당 글 수
		  
		  if(request.getParameter("page")!=null) {
			  page=Integer.parseInt(request.getParameter("page"));
		  }
		  String find_name=request.getParameter("find_name");
		  String find_field=request.getParameter("find_field");
		  
		  System.out.println(find_name);
		  System.out.println(find_field);
		  
		  int listcount = gongjidao.getListCount();//전체 건수
		  List<GongjiBean> gongjiList = gongjidao.getGongjiSearch(page, limit, find_name, find_field);

		  //총 페이지 수   113/10 -> 11 3 -> 12, 113%10 >0 -> 1, ceil(113/10)
		  int maxpage = (int)((double)listcount/limit+0.95);//0.95를 더해서 올림
		  //현재 페이지에 보여줄 시작번호
	      int startpage=(((int)((double)page/limit+0.9))-1)*limit+1;
	      //현재 페이지에 보여줄 마지막 페이지 수(10,20,30..)
	      int endpage = maxpage;
	      if(endpage<startpage+limit-1) {
	    	  endpage=startpage+limit-1;
	      }
	      //보낼 데이타를 request에 설정
	      request.setAttribute("page", page);
	      request.setAttribute("maxpage", maxpage);
	      request.setAttribute("startpage", startpage);
	      request.setAttribute("listcount", listcount);
		  request.setAttribute("gongjiList", gongjiList);
		  request.setAttribute("endpage", endpage);

		  
		  //페이지 이동 처리
		  ActionForward forward = new ActionForward();
		  forward.setRedirect(false);//forward처리
		  forward.setPath("./admin/admin_gongji_list.jsp");//이동할 페이지
		  
		return forward;//이동

		}
		return null;

	}
}
