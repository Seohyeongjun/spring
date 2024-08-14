/**
 * 
 */

$(function(){
	
	$("#joinBt").attr("disabled", true); //disabled 비활성화 상태, 버튼 클릭 안된다.
	
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

	$("#birthYear").empty();
		$("#birthMonth").empty();
		
		// 태어난 년도 select에 optioin태그 추가
		// 1924~2024년도 까지, 이중에서 2005년을 기본값으로 설정
		for(var i=2024; i>=1924; i--){
			
			var selected = (i==2005)?"selected":"";
			$("#birthYear").append(`<option value="${i}" ${selected}>${i}</option>`)
		}
		
		// 태어난 날 select에 option태그 추가
		// 1~12월 추가하고, 지금 현재 오늘 이 순간의 월을 기본값으로 설정
		var today = new Date();
		var month = today.getMonth()+1;	//현재 일의 월
		
		for(var i=1; i<=12; i++){
			
			var selected = (i==month)?"selected":"";
			$("#birthMonth").append(`<option value="${i}" ${selected}>${i}</option>`)
		}
		
		// 비밀번호와 비밀번호 확인 두 곳의 값이 일치하는가
		$("#password").on("keyup", function(){
			if($(this).val()!=$("#chk").val()){
				$("#pw1").text("비밀번호가 일치 하지 않습니다.");
				$("#pw1").css("color", "red");
				$("#pw2").empty();	
			}
			else{
				$("#pw1").text("비밀번호가 일치 합니다.");
				$("#pw1").css("color", "green");
				$("#pw2").empty();
				$("#joinBt").attr("disabled", false);	// 버튼 활성화			
			}		
		});

		// 비밀번호와 비밀번호 확인 두 곳의 값이 일치하는가
		$("#chk").on("keyup", function(){
			if($(this).val()!=$("#password").val()){
				$("#pw2").text("비밀번호가 일치 하지 않습니다.");
				$("#pw2").css("color", "red");
				$("#pw1").empty();	
			}
			else{
				$("#pw2").text("비밀번호가 일치 합니다.");
				$("#pw2").css("color", "green");
				$("#pw1").empty();
				$("#joinBt").attr("disabled", false);	// 버튼 활성화			
			}		
		});		
	
});