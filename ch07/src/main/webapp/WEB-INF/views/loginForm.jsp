<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2 class="text-primary">로그인</h2>
		<form action="login.do">
			<table class="table table-bordered table-hover">
				<tr>
					<td>아이디<span class="glyphicon glyphicon-user"></span></td>
					<td><input type="text" name="id" required="required" autofocus="autofocus"></td>
				</tr>
				<tr>
					<td>암호<span class="glyphicon glyphicon-lock"></span></td>
					<td><input type="password" name="password" required="required"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="확인"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>