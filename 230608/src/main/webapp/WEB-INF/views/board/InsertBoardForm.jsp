<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<form action="insertBoard" method="POST" style="margin:40px">
<table class="table">
	<tr>
		<th>제목</th>
		<td><input name="title"></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input name="writer"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="contents" rows="3" cols="2" style="width:200px;" ></textarea></td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td><input type="text" name="image"></td>
	</tr>
</table>
<button type="submit">작성</button>
<button type="button" onclick="location.href='boardList'">목록</button>
</form>
