<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인 화면</title>
<link rel="stylesheet" type="text/css" href="./css/main.css">
<link rel="stylesheet" type="text/css" href="./css/admin.css">
<link rel="stylesheet" type="text/css" href="./css/agongji.css">
<script src="./js/jquery-3.js"></script>
</head>
<body>
<div id="site">
<h3 align="center">관리자 단 페이지 영역</h3>
</div>
<div id="main_wrap">
<!-- 상단header -->
<div id="header">
<div id="logo">
<a href="./index.jsp" onfocus="this.blur()">
 <img src="./images/logo.jpg" width="200" border="0"/>
 </a>
</div>
<div id="top_menu">
<ul>
<li>
<a href="admin_gongji_list.do" onfocus="this.blur()">공지사항</a>
</li>
<li>
<a href="board_list.do" onfocus="this.blur()">게시판</a>
</li>
<li>
<a href="bbs_list.do" onfocus="this.blur()">자료실</a>
</li>
<li>
<a href="admin_member_list.do" onfocus="this.blur()">회원관리</a>
</li>
</ul>
</div>

<div id="top_login">
<ul>
 <li>
  <a href="./admin_main.do" onfocus="this.blur()">관리자 홈</a>
 </li>
 <li>
  <a href="./admin_logout_ok.do" onfocus="this.blur()"><font color="green">로그아웃</font></a>
 </li>
</ul>
</div>
</div><!-- header 끝. -->
<div class="clear"></div>
<div id="article">
<div id="left_menu">
<script>
function login_chk(){
	if(window.document.f.id.value==""){
		alert('아이디를 입력하세요');
		return false;
	}
	if($.trim($('#pwd').val()=="")){
		alert('비번을 입력하세요');
		$('#pwd').val('').focus();//공백처리 후 포커스
		return false;
	}
	return true;
}
function pwd_find(){
	window.open("pwd_Find.do","비번찾기","width=300px, height=300px scrollbars=yes");
}
</script>
<form name="f" method="post" action="member_Login_ok.do" onsubmit="return login_chk()">
 <table id="login_t">
 <tr>
 <th>아이디</th>
 <td>
 <input type="text" name="id" id="id" calss="input_box" size="14">
 </td>
 </tr>
 <tr>
  <th>비밀번호</th>
  <td>
  <input type="password" name="pass" id="pwd" size="14" class="input_box">
  </td>
 </tr> 
 </table>
<div id="login_menu">
<input type="submit" value="로그인" class="input_b">
<input type="reset" value="취소" class="input_b" onclick="">
<input type="button" value="비번찾기" class="input_b" onclick="pwd_find()">
</div>
</form>

</div>
<div id="article_c">
<div id="aGongji_wrap">
<c:if test="${not empty gongji}">
 <h2 class="aGongji_title">사용자 공지 보기</h2>
 <table id="aGongji_t">
 <tr>
  <th>공지제목</th>
  <td>${gongji.gongji_title}</td>
 </tr>
 <tr>
  <th>공지내용</th>
  <td>${gongji.gongji_cont}</td>
 </tr>
 <tr>
  <th>조회수</th>
  <td>${gongji.gongji_hit}</td>
 </tr>
 </table>
 
 </c:if>
 
 <div id="aGongji_menu">
  <input type="button" value="목록" class="gbutton_b" 
                 onclick="location.href='admin_gongji_list.do?page=${page}'"/>
 </div>
 
</div>
</div>
<!-- 본문 끝. -->
<div class="clear"></div>
<div id="footer">
 <h2 class="footer_title">
   choongang.2018. 
 </h2>
</div>

</div>
</div>

</body>
</html>