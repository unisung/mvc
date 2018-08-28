<%@page import="com.gongji.model.GongjiBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>
<div class="clear"></div>
<div id="article">
<%@ include file="../include/login.jsp" %>
<div id="article_c">
<div id="uGongji_wrap">
<c:if test="${not empty gongji}">
 <h2 class="uGongji_title">사용자 공지 보기</h2>
 <table id="uGongji_t">
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
 
 <div id="uGongji_menu">
  <input type="button" value="목록" class="gbutton_b" 
                 onclick="location.href='gongji_list.do?page=${page}'"/>
 </div>
 
</div>
</div>
</div>
<div class="clear"></div>
<%@ include file="../include/footer.jsp" %>
