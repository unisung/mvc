package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   String msg ="myList";
	   //이동페이지에서 출력할 객체를 request에 저장
	   request.setAttribute("gildong", msg);
	   //이동할 페이지 설정
	 
		return  "list";
	}

}
