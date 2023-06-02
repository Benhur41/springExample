<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>사원 조회</h1>
<a href="empInsert">등록</a>
<form action="empList">
	부서<input name="departmentId" value="${emp2.departmentId }">
	fname<input name="firstName" value="${emp2.firstName }">
	<button>검색</button>
	<button type="reset">초기화</button>
</form>
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>부서번호</th>
				<th>부서</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${empList }">
				<tr>
					<td>${emp.employeeId }</td>
					<td>${emp.firstName } ${emp.lastName }</td>
					<td>${emp.email }</td>
					<td>${emp.departmentId }</td>
					<td>${emp.jobId }</td>
					<td><a href="empUpdate?employeeId=${emp.employeeId }">수정</a></td>
					<td><a href="empDelete?employeeId=${emp.employeeId }" onclick="return check">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		function check(){
			return prompt('진짜 삭제?')
		}
	</script>
</body>
</html>