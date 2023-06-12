<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="updateForm" action="updateBoard" method="POST" onsubmit="return false">
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input name="title" value="${board.title }" /></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input name="writer" value="${board.writer }" /></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><input type="date" name="regdate"
				value="<fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate }"/>" /></td>
			<th>수정일</th>
			<td><input type="date" name="updatedate"
				value="<fmt:formatDate pattern="yyyy-MM-dd" value="${board.updatedate }"/>" /></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<c:choose>
				<c:when test="${not empty board.image }">
					<td><input name="image" value="${board.image }"
						style="display: block" /><img
						src="<c:url value="/resources/images/${board.image }"/>" /></td>
				</c:when>
				<c:otherwise>
				<td><input name="image" value="${board.image }"
						style="display: block" /></td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="contents" rows="3" cols="2"
					style="width: 200px;">${board.contents }</textarea></td>
		</tr>
		<tr>
			<td><input type="hidden" name="bno" value="${board.bno }"></td>
		</tr>
	</table>
	<button onclick="updateAjax()">수정</button>
</form>

<script>
 function updateAjax(e){
	let formData = new FormData(document.querySelector('#updateForm'));
	
	fetch('updateBoard',{
		method:"POST",
		body: formData
	})
	.then(response => response.json())
	.then(data => {
		let msg = ` 결과 : `+ data.result+
					`게시글 번호 :` + data.bno;
		alert(msg);
		location.href="boardInfo?bno="+data.bno;
	})
	.catch(err => console.log(err))
 }
</script>
