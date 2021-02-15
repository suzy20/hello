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
	<div class="container">
		<h2 class="text-primary">업로드 결과</h2>
		<table class="table table-bordered">
			<tr>
				<td>아이디</td>
				<td>${id }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${name }</td>
			</tr>
			<tr>
				<td>파일명</td>
				<td>
					<!-- c:forEach items안에 여러건의 데이터를 하나씩 꺼내서 var에 저장하여 처리
					items안에 있는 데이터가 다 없어질 때 까지 -->
					<c:forEach var="fileName" items="${fileList }">
						${fileName }<br>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<c:forEach var="fileName" items="${fileList }">
						<img alt="" src="resources/upload/${fileName }" width="200">
					</c:forEach>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>