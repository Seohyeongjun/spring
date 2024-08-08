<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	<div id="coffeWrap">
	<a href="/coffe">HOME</a>
	<h2>커피 등록</h2>
	
	<form method="post" action="/coffeEnroll">
		<div id = "coffeFormWrap">
			<div class="coffeInputField">
				<label for="coffeTitle">커피이름</label>
				<input type="text" name="coffeTitle" id="coffeTitle">
			</div>

			<div class="coffeInputField">
				<label for="coffePrice">가격</label>
				<input type="text" name="coffePrice" id="coffePrice">
			</div>
			
			<div class="coffeInputField">
				<label for="coffeDecaffeine">디카페인</label>
				<input type="text" name="coffeDecaffeine" id="coffeDecaffeine">
			</div>
						
			<button>등록</button>	
		</div>
		
	</form>
	
	
	</div>
	
</body>
</html>