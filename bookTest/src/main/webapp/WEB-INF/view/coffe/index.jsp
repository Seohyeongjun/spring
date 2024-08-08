<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커피 등록</title>
<link rel="stylesheet" href="/css/coffeWrite.css">

<title>Insert title here</title>
</head>
<body>
	<div id="coffeWrap">
	<a href="/coffeReg" id="enroll">메뉴등록</a>
		<h3 id="menu">등록 커피 목록</h3>

		<div id="coffeListWrap">
			<ul id="coffeList">
				<li class="clistMain">
					<span class="itemName">커피</span>
					<span class="price">가격</span>
					<span class="decaffein">디카페인</span>
				</li>
				<c:forEach var="row" items="${list }">
					<li class="clist">
						<span class="name">${row.coffeTitle }</span>
						<span class="price">${row.coffePrice }</span>
						<span class="decaffein">${row.coffeDecaffeine }</span>
					</li>			
				</c:forEach>

			</ul>
		</div>
		
	</div>
</body>
</html>