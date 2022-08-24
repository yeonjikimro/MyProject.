<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
* {
	box-sizing: border;
	margin: 0;
	padding: 0;
}

html {
	width: 100vw;
	height: 100vh;
}

body {
	width: 100vw;
	height: 100vh;
	display: flex;
	flex-direction: column;
}

nav {
	background-color: #691417;
	color: white;
	height: 10%;
	marin-top: 30px;
}

nav ul {
	list-style: none;
	display: flex;
	vertical-align: middle;
	margin-bottom: 0;
}

nav li {
	padding-top: 30px;
	display: flex;
	vertical-align: middle;
	display: flex;
	margin-bottom: 0;
}


nav li:hover {
	cursor: pointer;
		border-bottom: 3px solid transparent;
	transition: 1s;
}

nav a {
	text-decoration: none;
	color: inherit;
	padding: 0 12px;
}

nav a:hover {
	border-bottom: 3px solid #ddd
}

nav li:nth-of-type(5) {
	margin-left: auto;
}

nav li:nth-of-type(1) {
	margin-left: 20px;
}

nav li:last-of-type {
	margin-right: 30px;
}

article.welcome {
	height: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

nav li img {
	width: 200px;
}
</style>
</head>
<body>
	<nav>
		<ul>
			<li><a href="${rootPath}/"><img alt="logo" src="${rootPath}/static/images/header4.png" ></a></li>
			<li><a href="${rootPath}/">HOME</a></li>
			<li><a href="${rootPath}/classic/test">맞춤 클래식 찾아보기</a></li>
			<li><a href="${rootPath}/music/search">음악 검색하기</a></li>
			<li><a href="${rootPath}/notice/text">게시판</a></li>

			<sec:authorize access="isAnonymous()">
				<li><a href="${rootPath}/user/login">로그인</a></li>
				<li><a href="${rootPath}/user/join">회원가입</a></li>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<li><a href="${rootPath}/">로그아웃</a></li>
				<li><a href="${rootPath}/user/mypage">myPage</a></li>
			</sec:authorize>
		</ul>
	</nav>

	<c:choose>
		<c:when test="${LAYOUT == 'JOIN' }">
			<%@ include file="/WEB-INF/views/user/join.jsp"%>
		</c:when>
		<c:when test="${LAYOUT == 'LOGIN' }">
			<%@ include file="/WEB-INF/views/user/login.jsp"%>
		</c:when>
	</c:choose>




	<form:form class="logout" action="${rootPath}/logout" />

</body>
</html>