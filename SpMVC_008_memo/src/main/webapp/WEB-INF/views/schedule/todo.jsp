<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<script>
	const rootPath = '${rootPath}'
</script>
</head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<%@ include file="../include/header.jsp"%>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html {
	width: 100vw;
	height: 100vh;
}

body {
	width: 100%;
	height: 100%;
	margin: 20px auto;
	display: flex;
	flex-direction: column;
}

header {
	padding: 2rem;
	display: flex;
}


.header_1 {
	width: 400px;
	height: 100px;
}

#logo {
	width: 100px;
	float: left;
	margin-left: 100px;
}

#logo a img {
	width: 100px;
}

nav {
	color: black;
	width: 1000px;
	margin-left: auto;
	margin-top: 30px;
}

nav ul {
	list-style: none;
	margin-bottom: 0;
	display: flex;
}

nav li {
	padding: 3px 16px;
	margin-right: 15px;
	border-bottom: 5px solid transparent;
	font-weight: 900;
	font-size: 20px;
	transition: border 0.7s ease-out;
	line-height: 50px;
}

nav li:hover {
	cursor: pointer;
	border-bottom: 5px solid #d4b631;
}

nav ul li:nth-of-type(6) {
	margin-left: auto;
}

a {
	text-decoration: none;
}

nav a {
	color: inherit;
	white-space: nowrap;
}

.line {
	border: 5px solid black;
	margin-right: 0;
	height: 10px;
}


div.menu_2, div.menu_3 {
	margin: 0 150px;
}

div.menu_4 {
	display: flex;
	flex-direction: column;
	justify-content: center;
	width: 70%;
	align-items: center;
	margin: 100px auto;
	
}

table {
	width: 50%;
	margin: 30px auto;
}

table tr td {
	text-align: center;
}

div form.content {
	display: flex;
	flex-direction: row;
	margin: 40px auto;
}

div form.content input {
	width: 500px;
}

tbody tr td.but {
	text-decoration: none;
	color: inherit;
}

tbody tr td#but2 {
	margin: 0 auto;
}
</style>

<body>

<!-- 	<div class="menu_1"> -->
<!-- 		<div class="menu_2">todo list</div> -->
<!-- 		<div class="menu_3">일정표</div> -->
<!-- 	</div> -->
	<div class="menu_4">
		<h1>TodoList</h1>
		<table class="w3-table w3-stripe">
			<thead>
				<tr>
					<th>작성 날짜</th>
					<th>작성 시간</th>
					<th>할 일</th>
					<th>완료 날짜</th>
					<th>완료 시간</th>
					<th>완료 여부</th>
				</tr>
			</thead>
			<c:forEach items="${TODOMENU}" var="TODO">
				<tbody>
					<tr class="w3-border-bottom">
						<td>${TODO.p_date}</td>
						<td>${TODO.p_time}</td>
						<c:if test="${TODO.complete == true}">
							<td style="text-decoration: line-through">${TODO.t_context}</td>
						</c:if>
						<c:if test="${empty TODO.complete || TODO.complete == false }">
							<td>${TODO.t_context}</td>
						</c:if>
						<td>${TODO.c_date}</td>
						<td>${TODO.c_time}</td>
						<td class="but"><a
							href="${rootPath}/schedule/${TODO.t_seq}/complete"
							class="w3-button w3-red">완료</a></td>
						<td class="but" id="but2"><a
							href="${rootPath}/schedule/${TODO.t_seq}/update"
							class="w3-button w3-black">수정</a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>

		<form:form class="content">
			<input name="t_context" placeholder="할 일을 입력하세요"
				value="${TODO.t_context}">
			<button type="submit">등록</button>
		</form:form>
	</div>
</body>
</html>