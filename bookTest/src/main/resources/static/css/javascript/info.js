/**
 * 
 */
let inputType = [];
let inputName = [];

$(function(){	
	// 삭제버튼
	$("#del").on("click", function(){
		
//		var bookId = $(this).data("id");	// id : data-id의 id
		var isOk = confirm("정말로 삭제하시겠습니까?");
		
		if(isOk){
			
			$("#fm").submit();
//			location.href="/book/delete?id="+bookId;			
		}
	});

	// 수정버튼
	$("#modify").on("click", function(){
		
		// class는 배열의 구조이다.
		// $.each() : 반복문
		$.each( $(".value"), function(i, v){	// i : 인덱스, v : i 인덱스의 값(td태그의 값)
			var text = $(v).text().trim();	// .trim() : 빈공간(띄어씌기) 제거
			if(inputType[i]==="number"){
				text=text.replace(/[^0-9]/g,"");	// g:gloval(전영역), 0-9가 아니라면 제거
//				text=text.replace(",","");	// 천단위 콤마 표시 제거
				
//				if(isNaN(text) ) text = text.substring(1);	// 숫자변환 가능여부, 불가능 : true
			}
 			$(v).html("<input type='"+inputType[i]+"' name='"+inputName[i]+"' value='"+text+"'>");
			
			
		}); // each반복문 끝. 클래스명이 value인 td내부 설정
		
		$(this).attr("id", "mod");	// id를 mod로 변경
		
		var url=$("#fm").attr("action");	// form action값 가져오기
		url = url.replace("delete", "update");	// 주소 변경
		// 주소 : /book/update 또는 /coffe/update로 변경 된다.
		$("#fm").attr("action", url);
		
		$(this).off("click");
		
		$("#mod").on("click", function(){ $("#fm").submit(); });
		
	});
	
	
	
});