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
	<c:if test="${result > 0}">
		<script type="text/javascript">
			alert("로그인 성공");
		</script>
		<a href="uploadForm.do" class="btn btn-success">업로드</a>
		<a href="aa.do" class="btn btn-info">AA</a>
		<a href="logout.do" class="btn btn-danger">로그 아웃</a>
	</c:if>
	<c:if test="${result == 0 }">
		<script type="text/javascript">
			alert("로그인 실패");
			history.go(-1);
		</script>
	</c:if>
</body>
</html>