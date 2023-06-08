<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
<title>게시판</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-12">
        	<header>
			<tiles:insertAttribute name="header" />
		</header>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10">
        	<main>
			<tiles:insertAttribute name="body" />
		</main>
        </div>
        <div class="col-md-2" ><img src="resources/images/virus.png"></div>
    </div>
    <div class="row">
        <div class="col-xs-12">
        	<footer>
			<tiles:insertAttribute name="footer" />
		</footer>
        </div>
    </div>
    <div class="row"></div>
    <div class="row"></div>
</div>
</body>
</html>