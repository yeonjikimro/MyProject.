<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
</head>

<style>
div.body {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
table {
	width: 90%;
	border-collapse: collapse;
}

thead tr th {
	margin: 0; padding : 20px 0;
	border-bottom: 2px solid #ccc;
	padding: 20px 0;
}

tbody tr td {
	padding: 20px 0;
	border-bottom: 1px solid #ccc;
}
div.search_box {
	display: flex;
	width: 90%;
}
select {
	-webkit-appearance: none;
	width: 100px;
	border-radius: 2px;
}

select.left {
	margin-right: auto;
}
div.right {
	margin-left: auto;
}
div.write {
	width: 90%;
}
button.write {
	display:inline-block;
	float: right;
	margin-top: 50px;
}
button.write a {
	text-decoration: none;
	color: inherit;
}
</style>
<body>
	<div class="body">
		<div class="search_box">
			<select class="left">
				<option>전체</option>
				<option>News</option>
				<option>사내소식</option>
			</select> 
			
			<div class="right">
				<select>
					<option>전체</option>
					<option>제목</option>
					<option>내용</option>
					<option>작성자</option>
				</select>
				<input name="search">
				<button type="submit">검색</button>
			</div>


		</div>


		<table>
			<colgroup>
				<col width="">
				<col>
				<col>
				<col>
				<col>
				<col>

			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>썸네일</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${NEWS}" var="news">
				<tr>
					<td>${news.seq}</td>
					<td><img src="${rootPath}/upload/${news.images}" width="30px"></td>
					<td><a href="${rootPath}/news/${news.seq}/detail">${news.title}</a></td>
					<td>${news.writer}</td>
					<td>${news.date}</td>
				</tr>
			</c:forEach>
			</tbody>

		</table>
		<div class="write">
		<button class="write"><a href="${rootPath}/news/input">글 작성</a></button>
</div>
	</div>

</body>
</html>