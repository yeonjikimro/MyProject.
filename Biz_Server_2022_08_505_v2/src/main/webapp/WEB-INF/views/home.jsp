<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="./include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
section.main {
	flex: 1;
}

ul {
	display: flex;
	list-style: none;
	flex-wrap: wrap;
}

article.welcome {
	height: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
img {
	width: 150px;
}
</style>
</head>
<body>

	<section class="main">

				<article class="welcome">
					<h1>클래식 정보</h1>
					<ul>
					<c:forEach begin="1" end="3" items="${SEARCH}" var="poster" >
						<li><img src="${poster.IMGSRC}"></li>
					</c:forEach>
					</ul>
				</article>
</section>
</body>
</html>