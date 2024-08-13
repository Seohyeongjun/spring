<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  fmt: formatting tags 국제화 된 웹 사이트에서 텍스트, 시간, 날짜 및 숫자를 표시하고 형식화하는데 사용  -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	<!--  fmt : 숫자의 세자리마다 콤마(,)를 표시하기 위함-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서정보 보기</title>
<!-- jquery CDN -->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/css/info.css">
<script src="/css/javascript/info.js"></script>

<script>
	inputType=["text", "text", "text", "number", "number"];
	inputName=["bookTitle", "bookAuthor", "publisher", "bookPage", "bookCost"];
</script>

</head>
<body>

	<form id="fm" method="get" action="/book/delete">
		<input type="hidden" name="id" value="${book.bookId }">
		
		<div id="wrap">
			<a href="/">HOME</a>
			<table id="viewBox">
			
				<tr>
					<td class="fieldName">책 제목</td>
					<td class="value">${book.getBookTitle() }</td>
				</tr>
	
				<tr>
					<td class="fieldName">저자</td>
					<td class="value">${book.bookAuthor }</td>
				</tr>
				
				<tr>
					<td class="fieldName">출판사</td>
					<td class="value">${book.publisher }</td>
				</tr>
				
				<tr>
					<td class="fieldName">페이지수</td>
					<td class="value">
						<fmt:formatNumber value="${book.bookPage}" pattern="#,###"/>
					</td>
				</tr>
				
				<tr>
					<td class="fieldName">가격</td>
					<td class="value">					
						<fmt:formatNumber value="${book.bookCost }" type="currency"/>	<!-- currency : 통화표시 --> 
					</td>
				</tr>
				
				<tr>
					<td colspan="2">	<!-- 수정, 삭제 버튼 클릭 시 info.js function 실행 -->
						<button type="button" id="modify">수정</button>
						<button type="button" id="del" data-id="${book.bookId }">삭제</button> <!-- data-변수명 -->
					</td>
				</tr>						
			</table>
		</div>
	</form>
</body>
</html>




