$(document).ready(function(){
	/*******************************************
		공지사항 - 파일 업로드
	 ********************************************/	
	$("#file1").change(function() {
		if(window.FileReader) {
			let fname = $(this)[0].files[0].name;
			$("#update_file1").text(fname)
		}
	});
	
	$("#file2").change(function() {
		if(window.FileReader) {
			let fname = $(this)[0].files[0].name;
			$("#update_file2").text(fname)
		}
	});
	
	
	
	let fileTarget = $('.filebox .upload-hidden');

  	fileTarget.on('change', function(){  // 값이 변경되면
  		let filename = '';
	    if(window.FileReader){  // modern browser
	      filename = $(this)[0].files[0].name;
	    } 
	    else {  // old IE
	      filename = $(this).val().split('/').pop().split('\\').pop();  // 파일명만 추출
	    }
	    
	    // 추출한 파일명 삽입
	    $(this).siblings('.upload-name').val(filename);
  	});
	
	
}); //ready