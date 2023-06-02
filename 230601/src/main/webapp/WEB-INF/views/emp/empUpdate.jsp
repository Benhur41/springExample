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
	<form action="empUpdate" method="POST" name="frm">
		<table border="1">
			<tr>
				<th>employeeId</th>
				<td><input name="employeeId" value="${emp.employeeId }" readonly></td>
			</tr>
			<tr>
				<th>lname</th>
				<td><input name="lastName" value="${emp.lastName }"></td>
			</tr>
			<tr>
				<th>email</th>
				<td><input name="email" value="${emp.email }"></td>
			</tr>
			<tr>
				<th>jobid</th>
				<td><select name="jobId">
						<option>선택</option>
						<c:forEach var="job" items="${jobs }">
							<c:choose>
							<c:when test="${emp.jobId eq job.jobId }">
							<option value="${job.jobId }" selected>${job.jobTitle }</option>
							</c:when>
							<c:otherwise>
							<option value="${job.jobId }">${job.jobTitle }</option>							
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</select></td>
			</tr>
			<tr>
				<th>departmentId</th>
				<td>
					<c:forEach var="dept" items="${deptId }">
					<div>
						<label>${dept.DEPARTMENT_NAME}
							<c:choose>
							<c:when test="${emp.departmentId eq dept.DEPARTMENT_ID }">						
								<input type="radio" value="${dept.DEPARTMENT_ID }" name="departmentId" checked>
							</c:when>
							<c:otherwise>
								<input type="radio" value="${dept.DEPARTMENT_ID }" name="departmentId">
							</c:otherwise>
							</c:choose>
						</label>
					</div>
					</c:forEach>
				</td>
			</tr>
		</table>
		<button>수정</button>
	</form>
</body>
</html>