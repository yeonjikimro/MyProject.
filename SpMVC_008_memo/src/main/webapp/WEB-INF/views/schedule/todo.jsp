<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>Insert title here</title>
<script>
	const rootPath = '${rootPath}'
</script>
</head>
<%@ include file="../include/header.jsp"%>
<style>
	div.menu_1 {
		display: flex;
		flex-direction: row;
		justify-content: center;
		align-items: center;
		margin: 50px auto;	
	}
	div.menu_2, div.menu_3 {
		margin: 0 150px;
	}
	div.menu_4 {
		display:flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		margin: 50px 30px;
		
	}
	
	table {
	width: 70%;
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
</style>
<body>

<div class="menu_1">
	<div class="menu_2">todo list</div>
	<div class="menu_3">일정표</div>
</div>
<div class="menu_4">
		<h1>TodoList</h1>
		<table>
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
			<tr>
				<td>${TODO.p_date}</td>
				<td>${TODO.p_time}</td>
				<c:if test="${TODO.complete == true}">
					<td style="text-decoration:line-through">${TODO.t_context}</td>
				</c:if>
				<c:if test="${empty TODO.complete || TODO.complete == false }">
					<td>${TODO.t_context}</td>
				</c:if>
				<td>${TODO.c_date}</td>
				<td>${TODO.c_time}</td>
				<td><a href="${rootPath}/schedule/${TODO.t_seq}/complete">완료</a></td>
				<td><a href="${rootPath}/schedule/${TODO.t_seq}/update">수정</a></td>
			</tr>
			</tbody>
	</c:forEach>
		</table>

		<form:form class="content">
			<input name="t_context" placeholder="할 일을 입력하세요" value="${TODO.t_context}">	
			<button type="submit">등록</button>	
		</form:form>
</div>
</body>
</html>