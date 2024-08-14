<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리</title>
<link rel="stylesheet" href="/css/default.css">
</head>
<body>

	<div id="wrap">
		<h2>도서관리</h2>
		
		<div id="mainTitle">
			<h3>등록 도서 목록</h3>
			<a href="/bookWrite" id="enroll">도서등록</a>
		</div>
		<div id="bookListWrap">
			<ul id="bookList">
				<li class="blistMain">
					<span class="title">제 목</span>
					<span class="auth">저 자</span>
					<span class="bookCode">코 드</span>
					<span class="category">카테고리</span>
				</li>
				
				<c:forEach var="row" items="${list }">
					<li class="blist">
						<span class="title">
							<a href="/book/view?id=${row.bookId}">${row.bookTitle }</a>
						</span>
						<span class="auth">${row.bookAuthor }</span>
						<span class="bookCode">${row.bookId }</span>
						<span class="category">${row.publisher }</span>	
					</li>			
				</c:forEach>
				
				<li class="blist">
					<span class="title">자바의 기초</span>
					<span class="auth">김영철</span>
					<span class="bookCode">j159a1348</span>
					<span class="category">컴퓨터 프로그래맹</span>
				</li>

				<li class="blist">
					<span class="title">c언어 길라잡이</span>
					<span class="auth">최명수</span>
					<span class="bookCode">c186d1268</span>
					<span class="category">컴퓨터 프로그래밍</span>
				</li>
				
				<li class="blist">
					<span class="title">요리의 기본</span>
					<span class="auth">김요리</span>
					<span class="bookCode">f1568d785</span>
					<span class="category">요리</span>
				</li>
				
				<li class="blist">
					<span class="title">근력성장의 기초</span>
					<span class="auth">김종국</span>
					<span class="bookCode">h1889m156</span>
					<span class="category">운동</span>
				</li>
				
				<li class="blist">
					<span class="title">영어문법</span>
					<span class="auth">Adrian</span>
					<span class="bookCode">e168a1239</span>
					<span class="category">영어</span>
				</li>
			</ul>
		</div>
		
	</div>

</body>
</html>