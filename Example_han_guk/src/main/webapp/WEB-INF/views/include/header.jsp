<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	box-sizing: border;
	margin: 0;
	padding: 0;
}

body {
	margin: 0;
	width: 100vw;
	height: 100vh;
}

div.header {
	height: 20%;
}

nav.header ul {
	display: flex;
	flex-direction: row;
	vertical-align: middle;
}

nav.header ul li {
	display: flex;
	vertical-align: middle;
	list-style: none;
	padding: 10px;
	margin-top: 30px;
	font-size: 20px;
	margin-right: 40px;
}

nav.header img {
	width: 40px;
	height: 40px;
}

nav.header  ul li:nth-of-type(9), nav ul li:nth-of-type(8) {
	font-size: 10px;
}

nav.header ul li:hover {
	cursor: pointer;
}

nav.header ul li.second {
	margin-left: auto;
}

nav.header ul li:last-of-type {
	margin-right: 100px;
}

ul li a {
	text-decoration: none;
	color: inherit;
}
</style>
</head>
<script>
	const rootPath = '${rootPath}'
</script>

<body>
	<div class="header">
		<nav class="header">
			<ul>
				<li><img src="${rootPath}/static/images/dor.jpeg"></li>
				<li class="second">company</li>
				<li>건축/설계</li>
				<li>CM/감리</li>
				<li><a href="${rootPath}/news/notice">NEWS</a></li>
				<li>RECRUIT</li>
				<li>CONTACT</li>
				<li>한국어</li>
				<li>English</li>

			</ul>

		</nav>
	</div>

</body>
</html>