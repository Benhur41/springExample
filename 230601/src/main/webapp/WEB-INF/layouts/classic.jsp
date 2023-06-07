<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<title>zz</title>
<style>
	#container{
		margin: 0 auto;
		width:1400px;
		text-align: center;
	}
</style>
</head>
<body>
	<div id="container">
		<header>
			<tiles:insertAttribute name="header" />
		</header>
		<div style="text-align: center;">
		<body>
			<tiles:insertAttribute name="content" />
		</body>
		</div>
		<footer>
			<tiles:insertAttribute name="footer" />
		</footer>
	</div>
</body>
</html>