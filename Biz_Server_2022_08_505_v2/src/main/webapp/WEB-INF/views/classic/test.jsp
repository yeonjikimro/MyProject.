<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ include file="../home.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
	div.todo_body {
		width: 60%;
		margin:10px auto;
		padding:2rem;
	}
	
	div.todo_content {
		cursor:pointer; 
		
	}
	
	div.complete {
		text-decoration:line-through wavy;
		color:green;
	}

</style>
<script>
document.addEventListener("DOMContentLoaded",()=>{
    const div_body = document.querySelector("div.todo_body")
    div_body?.addEventListener("click",(e)=>{
        const target = e.target
        if(target.tagName == "DIV" 
        		&& target.classList?.contains("todo_content")) {
        	const seq = target?.dataset.seq
        	// if(seq == false)
        	if(!seq) {
        		alert("완료된 항목은 수정할수 없음")
        		return false
        	}
        	document.location.href = "${rootPath}/todo/update?t_seq=" + seq
        			
        } else if (target.tagName == "SPAN" 
        		&& target.classList?.contains("todo_content")) {
        	
        	const parentDiv = target.closest("DIV")
        	console.log(parentDiv)
        	const seq = parentDiv?.dataset.seq
        	document.location.href = "${rootPath}/todo/comp?t_seq=" + seq 
        }
    })
})

const rootPath = "${rootPath}"

</script>
<script src="${rootPath}/static/js/todo.js?20220816002"></script>
<body>
<div class="todo_body w3-card-4">
	<sec:authorize access="isAuthenticated()">
		<h1 class="w3-text-blue"> [<sec:authentication property="principal.username" /> ] 님의 TODO LIST</h1>
	</sec:authorize>
</div>
<form:form>

</form:form>
<div>
		<select class="deal" name="method">
					<option value="">오늘의 기분</option>
					<option value="슬픔">슬픔</option>
					<option value="비">비</option>
					<option value="힘">힘</option>
					<option value="공부">공부</option>
					<option value="아침">아침</option>
					<option value="힐링">힐링</option>
		</select>
		<script>
			docume
		
		</script>
		<table>
				<tr>
					<th>번호</th>
					<th>곡 이름</th>
					<th>작곡가</th>
					<th>주소</th>
				</tr>
				<c:forEach items="${CLASSIC}" var="classic" varStatus="INDEX">
					<tr>
						<td>${INDEX.count}</td>
						<td>${classic.song}</td>
						<td>${classic.musician}</td>
						<td>${classic.address}</td>
						<td style="display: none">${classic.mood}</td>
					</tr>
				</c:forEach>
			</table>
</div>




</body>
</html>

