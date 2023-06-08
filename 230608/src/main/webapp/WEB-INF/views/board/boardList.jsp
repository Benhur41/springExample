<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		
</div>