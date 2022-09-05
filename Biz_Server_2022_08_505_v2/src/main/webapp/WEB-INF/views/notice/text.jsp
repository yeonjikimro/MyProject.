<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div.title {
		display: flex;
		flex-direction: column;
		margin: 300px auto;
		width: 60%;
	}

	table {
		border-collapse: collapse;
	}
	button {
		width: 100px;
		margin-left: auto;
		margin-top: 100px;
	}
	table tr th {
		border-bottom: 2px solid #ccc;
		
	}
	table tr td {
		border-bottom: 1px solid #ccc;
		text-align: center;
		margin-bottom: 30px;
	}
</style>
</head>
<body>
<div class="title">
<table>
<colgroup>
	<col width="100px">
	<col width="300px">
	<col width="300px">
	<col width="100px">
	<col width="100px">
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
		<c:forEach items="${NOTICE}" var="notice">
		<tr>
			<td>${notice.seq}</td>
			<td><a href="${rootPath}/notice/${notice.seq}/detail">${notice.title}</a></td>
			<td>${notice.context}</td>
			<td>${notice.id}</td>
			<td>${notice.date}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
		<button type="submit"><a href="${rootPath}/notice/input">글 작성</a></button>

</div>
</body>
</html>