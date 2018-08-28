package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			               HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward(); 
		
		String msg ="내용보기";
		   //이동페이지에서 출력할 객체를 request에 저장
		   request.setAttribute("msg", msg);
		   //이동할 페이지 설정
		 
		   
		   forward.setRedirect(false);//값이 false일때 forward,true일때 sendRedirect
		   forward.setPath("./pageView/content.jsp");//이동할 경로 설정
			
		return forward;
	}

}
