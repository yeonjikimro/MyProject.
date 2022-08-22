<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" /> 
<%@ include file="../include/header.jsp" %> 
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		table-layout: fixed;
		margin: 50px auto;
		width: 50%;
		
	}
	img {
		width: 60px;
	}
	table tr td {
	list-style-position: inside;
	width: 20px;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
	-webkit-line-clamp: 2;
    -webkit-display: box; 
    -webkit-box-orient: vertical;
	}
	
</style>
</head>
<body>
	<table class="w3-table w3-bordered">

	<thead>
		<tr>
			<th>번호</th>
			<th>공연 종류</th>
			<th>공연 이름</th>
			<th>곡 명</th>
			<th>공연 장소</th>
			<th>곡 일시</th>
			<th>티켓 가격</th>
			<th>이미지</th>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${SEARCH}" var="search" varStatus="INDEX">
		<tr data-seq="${search.PERF_NO}">
			<td>${INDEX.count}</td>
			<td>${search.GUBUN2}</td>
			<td>${search.TITLE_KOR}</td>
			<td>${search.SONG_TITLE_KOR}</td>
			<td>${search.PLACE_KOR}</td>
			<td>${search.PERFORM_DATE}</td>
			<td>${search.TICKET_KOR}</td>
			<td><img src="${search.IMGSRC}"></td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
	

	<th:block layout:fragment="paging">
                <nav aria-label="Page navigation" class="text-center">
                    <ul class="pagination">
                        <li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
                    </ul>
                </nav>
            </th:block>
</body>
</html>