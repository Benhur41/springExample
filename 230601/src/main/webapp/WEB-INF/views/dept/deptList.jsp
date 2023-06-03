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
	<h1>department 조회</h1>
<a href="deptInsert">등록</a>
<form action="deptList">
	부서ID<input name="departmentId">
	locationID<input name="locationId">
	<button>검색</button>
</form>
	<table border="1">
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서</th>
				<th>ManagerId</th>
				<th>locationId</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dept" items="${deptList }">
				<tr>
					<td>${dept.departmentId}</td>
					<td>${dept.departmentName}</td>
					<td>${dept.managerId}</td>
					<td>${dept.locationId}</td>
					<td><a href="deptUpdate?departmentId=${dept.departmentId }">수정</a></td>
					<td><a href="deptDelete?departmentId=${dept.departmentId }">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>