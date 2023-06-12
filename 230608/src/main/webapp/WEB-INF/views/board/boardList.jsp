<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
	.pagination2 {
	display: inline-block;
	text-align: center;
	}
	
	.pagination2 a {
		color: black;
		float: left;
		padding: 15px 30px;
		text-decoration: none;
	}
	
	.pagination2 a.active1 {
		background-color: #4CAF50;
		color: white;
	}
	
	.pagination2 a:hover:not(.active1) {
		background-color: #ddd;
}
</style>
<div style="padding: 40px">
	<h1>게시판 목록 ${pageContext.request.contextPath }</h1>
	<table class="table">
		<thead>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>수정일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bd" items="${boardList }">
				<tr onclick="location.href='boardInfo?bno=${bd.bno}&writer=${bd.writer}'">
					<td>${bd.bno }</td>
					<td>${bd.title }</td>
					<td>${bd.writer }</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${bd.regdate }"/></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${bd.updatedate }"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		
		<div style="text-align: center; width: 1200px; height: 50px; padding: 30px 0; margin-bottom: 50px">
		<div class="pagination2">
					<c:if test="${pageInfo.prev }">
						<a href="boardList?page=${pageInfo.startPage-1 }">Previous</a>
					</c:if>
					<c:forEach var="i" begin="${pageInfo.startPage }"
						end="${pageInfo.endPage }">
						<a class="${i==pageInfo.pageNum ? 'active1' : '' }"
							href="boardList?page=${i }">${i } </a>
					</c:forEach>
					<c:if test="${pageInfo.next }">
						<a
							href="boardList?page=${pageInfo.endPage+1 }">Next</a>
					</c:if>
		</div>
	</div>
</div>