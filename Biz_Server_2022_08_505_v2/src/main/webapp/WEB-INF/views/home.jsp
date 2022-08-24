<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="./include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="${rootPath}/static/js/slide.js?22-08.24-005"></script>
<style>
div.images {
	display: flex;
	width: 600px;
	height: 400px;
	transition: 1s;
}

div.images img {
	width: 800px;
	margin: 0 10px;
}

div.image_window {
	width: 300px;
	height: 400px;
	overflow: hidden;
	position: relative;
}

div.btn_box {
	width: 600px;
	display: flex;
	position: absolute;
	left: 0;
	bottom: 0;
	padding: 30px 20px;
	z-index: 100;
	opacity: 0;
	transition: opacity 0.6s;
}

div.btn_box:hover {
	opacity: 1;
}

div.badge {
	flex: 1;
	display: flex;
	justify-content: center;
	align-items: center;
}

span.badge {
	background-color: #000;
	color: #fff;
	display: inline-block;
	border-radius: 50%;
	border: 2px solid white;
	width: 15px;
	height: 15px;
	margin: 0 5px;
}

span.badge:hover {
	cursor: pointer;
	background-color: white;
}

button.btn {
	width: 100px;
	height: 30px;
	border: none;
	color: white;
	background-color: transparent;
}

button.btn.prev {
	margin-right: auto;
}

button.btn.next {
	margin-left: auto;
}
section.main {
	display: flex;
	flex: 1;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>
<section class="main">
		<h1>클래식 정보</h1>
		<div class="image_window">
			<div class="images">
				<c:forEach begin="1" end="5" items="${SEARCH}" var="poster">
					<img src="${poster.IMGSRC}">
				</c:forEach>
			</div>
			<div class="btn_box">
				<button class="btn_prev">&#10094;</button>
				<div class="badge"></div>
				<button class="btn_next">&#10095;</button>
			</div>
		</div>
</section>
</body>
</html>