<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${gildong}</h3>
<form action="loginOk.ko" method="post">
<label>id</label>
<input type="text" name="id"><br>
<label>password</label>
<input type="password" name="password"><br>
<input type="submit" value="로그인">
<input type="reset" value="취소">
</form>
</body>
</html>