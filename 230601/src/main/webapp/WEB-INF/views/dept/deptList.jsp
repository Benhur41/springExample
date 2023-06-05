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
				<th>전체선택<input type="checkbox" name="depts" onclick="allcheck(this)"></th>
				<th>부서번호</th>
				<th>부서</th>
				<th>ManagerId</th>
				<th>locationId</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dept" items="${deptList }">
				<tr>
					<td><input type="checkbox" name="dept" value="${dept.departmentId }"></td>
					<td>${dept.departmentId}</td>
					<td><a href="deptUpdate?departmentId=${dept.departmentId }">${dept.departmentName}</a></td>
					<td>${dept.managerId}</td>
					<td>${dept.locationId}</td>
					<td><a href="deptDelete?departmentId=${dept.departmentId }">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<script>
	
		function allcheck(thing){
			let checks = document.querySelectorAll('input[type=checkbox]');
			if(thing.checked == true){
				for(let i =0; i< checks.length ; i++){
					checks[i].checked = true;
				}
			}else{
				for(let i =0; i< checks.length ; i++){
					checks[i].checked = false;
				}
			}
		}
	
	</script>
</body>
</html>