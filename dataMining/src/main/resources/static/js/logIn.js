/**
 * 
 */

$(function(){

	$(".joinBt").attr("disabled", true);
		
	//$("#email").focus();

	$("#birthYear").empty();
	$("#birthMonth").empty();
	
	for(var i=2024; i>=1920; i--){
		
		var selected = (i==2005)?"selected":"";
		$("#birthYear").append(`<option value="${i}" ${selected}>${i}</option>`)
	}
	
	var today = new Date();
	var month = today.getMonth()+1;
	
	for(var i=1; i<=12; i++){
		
		var selected = (i==month)?"selected":"";
		$("#birthMonth").append(`<option value="${i}" ${selected}>${i}</option>`)
	}
	
	// 비밀번호와 비밀번호확인의 값 확인
	$("#password").on("keyup", function(){
		if($(this).val()!=$("#chk").val()){
			$("#pw1").text("비밀번호가 일치하지 않습니다.");
			$("#pw1").css("color", "red");
			$("#pw2").empty();
		}
		else{
			$("#pw1").text("비밀번호가 일치 합니다.");
			$("#pw1").css("color", "green");
			$("#pw2").empty();
			$(".joinBt").attr("disabled", false);
		}		
	});
	
	// 비밀번호확인과 비밀번호 확인
	$("#chk").on("keyup", function(){
		if($(this).val()!=$("#password").val()){
			$("#pw2").text("비밀번호가 일치하지 않습니다.");
			$("#pw2").css("color", "red");
			$("#pw1").empty();
		}
		else{
			$("#pw2").text("비밀번호가 일치 합니다.");
			$("#pw2").css("color", "green");
			$("#pw1").empty();
			$(".joinBt").attr("disabled", false);
		}
	});
	
		 
});