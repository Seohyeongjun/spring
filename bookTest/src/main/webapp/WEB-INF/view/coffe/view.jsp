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
	inputType=["text", "number", "number"];
	inputName=["coffeTitle", "coffePrice", "coffeDecaffeine"];		// database값이 아니라 Dto의 값
</script>

</head>
<body>

	<form id="fm" method="get" action="/coffe/delete">
		<input type="hidden" name="id" value="${coffe.coffeId }">
		<div id="wrap">
			<a href="/coffe">HOME</a>
			<table id="viewBox">
			
				<tr>
					<td class="fieldName">커피 이름</td>
					<td class="value">${coffe.getCoffeTitle() }</td>
				</tr>
	
				<tr>
					<td class="fieldName">가격</td>
					<td class="value">
						<fmt:formatNumber value="${coffe.coffePrice}" pattern="#,###"/>
					</td>
				</tr>
				
				<tr>
					<td class="fieldName">디카페인</td>
					<td class="value">${coffe.coffeDecaffeine }</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<button type="button" id="modify">수정</button>
						<button type="button" id="del" data-id="${coffe.coffeId}" }>삭제</button>
					</td>
				</tr>
							
			</table>
		</div>
	</form>
</body>
</html>




