<%@page import="com.gongji.model.GongjiBean"%><%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="../include/header.jsp" %>

<div class="clear"></div>
<div id="article">
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
			<th class="no">수정</th>
			<th class="no">삭제</th>
		</tr>
		<c:if test="${not empty gongjiList }">
		<c:forEach var="g" items="${gongjiList}">
		<tr align="center" valign="middle">
			<td height="23">
			${g.gongji_no}
			</td>
			<td>
				<a href="gongji_cont.do?gongji_no=${g.gongji_no}&page=${page}" 
				onfocus="this.blur()">${g.gongji_title}</a>
			</td>
			<td>
			${g.gongji_name }
			</td>
			<td>
				${fn:substring(g.gongji_regdate,0,10)}
			<%-- ${g.getGongji_regdate().substring(0,10)} --%>
			</td>
			<td>
			${g.gongji_hit}
			</td>
			<td>
			<input type="button" value="수정" class="admin_b" 
			onclick="location='admin_gongji_edit.do?gongji_no=${g.gongji_no}&page=${page}&stat=cont'" onfocus="this.blur();">
			</td>
			<td>
			<input type="button" value="삭제" class="admin_b"
			onclick="if(confirm('정말로 삭제하시겠습니까?'))
					{location.href='admin_gongji_del_ok.do?gongji_no=${g.gongji_no}&page=${page}';}
					else{return;}">
			</td>
		</tr>
		</c:forEach>
		</c:if>
		</table>
		<div id="Glist_paging">
		<c:if test="${page<=1}">
			[이전]
		</c:if> 
		<c:if test="${page>1 }">
		<a href="gongji_list.do?page=${page-1}" onfocus="this.blur();">[이전]</a>&nbsp;
			[이전]		
		</c:if>
		<c:forEach var="i" begin="${startpage}" end="${endpage>=maxpage?maxpage:endpage}">
			<c:if test="${i==page}">[${i}]</c:if>
			<c:if test="${i!=page}">
			<a href="gongji_list.do?page=${i}" onfocus="this.blur()">[${i}]</a>
			</c:if>
		</c:forEach>
		
		<c:if test="${page>=maxpage}">
			[다음]		
		</c:if>
		<c:if test="${page<maxpage}">
			<a href="gongji_list.do?page=${page+1}" onfocus="this.blur();">[다음]</a>&nbsp;
			[다음]
		</c:if>
		</div>
		<div id="aGlist_menu">
			<a href="admin_gongji_write.do" onfocus="this.blur();">[공지작성]</a>		
		</div>
		
		<div id="aGlist_find">
			<form method="get" action="admin_gongji_find.do" onsubmit="return find_check()">
			<table id="aGlistFind_t">
				<tr>
				<td>
				<select name="find_field">
					<option value="gongji_title">공지제목</option>
					<option value="gongji_cont">공지제목</option>
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
</div>
<div class="clear"></div>