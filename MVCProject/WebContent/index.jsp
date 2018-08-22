<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인 화면</title>
<link rel="stylesheet" type="text/css" href="./css/main.css" />
<!-- css 외부 포함파일을 불러오는 것. css는  디자인 UI 를 작성 -->
<script src="./js/jquery-3.js"></script>
<!-- jQuery 자바스크립트 라이브러리 외부 파일을 읽어온다 -->
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
  
  <div class="clear"></div>
  
    <!-- 본문 내용 -->
    <div id="article">
     <div id="left_menu">
      <script language="javascript">
       function login_check(){//함수 정의
    	   if(window.document.f.id.value==""){
    		    alert("아이디를 입력하세요!");//경고창 띄운다.
    		    f.id.focus();//포커스를 이동
    		    return false;
    	   }
           if($.trim($("#pwd").val())==""){
        	   //$는 jQuery 이다.trim()을 사용하여 양쪽 공백을 제거
        	   alert("비번을 입력하세요!");
        	   $("#pwd").val("").focus();//초기화 하고 포커스 이동
        	   return false;
       	   }
       }
       
       /* 공지창 띄위기 */
       function pwd_find() { // 함수정의
    	   window.open("pwd_Find.do", "비번찾기", "width=300px, height=300px scrollbars=yes");
       }
      </script>
      <form name="f" method="post" action="member_Login_ok.do"
      onsubmit="return login_check()">
        <table id="login_t">
         <tr>
          <th>아이디</th>
          <td>
          <input type="text" name="id" id="id" 
          class="input_box" size="14" />
          </td>
         </tr>
         
         <tr>
           <th>비밀번호</th>
           <td>
            <input type="password" name="pass" id="pwd" 
            size="14" class="input_box" />
           </td>
         </tr>
        </table>
        <div id="login_menu">
         <input type="submit" value="로그인" class="input_b"/>
         <input type="reset" value="취소" class="input_b"
               onclick="$('#id').focus();" />
         <input type="button" value="비번찾기" class="input_b" 
         onclick="pwd_find()" />
        </div>
      </form>
     </div>
     
     <div id="article_c">
       <p class="article_cont">
       <img src="./images/bg.png" border="0" width="600"/></p>
     </div>
    </div>
    
    <div class="clear"></div>
    
    <!-- 하단 내용 -->
    <div id="footer">
    <h2 class="footer_title">
       choongang. TEL) 02-1111-1234, FAX) 02-1111-1119
    </h2>
    </div>
 </div>
</body>
</html>