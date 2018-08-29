package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg ="delete페이지";
		   //이동페이지에서 출력할 객체를 request에 저장
		   request.setAttribute("msg", msg);
		   //이동할 페이지 설정
		   
			return "delete";
	}

}
