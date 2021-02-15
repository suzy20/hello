<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${result > 0 }">
		<script type="text/javascript">
			alert("입력 성공")
			// location.href="empList.do?deptno=${emp.deptno}";
			location.href="empSelect.do?empno=${emp.empno}";
		</script>
	</c:if>
	<c:if test="${result == 0 }">
		<script type="text/javascript">
			alert("입력 실패");
			history.go(-1);
		</script>
	</c:if>
	<c:if test="${result == -1 }">
		<script type="text/javascript">
			alert("이미 있는 사원 입니다. 다른 사원을 입력해 주세요");
			history.go(-1);
		</script>
	</c:if>
</body>
</html>