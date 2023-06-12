<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table">
	<tr>
		<th>제목</th>
		<td>${board.title }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${board.writer }</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate }"/></td>
		<th>수정일</th>
		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updatedate }"/></td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<c:choose>
		<c:when test="${not empty board.image }">
		<td><img src="<c:url value="/resources/images/${board.image }"/>"/></td>
		</c:when>
		<c:otherwise>
		<td>파일없음</td>
		</c:otherwise>
		</c:choose>
	</tr>
	<tr>
		<th>내용</th><td><textarea rows="3" cols="2" style="width:200px;" readonly>${board.contents }</textarea></td>
	</tr>
</table>
<button onclick="location.href='updateBoard?bno=${board.bno}'">수정</button>
<button onclick="location.href='deleteBoard?bno=${board.bno}'">삭제</button>
