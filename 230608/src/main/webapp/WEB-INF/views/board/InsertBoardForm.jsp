<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<form id="insertForm" action="insertBoard" method="POST" style="margin:40px">
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
</form>
<script>
	document.querySelector('#insertForm').addEventListener('submit',function(e){
		e.preventDefault();
		console.log(e.target);
		
		let title = document.querySelector('input[name=title]');
		let writer = document.querySelector('input[name=writer]');
		let contents = document.querySelector('textarea');
		
		
		if(title.value ==''){
			alert('제목을 작성하세요');
			title.focus();
			return;
		}
		if(writer.value ==''){
			alert('작성자를 작성하세요');
			writer.focus();
			return;
		}
		if(contents.value ==''){
			alert('내용을 작성하세요');
			contents.focus();
			return;
		}
		
		e.target.submit();
		
	})
</script>
