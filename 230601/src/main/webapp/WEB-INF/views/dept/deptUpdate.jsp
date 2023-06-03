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
	<form action="deptUpdate" method="POST">
		<table border="1">
			<tr>
				<th>departmentId</th>
				<td><input name="departmentId" value="${dept.departmentId }" readonly></td>
			</tr>
			<tr>
				<th>departmentName</th>
				<td><input name="departmentName" value="${dept.departmentName }"></td>
			</tr>
			<tr>
				<th>manager</th>
				<td>
					<select name="managerId">
						<c:forEach var="mgr" items="${mgrList }">
							<c:if test="${dept.managerId eq mgr.MANAGER_ID }">
								<option value="${mgr.MANAGER_ID }" selected>${mgr.FIRST_NAME }</option>
							</c:if>
								<option value="${mgr.MANAGER_ID }">${mgr.FIRST_NAME }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>location</th>
				<td>
					<c:forEach var="location" items="${locationList }">
					<c:if test="${dept.locationId eq location.LOCATION_ID }">
					<label>${location.STREET_ADDRESS }
						<input type="radio" name="locationId" value="${location.LOCATION_ID }" checked>
						</label>
					</c:if>
						<label>${location.STREET_ADDRESS }
						<input type="radio" name="locationId" value="${location.LOCATION_ID }">
						</label>
					</c:forEach>
				</td>
			</tr>
		</table>
		<button type="submit">수정</button>
		<button type="button" onclick="location.href='deptList'">목록</button>
	</form>
</body>
</html>