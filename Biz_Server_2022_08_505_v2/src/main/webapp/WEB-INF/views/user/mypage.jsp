<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file = "../include/header.jsp" %>
<style>

div.box {
	display:flex;
	flex-direction: column;
	justify-content: center;
	text-align: center;
	margin: 100px auto;
}


table {
	margin-top : 50px;
	width: 100%;
}
tr td {
	padding-right: 30px;
}

button {
	width: 30px;
}
	
</style>
</head>
<body>

<div class="box">
	<h1>${USER.username}님이 찜한 리스트</h1>
	<div>
	<table>
		<tr>
			<th>음악 제목</th>
			<th>음악가 </th>
		</tr>
		<c:forEach items="${cht}" var="cht">
			<tr>
				<td>${cht.song}</td>
				<td>${cht.musician}</td>
				<td> <input type="button" value="삭제"></td>
			</tr>
		
		</c:forEach>
	</table>
	</div>
</div>



</body>
</html>