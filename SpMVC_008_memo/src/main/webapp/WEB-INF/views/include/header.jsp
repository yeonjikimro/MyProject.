<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="${rootPath}/static/css/home.css?ver=2022-08-12-003" />
	<header>
		<div class="header_1">
			<h1 id="logo">
				<a href="${rootPath}/"><img src="${rootPath}/static/image/nuggi.png"/></a>
			</h1>
		</div>
		<div class="big_div">
			<nav>
				<ul>
					<li><a href="${rootPath}/">Home</a></li>
					<li><a href="${rootPath}/user/intro">portfolio</a></li>
					<li><a href="${rootPath}/memo/memo_home">memo</a></li>
					<li><a href="${rootPath}/schedule/todo">일정 관리 </a></li>
					<li><a href="${rootPath}/qna/faq">문의사항</a></li>
					<%
					// 로그인을 하지 않았을때
					%>
					<c:if test="${empty USERNAME}">
						<li><a href="${rootPath}/user/login">로그인</a></li>
					</c:if>
		
	
					<c:if test="${not empty USERNAME}">
						<li><a href="${rootPath}/user/mypage">My
								Page(${USERNAME})</a></li>
						<li><a href="${rootPath}/user/logout">Logout</a></li>
					</c:if>
				</ul>
			</nav>
			<div class="line"></div>
		</div>
	</header>