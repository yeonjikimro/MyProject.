<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
	section.title {
		margin: 40px auto;
	}

	table {
		margin: 40px auto;
	}
	button {
		width: 100px;
		margin-left: 0;
	}
</style>
</head>
<body>
<section class="title">
<table class="w3-table w3-striped w3-bordered">
<colgroup>
	<col width="30px">
	<col width="100px">
	<col width="100px">
	<col width="40px">
	<col width="40px">
</colgroup>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성날짜</th>			
		</tr>
	</thead>
	<tbody>
		<tr>
		<c:forEach items="${NOTICE}" var="notice">
			<td>${notice.seq}</td>
			<td>${notice.title}</td>
			<td>${notice.context}</td>
			<td>${notice.id}</td>
			<td>${notice.date}</td>
		</c:forEach>
		</tr>
	</tbody>
</table>
		<button type="submit"> 글 작성</button>

</section>
</body>
</html>