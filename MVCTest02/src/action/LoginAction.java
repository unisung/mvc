package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.MemberDao_dbcp;

public class LoginAction implements Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    //파라미터를 받아서 db정보와 비교후 맞으면 list.jsp로
	//틀리면 다시 loginForm으로 이동
	 String id = request.getParameter("id");
	 String password = request.getParameter("password");
	 
	 /*MemberDao dao = new MemberDao();*/
	 MemberDao_dbcp dao = new MemberDao_dbcp();
	 int result = dao.userCheck(id, password);
	
	 String idongPage = "";
	 
	 if(result==1) {
			 request.setAttribute("gildong", "로그인 성공");
			 idongPage= "list";
	  }else
		 idongPage="loginForm";
	 
		return idongPage;
	}

}
