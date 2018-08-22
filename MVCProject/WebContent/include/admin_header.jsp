<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="site">  
  <h3 align="center">사용자 단 페이지 영역 </h3>   
</div>
<div id="main_wrap">   
  <!-- 상단 header -->
  <div id="header">
    <div id="logo">
     <a href="./index.jsp" onfocus="this.blur()">
        <img src="./images/logo.jpg" width="200" border="0" />
     </a>
    </div>
    
    <div id="top_menu">    
     <ul>
      <li><a href="gongji_list.do" onfocus="this.blur()">공지사항</a>
      <li>
      <a href="board_list.do"
       onfocus="this.blur()">게시판</a></li>
      <li><a href="bbs_list.do" 
       onfocus="this.blur()">자료실</a></li>
       <li><a href="admin_login.do" onfocus="this.blur()">관리자</a></li>
      <!-- onfocus는 포커스를 가졌을때 발생하는 자바스크립트 이벤트 핸들러
                    클릭시 사각점선을 사라지게 함 --> 
     </ul>
    </div>
    
    <div id="top_login">
     <ul>
      <li><a href="./index.jsp" onfocus="this.blur()">홈</a></li>
       &nbsp;
      <li><a href="member_Login.do" onfocus="this.blur()">로그인</a></li>
      <li><a href="member_Join.do" onfocus="this.blur()">회원가입</a></li>
     </ul>
    </div>
  </div>
  
</body>
</html>