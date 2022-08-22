<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ include file="../include/header.jsp" %>
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
	
	div select.deal {
		width: 50px auto;
		text-align: center;
	}
	div.select_div {
		margin: 40px auto;
	}
	
	table {
	}
	div.c_list {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		margin: 100px auto;
		
	}
	div h1.title {
	margin: 50px auto;
		
	}
	div.2_list {
		margin: 100px auto;
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
<div class="c_list">
	<div>
		<h1 class="title" >Classic Recommend</h1>
	</div>
<div class="2_list">
	<div class="select_div">
		<select style="width:200px" class="deal" name="method">
					<option value="">오늘의 기분</option>
					<option value="슬픔">슬픔</option>
					<option value="비">비</option>
					<option value="힘">힘</option>
					<option value="공부">공부</option>
					<option value="아침">아침</option>
					<option value="힐링">힐링</option>
		</select>
	</div>
		<table class="w3-table w3-striped">
		<colgroup>
			<col width="100px">
			<col width="200px">
			<col width="100px">
			<col width="300px">
		</colgroup>
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
						<td><a href="${classic.address}">${classic.address}</a></td>
						<td style="display: none">${classic.mood}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
</div>




</body>
</html>

