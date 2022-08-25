<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %> 
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
<style>
	div.detail {
		display: flex;
		justify-content: center;
		align-items: center;
		margin: 50px auto;
		flex-direction: column;
	}
</style>
</head>
<body>
	<div class="detail">
			<ul>
				<li>${DETAIL.TITLE_KOR}</li>
				<li>${DETAIL.GUBUN2}</li>
			</ul>
			<div>공연 장소 : ${DETAIL.PLACE_KOR}</div>
			<div>공연 일시 : ${DETAIL.PERFORM_DATE}</div>
			<div>티켓 가격 : ${DETAIL.TICKET_KOR}</div>
			<div>곡 명 : ${DETAIL.SONG_TITLE_KOR}</div>
			<div>프로그램 소개 : ${DETAIL.PROGRAM_KOR}</div>
			<div>
				포스터 : <img src="${DETAIL.IMGSRC}">
			</div>
		
		
		
		
	</div>


</body>
</html>