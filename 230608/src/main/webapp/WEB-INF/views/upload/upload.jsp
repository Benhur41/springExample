<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
</head>
<body>
	<div>
		<input name="uploadFiles" type="file" multiple/>
		<button class="uploadBtn">업로드</button>
	</div>
	<script>
		$('.uploadBtn').click(function(){
			var formData = new FormData();//FormData 객체생성
			
			var inputFile = $('input[type=file]');
			//input 태그의 type 이 file 인것을 찾아서 inputFile 이라는 변수로 지정
			
			var files = inputFile[0].files;
			//files : 선택한 모든 파일을 나열하는 FileList객체입니다
			//multiple 특성을 지정하지 않았다면 두개이상의 파일을 포함하지 않습니다.
			
			for(var i=0; i< files.length; i++){
				console.log(files[i]);
				formData.append('uploadFiles', files[i])
			}
			
			/* fetch('uploadsAjax',{
				method : 'post',
				body : formData
			})
			.then(response => response.text())
			.then(data => console.log(data))
			.catch(err => console.log(err)); */
			
			$.ajax({
				url:'uploadsAjax',
				type:'post',
				processData : false,//기본값음 true , ajax 통신을 통해 데이터를 전송할 때 , 기본적으로 key 와 value 값을 query String 으로 변환해서 보냅니다.
				contentType : false,// multipart/form-data 타입을 사용하기 위해 false로 지정합니다
				data:formData,
				success:function(result){
					console.log(result);
				},
				error:function(reject){
					console.log(reject);
				}
			})
		})
		
	</script>
</body>
</html>