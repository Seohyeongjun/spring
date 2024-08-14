/**
 * 
 */
$(function(){	
	$("#del").on("click", function(){
		var coffeId = $(this).data("id");	// id : data-id의 id
		var isOk = confirm("정말로 삭제하시겠습니까?");
		
		if(isOk){
			location.href="/coffe/delete?id="+coffeId;			
		}
	});
});