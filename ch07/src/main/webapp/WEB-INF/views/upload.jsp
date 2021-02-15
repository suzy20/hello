<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>업로드 성공</h2> <p>
	아이디 : ${id } <p>
	이름 : ${name } <p>
	파일명 : ${fileName } <p>
	파일크기 : ${fileSize } <p>
	<img alt="" src="resources/upload/${fileName }">
</body>
</html>