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
	<form action="empInsert" method="POST">
		<table border="1">
			<tr>
				<th>lname</th>
				<td><input name="lastName"></td>
			</tr>
			<tr>
				<th>email</th>
				<td><input name="email"></td>
			</tr>
			<tr>
				<th>jobid</th>
				<td><select name="jobId">
						<option>선택</option>
						<c:forEach var="job" items="${jobs }">
							<option value="${job.jobId }">${job.jobTitle }</option>
						</c:forEach>
					</select></td>
			</tr>
			<tr>
				<th>departmentId</th>
				<td>
					<c:forEach var="dept" items="${deptId }">
					<div>
						<label>${dept.DEPARTMENT_NAME}<input type="radio" value="${dept.DEPARTMENT_ID }" name="departmentId"></label>
					</div>
					</c:forEach>
				</td>
			</tr>
		</table>
		<button>저장</button>
	</form>
</body>
</html>