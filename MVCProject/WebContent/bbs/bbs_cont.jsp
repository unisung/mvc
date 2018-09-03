<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인 화면</title>
<link rel="stylesheet" type="text/css" href="./css/main.css">
<link rel="stylesheet" type="text/css" href="./css/board.css">
<link rel="stylesheet" type="text/css" href="./css/member.css">
<link rel="stylesheet" type="text/css" href="./css/bbs.css">
<link rel="stylesheet" type="text/css" href="./css/index.css">
<link rel="stylesheet" type="text/css" href="./css/admin.css">
<link rel="stylesheet" type="text/css" href="./css/gongji.css">
<script src="./js/jquery-3.js"></script>
<script src="./js/board.js"></script>
</head>
<body>
<div id="site">
<h3 align="center">사용자 단 페이지 영역</h3>
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
<a href="gongji_list.do" onfocus="this.blur()">공지사항</a>
</li>
<li>
<a href="board_list.do" onfocus="this.blur()">게시판</a>
</li>
<li>
<a href="bbs_list.do" onfocus="this.blur()">자료실</a>
</li>
<li>
<a href="admin_login.do" onfocus="this.blur()">관리자</a>
</li>
</ul>
</div>

<div id="top_login">
<ul>
 <li>
  <a href="./index.jsp" onfocus="this.blur()">홈</a>
 </li>
 <li>
  <a href="member_Login.do" onfocus="this.blur()">로그인</a>
 </li>
 <li>
  <a href="member_Join.do" onfocus="this.blur()">회원가입</a>
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
	if($.trim($('#pwd').val())==""){
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
 <input type="text" name="id" id="id" class="input_box" size="14">
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
<div id="bbscont_wrap">
<h2 class="bbscont_title">자료실 내용보기 </h2>
 <table id="bbscont_t">
   <tr>
   <th>글제목</th>
   <td>
   ${bbsbean.bbs_subject}
   </td>
   </tr>
   <tr>
   <th>글내용</th>
   <td>
   <textarea name="bbs_content" id="bbs_content" 
           class="input_box" cols="40" rows="10" readonly>${bbsbean.bbs_content}</textarea>
   </td>
   </tr>
   <tr>
   <th>조회수</th>
   <td>
   ${bbsbean.bbs_readcount}
   </td>
   </tr>
   <c:if test="${not empty bbsbean.bbs_file }">
   <tr>
   <th>파일첨부</th>
   <td>
   <a href="./upload${bbsbean.bbs_file}" 
                  target="_blank">${bbsbean.bbs_file}</a>
   <input type="file" name="bbs_file">
   </td>
   </tr>
   </c:if>
 </table>
 <div id="bbscont_menu">
   <input type="button" value="수정" class="input_button" 
onclick=
"location.href='bbs_cont.do?num=${bbsbean.bbs_num}&page=${page}&state=edit&file=${bbsbean.bbs_file}'" />
   
   <input type="button" value="삭제" class = "input_button"  onclick=
"location.href='bbs_cont.do?num=${bbsbean.bbs_num}&page=${page}&state=delete'" />
  
   <input type="button" value="답변" class = "input_button" onclick=
"location.href='bbs_cont.do?num=${bbsbean.bbs_num}&page=${page}&state=reply'" />

  <input type="button" value="목록"  class = "input_button" onclick=
"location.href='bbs_list.do?page=${page}'" />
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