<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		margin: 50px auto;
	}
	form input {
		margin-bottom: 50px;
	}
</style>
</head>
<%@ include file="../include/header.jsp" %>
<body>

<form method="post">
	<input type="text" name="title" placeholder="제목을 입력하세요" style="width: 1000px;" value="${NOTICE.title}">
	<input type="text" name="context" placeholder="내용을 입력하세요" style="width:1000px; height: 500px;" value="${NOTICE.context}">
	<input type="file" name="file" value="${NOTICE.file}">
	<button type="submit">등록하기</button>
</form>

</body>
</html>