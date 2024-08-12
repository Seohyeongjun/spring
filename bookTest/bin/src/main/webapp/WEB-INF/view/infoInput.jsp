<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${ageData }</h1>	<!-- ModelAndView사용, ageData - HomeController.java의 ModelAndView infoInput()메서드에서 만든 변수명 --> 
	<h2>${uName }</h2>
	<h2>${uBirth }</h2>
	<h2> 그냥 html, css, js로 구성되어 있는 페이지만 제공한다면</h2>
	<div> ModelAndView를 사용하지 않아도 된다. </div>
	<p>아무리 form에 입력하고 버튼 클릭해서 form데이터 받는 Mapping을 </p>
	<h3> 만들었어도 그다음 보여 줄 페이지에 데이터  제공하지 않을 꺼라면 그냥 페이지만 넘겨 주면 된다.</h3>
</body>
</html>