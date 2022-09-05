<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file = "../include/header.jsp" %>
<style>
div.detail {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
h1 {
	font-weight: 900;
}

</style>
</head>
<body>


<div class="detail">
<h1>${news.title}</h1>
<div>
<p>작성자 : ${news.writer}</p>
<p>작성일 : ${news.date}</p>
</div>
<div>${news.context}</div>
<div><img src="${rootPath}/upload/${news.images}" width="300px"></div>


</div>
</body>
</html>