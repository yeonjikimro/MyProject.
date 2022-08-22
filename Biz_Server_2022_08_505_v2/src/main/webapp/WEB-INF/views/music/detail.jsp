<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
</head>
<body>
	<div>
			<ul>
				<li>${SEARCH.TITLE_KOR}</li>
				<li>${SEARCH.GUBUN2}</li>
			</ul>
			<div>공연 장소 : ${SEARCH.PLACE_KOR}</div>
			<div>공연 일시 : ${SEARCH.PERFORM_DATE}</div>
			<div>티켓 가격 : ${SEARCH.TICKET_KOR}</div>
			<div>곡 명 : ${SEACH.SONG_TITLE_KOR}</div>
			<div>프로그램 소개 : ${SEARCH.PROGRAM_KOR}</div>
			<div>
				<img src="${SEARCH.IMGSRC}">
			</div>
		
		
		
		
	</div>


</body>
</html>