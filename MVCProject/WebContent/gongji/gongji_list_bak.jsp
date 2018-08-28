<%@page import="com.gongji.model.GongjiBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="../include/header.jsp" %>
<div class="clear"></div>
<div id='article'>
 <%@ include file="../include/login.jsp" %>
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
 	 </tr>
 	 <c:if test="${not empty gongjiList}">
 	 <c:forEach var="g" items="${gongjiList}">
 	  <tr align="center" valgin="middle">
 	   <td height="23">
 	       ${g.gongji_no}
 	   </td>
 	   <td>
 	   	<a href="gongji_cont.do?gongji_no=${g.gongji_no}&page=${page}"
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
 	  </tr>
 	  </c:forEach>
 	  </c:if>
 	</table>
 	<div id="Glist_paging">
 	<c:if test="${nowpage<=1}">
 		[이전]
 	</c:if>
 	<c:if test="${nowpage>1}">
 	  <a href="gongji_list.do?page=${nowpage-1}" onfocus="this.blur();">[이전]</a>&nbsp;
 		[이전]
 	</c:if>
 	<c:forEach var="i" begin="${startpage}" end="${endpage>=maxpage?maxpage:endpage}">
 	  <c:if test="${i==nowpage}">[${i}] </c:if>
 	  <c:if test="${i!=nowpage}">
 	  	<a href="gongji_list.do?page=${i}" onfocus="this.blur()">[${i}]</a>
 	  </c:if>
 	</c:forEach>
 	
 	 <c:if test="${nowpage>=maxpage}">
 		[다음]
 	</c:if>
 	<c:if test="${nowpage<maxpage}">
 	  <a href="gongji_list.do?page=${nowpage+1}" onfocus="this.blur();">[다음]</a>&nbsp;
 		[이전]
 	</c:if>
 	</div>
 </div>
 </div>
</div>
