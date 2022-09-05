<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<style>
div.input {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
form {
	display: flex;
	flex-direction: column;
}
form input {
	margin-top: 30px;
	width: 600px;
}
	
</style>
</head>
<body>
<div class="input">
<form method="post" action="${rootPath}/news/input" enctype="multipart/form-data">
	<input type="text" name="title" placeholder="제목을 입력하세요">
	<input type="text" name="context" style="height: 300px;" placeholder="내용을 입력하세요">
	<input type="file" name="file">
	<button type="submit">등록</button>
</form>
</div>
</body>
</html>