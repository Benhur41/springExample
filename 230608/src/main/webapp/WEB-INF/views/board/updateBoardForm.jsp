<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <form action="updateBoard" method="POST">
<table class="table">
	<tr>
		<th>제목</th>
		<td><input name="title" value="${board.title }"/></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input name="writer" value="${board.writer }"/></td>
	</tr>
	<tr>
		<th>작성일</th>
		<td><input name="regdate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate }"/>"/></td>
		<th>수정일</th>
		<td><input name="updatedate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${board.updatedate }"/>"/></td>
	</tr>
	<tr>
		<th>첨부파일</th><td><input name="image" value="${board.image }"/></td>
	</tr>
	<tr>
		<th>내용</th><td><textarea name="contents" rows="3" cols="2" style="width:200px;" >${board.contents }</textarea></td>
	</tr>
	<tr>
		<td><input type="hidden" name="bno" value="${board.bno }"></td>
	</tr>
</table>
<button type="submit">수정</button>
<button type="button" onclick="location.href='boardList'">목록</button>
</form>