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
	<form action="deptInsert" method="POST">
		<table border="1">
			<tr>
				<th>departmentName</th>
				<td><input name="departmentName" required></td>
			</tr>
			<tr>
				<th>manager</th>
				<td>
					<select name="managerId">
					<option>선택</option>
						<c:forEach var="mgr" items="${mgrList }">
						<option value="${mgr.MANAGER_ID }">${mgr.FIRST_NAME }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>location</th>
				<td>
					<c:forEach var="location" items="${locationList }">
						<label>${location.STREET_ADDRESS }
						<input type="radio" name="locationId" value="${location.LOCATION_ID }">
						</label>
					</c:forEach>
				</td>
			</tr>
		</table>
		<button type="submit">저장</button>
		<button type="button" onclick="location.href='deptList'">목록</button>
	</form>
</body>
</html>