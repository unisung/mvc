package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			               HttpServletResponse response) throws Exception {
		   ActionForward forward = new ActionForward(); 			   
		   forward.setRedirect(false);//값이 false일때 forward,true일때 sendRedirect
		   forward.setPath("./pageView/loginForm.jsp");//이동할 경로 설정
			
		return forward;
	}

}
