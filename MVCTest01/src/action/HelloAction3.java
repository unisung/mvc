package action;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//객체를 저장하고 이동할수 있도로록 수정
public class HelloAction3 implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response)
			     throws Exception{
		
		String msg = "나는 Hello3예요";
		//보낼 메세지를 request에 저장
		request.setAttribute("msg", msg);
		
		//이동할 페이지를 리턴
		return "./view/hello3.jsp";
	}
     
	
}
