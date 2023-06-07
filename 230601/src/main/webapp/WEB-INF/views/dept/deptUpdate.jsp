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
	<form onsubmit="return false">
		<table border="1">
			<tr>
				<th>departmentId</th>
				<td><input name="departmentId" value="${dept.departmentId }"
					readonly></td>
			</tr>
			<tr>
				<th>departmentName</th>
				<td><input name="departmentName"
					value="${dept.departmentName }"></td>
			</tr>
			<tr>
				<th>manager</th>
				<td><select name="managerId">
						<c:forEach var="mgr" items="${mgrList }">
							<c:choose>
								<c:when test="${dept.managerId eq mgr.MANAGER_ID }">
									<option value="${mgr.MANAGER_ID }" selected>${mgr.FIRST_NAME }</option>
								</c:when>
								<c:otherwise>
									<option value="${mgr.MANAGER_ID }">${mgr.FIRST_NAME }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>location</th>
				<td><c:forEach var="location" items="${locationList }">
						<c:choose>
							<c:when test="${dept.locationId eq location.LOCATION_ID }">
								<label>${location.STREET_ADDRESS } <input type="radio"
									name="locationId" value="${location.LOCATION_ID }" checked>
								</label>
							</c:when>
							<c:otherwise>
								<label>${location.STREET_ADDRESS } <input type="radio"
									name="locationId" value="${location.LOCATION_ID }">
								</label>
							</c:otherwise>
						</c:choose>
					</c:forEach></td>
			</tr>
		</table>
		<button type="submit">수정</button>
		<button type="button" onclick="location.href='deptList'">목록</button>
	</form>

	<script>
		let result = "${updateRes}";
		
		document.querySelector('button[type=submit]').addEventListener('click',function(e){
			let form = document.querySelector('form');
			let data =[{
					'departmentId' : form.departmentId.value,
					'departmentName' : form.departmentName.value,
					'managerId' : form.managerId.value,
					'locationId' : form.locationId.value
			}]
			
			
			fetch('deptUpdate',{
				method : 'POST',
				headers :{
					'content-type' : 'application/json'					
				},
				body : JSON.stringify(data),
			})
			.then(response => response.text())
			.then(result => {
				console.log(result);
				if(result != "" && result != null){
			let msg = `결과 : ${result.result}\n 
					   성공 : ${result.success}\n
					   대상 : ${result.deptList}`;
			alert(msg);
		}
		
			})
			.catch(err => console.log(err));
			
		})
	</script>
</body>
</html>