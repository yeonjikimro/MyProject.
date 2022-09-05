<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file = "../include/header.jsp" %>
<style>
ul.list li a {
	text-decoration: none;
	cursor: pointer;
}
div.box {
	display:flex;
	flex-direction: column;
	justify-content: center;
	text-align: center;
}
	
</style>
<script src="${rootPath}/static/js/checkButton.js?22-09-05-001"></script>
</head>
<body>

<div class="box">
<h1>${USER.username}님의 마이페이지</h1>
<div id="result"></div>
	<ul class="list">
		<li><a href="${rootPath}/user/jjim">찜한 리스트</a></li>
		<li><a href="${rootPath}/user/test">쩌구</a></li>
	</ul>
</div>

<c:choose>
	<c:when test="${LAYOUT == 'TEST'}">
		<%@ include file="/WEB-INF/views/user/test.jsp" %>
	</c:when>
	<c:when test= "${LAYOUT == 'JJIM'}">
		<%@ include file="/WEB-INF/views/user/jjim.jsp" %>
	</c:when>

</c:choose>

</body>
</html>