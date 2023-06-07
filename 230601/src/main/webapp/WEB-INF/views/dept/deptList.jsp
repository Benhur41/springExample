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
<button type="button" id="checkDel">선택삭제</button>
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
				<tr onclick="findDeptInfo(event,${dept.departmentId})">
					<td><input type="checkbox" name="dept" value="${dept.departmentId }"></td>
					<td>${dept.departmentId}</td>
					<td>${dept.departmentName}</td>
					<td>${dept.managerId}</td>
					<td>${dept.locationId}</td>
					<td><button type="button" class="delete">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="deptDelete" name="del">
		
	</form>
	<script>
		window.onload=function(){
			if('${msg}' !=''){
				alert('${msg}')
			}
		}
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
		
		document.querySelectorAll('.delete').forEach(del => {
			del.addEventListener('click',function(e){
				let deptNo = e.target.parentElement.parentElement.children[1].innerText;
				insertDeptInfo(0,deptNo);
				let form = document.querySelector('form[name=del]');
				form.submit();
			})
		})
		
		document.getElementById('checkDel').addEventListener('click',function(e){
			let checked = document.querySelectorAll('input[type=checkbox]:checked');
			if(checked.length > 0){
			for(let i=0;i< checked.length;i++){
				let deptNo = checked[i].parentElement.nextElementSibling.textContent;
				insertDeptInfo(i,deptNo);
			}
			let form = document.querySelector('form[name=del]');
			form.submit();
				
			}

		})
		
		
		function insertDeptInfo(index , deptNo){
			let inputTag = document.createElement('input');
			inputTag.type='hidden';
			inputTag.name = 'deptList['+index+'].departmentId';
			inputTag.value=deptNo;
			let formTag = document.getElementsByName('del')[0];
			formTag.append(inputTag);
		}
		
		function findDeptInfo(event,deptNo){
			
			if(event.target.tagName != 'INPUT' && event.target.tagName != 'BUTTON')
				location.href='deptUpdate?departmentId='+deptNo;
			
			/* event.target // 실제 이벤트가 발생한 태그 : 고정값
			event.currentTarget // this 같은의미 -> 지금 해당 이벤트에 대해 동작을 하는 태그 : ex)tr
			event.preventDefault();// 기본으로 등록된 이벤트 동작을 막음
			event.stopPropagation();// 이벤트 버블링 (전파) 막음 */
		}
	</script>
</body>
</html>