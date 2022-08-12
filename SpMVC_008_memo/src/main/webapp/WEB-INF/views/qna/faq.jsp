<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link href="https://fonts.googleapis.com/css2?family=Gugi&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Gothic+A1:wght@100&family=Nanum+Gothic&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/bd2bbc2e2d.js"></script>

<script>
	const rootPath = '${rootPath}'
</script>
<meta charset="UTF-8">
</head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<%@ include file="../include/header.jsp"%>
<title>Insert title here</title>

<style>
	table {
		border-collapse: collapse;
		margin:10px auto;
		width: 70%;
	}

    ul {
      list-style: none;
      margin: 0 20px;
      padding: 0;
      display: inline-block;
    }

    #tab ul {
      width: 90%;
      height: 10px;
      line-height: 50px;
      border-bottom: 1px solid #eee;
      height: 50px;
      box-sizing: border-box;
    }

    #tab ul li {
      float: left;
      border: 1px solid rgb(0 208 255);
      text-align: center;
      border-bottom: none;
      font-weight: bold;
      height: 50px;
    }

    #tab ul li:not(:first-child) {
      border-left: none;
    }

    #tab ul li.on {
      border: 1px solid rgb(0 208 255);
      border-bottom: 1px solid grey;
      font-weight: bold;
    }


    #tb-list li:first-child {
      float: left;
    }

    #tb-list li:last-child {
      float: right;
    }

    #tb-list li a:not(:first-child) {
      border-left: 1px solid;
      padding: 0 10px;
    }

    #tb-list table {
      border-collapse: collapse;
    }

    #tb-list thead tr {
      border-top: 2px solid grey;
    }

    #tb-list td,
    #tb-list th {
      padding: 15px 0;
    }

    #tb-list tbody td:not(:nth-child(2)) {
      text-align: center;
    }

    #tb-list tbody td:nth-child(2) {
      font-weight: bold;
    }

    #tb-list tbody tr {
      border-top: 1px solid grey;
    }

    #tb-list tbody tr:last-child {
      border-bottom: 1px solid #aaa;
    }

    #tb-list tbody td:nth-child(2):hover {
      text-decoration: underline;
      cursor: pointer;
    }
    div.h1 {
    display:flex;
    align-items: center;
    justify-content: center;
    margin: 50px auto;
    
    }
    div.write {
    	display: flex;
    	align-items: center;
    	justify-content: center;
    	margin-top: 40px;
    }
    table tr td a.cont {
	    text-align: center;
	    }

</style>


 <script type="text/javascript">
    var Tawk_API = Tawk_API || {},
      Tawk_LoadStart = new Date();
    (function () {
      var s1 = document.createElement("script"),
        s0 = document.getElementsByTagName("script")[0];
      s1.async = true;
      s1.src = "https://embed.tawk.to/6280da497b967b11798f6da8/1g33l9cfl";
      s1.charset = "UTF-8";
      s1.setAttribute("crossorigin", "*");
      s0.parentNode.insertBefore(s1, s0);
    })();
  </script>
  <!--End of Tawk.to Script-->

<body>

    <article id="tab">
    <div class="h1">
    <h1>문의사항</h1>
    </div>
    </article>
    <article id="tb-list">
      <table>
        <colgroup style="width: 100%">
          <col width="80px" />
          <col />
          <col width="100px" />
          <col width="80px" />
          <col width="80px" />
          <col width="120px" />
        </colgroup>
        <thead>
          <tr>
            <th>No.</th>
            <th>제목</th>
            <th>등록자</th>
            <th>날짜</th>
            <th></th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>
            <a href="${rootPath}/faqno/notice" class="cont">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            깔끔하네요
             </a>
            </td>
            <td>관리자</td>
            <td>2021.6.17</td>
          </tr>
        </tbody>
      </table>
      <div class="write">
	   	<button>글 작성</button>
	   </div>
    </article>
       

</body>

</html>