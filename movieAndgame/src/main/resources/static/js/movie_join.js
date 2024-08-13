/**
 * 
 */

$(function(){
	$("#email").focus();
	$(".inputField input").on("focus", function(){ // input태그에 커서가 들어갈대 이벤트
		$(this).addClass("active");
		$(this).next().addClass("focus");	// 커서(마우스)가 들어가면 label for문이 위로 올라가서 글씨가 겹치지 않는다.
				
	});
	
	$(".inputField input").on("blur", function(){	// input태그에서 커서가 빠짐. 라벨의 글씨가 원위치로 간다.
		var text = $(this).val();	// input태그 value값 가져오기
		if(text==''){
			$(this).removeClass("active");
			$(this).next().removeClass("focus");
		}
	});	
	
});