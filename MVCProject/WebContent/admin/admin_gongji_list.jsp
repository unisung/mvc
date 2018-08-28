<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>       
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
<h3 align="center">사용지 단 페이지 영역</h3>
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
 <div id="Gongji_list">
   <h2 class="Glist_title">공지사항 목록</h2>
    <div id="Glist_count">
    	총게시물:${listcount}<br>
    </div>
 	<table id="Glist_t">
 	 <tr>
 	  <th height="26" class="no">번호</th>
 	  <th class="title">제목</th>
 	  <th class="writer">작성자</th>
 	  <th class="date">날짜</th>
 	  <th class="hit">조회수</th>
 	  <th class="no">수정</th>
 	  <th class="no">삭제</th>
 	 </tr>
 	 <c:if test="${not empty gongjiList}">
 	 <c:forEach var="g" items="${gongjiList}">
 	  <tr align="center" valgin="middle">
 	   <td height="23">
 	       ${g.gongji_no}
 	   </td>
 	   <td>
 	   	<a href="admin_gongji_cont.do?gongji_no=${g.gongji_no}&page=${page}"
 	   	   onfocus="this.blur();">${g.gongji_title}</a>
 	   </td>
 	   <td>
 	    ${g.gongji_name}
 	   </td>
 	   <td>
 	  	${fn:substring(g.gongji_regdate,0,10)} 
 	   </td>
 	   <td>
 	   ${g.gongji_hit}
 	   </td>
 	   <td>
 	   <input type="button" value="수정" class="admin_b" 
 	   onclick="admin_gongji_edit.do?gongji_no=${g.gongji_no}&page=${page}&stat=cont" 
 	   onfocus = "this.blur();">${g.gongji_title}
 	   </td>
 	   <td>
 	   <input type="button" value="삭제" class="admin_b"
 	   onclick="if(confirm('정말로 삭제하시겠습니까?')){location.href='admin_gongji_del_ok.do?gongji_no=${g.gongji_no}&page=${page}';}else{return;}">
 	   </td>
 	  </tr>
 	  </c:forEach>
 	  </c:if>
 	</table>
 	<div id="Glist_paging">
 	<c:if test="${page<=1}">
 		[이전]
 	</c:if>
 	<c:if test="${page>1}">
 	  <a href="admin_gongji_list.do?page=${page-1}" onfocus="this.blur();">[이전]</a>&nbsp;
 		[이전]
 	</c:if>
 	<c:forEach var="i" begin="${startpage}" end="${endpage>=maxpage?maxpage:endpage}">
 	  <c:if test="${i==page}">[${i}] </c:if>
 	  <c:if test="${i!=page}">
 	  	<a href="admin_gongji_list.do?page=${i}" onfocus="this.blur()">[${i}]</a>
 	  </c:if>
 	</c:forEach>
 	
 	 <c:if test="${page>=maxpage}">
 		[다음]
 	</c:if>
 	<c:if test="${page<maxpage}">
 	  <a href="admin_gongji_list.do?page=${page+1}" onfocus="this.blur();">[다음]</a>&nbsp;
 		[이전]
 	</c:if>
 	</div>
 	<div id="aGlist_menu">
 	 <a href="admin_gongji_write.do" onfocus="this.blur();">[공지작성]</a>
 	</div>
 	현재페이지:${page}<br>
 	max페이지:${maxpage }<br>
 	시작페이지:${startpage }<br>
 	건수:${listcount }<br>
 	마지막페이지:${endpage }<br>
 	<!--  -->
 	<div id="aGlist_find">
 	 <form method="get" action="admin_gongji_find.do" 
 	                          onsubmit="return find_check()">
      <table id="aGlistFind_t">
       <tr>
        <td>
         <select name="find_field">
         	<option value="gongji_title">공지제목</option>
         	<option value="gongji_cont">공지내용</option>
         </select>
        <input name="find_name" id="find_name" size="10" class="admin_box">
        <input type="submit" value="검색" class="admin_b">
        </td>
       </tr>
      </table> 	                          
 	 </form>
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