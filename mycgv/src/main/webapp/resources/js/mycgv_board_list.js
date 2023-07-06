$(document).ready(function(){

	initAjax(1);

	function initAjax(page) {
		$.ajax({
			url: "board_list_json_data.do?page="+page ,
			success : function(result) {
				//alert(result);	//문자
				let jdata = JSON.parse(result);
				//alert(jdata.jlist{0}.rno);	//객체
				
				let output = "<table class='board_list'>";
				output += "<tr><td colspan='5'>";
				output +=			"<a href='board_write.do'>";
				output +=				"<button type='button' class='btn_style2'>글쓰기</button>";
				output +=			"</a></td></tr>";
				output +=	"<tr>";
				output +=		"<th>번호</th>";
				output +=		"<th>제목</th>";
				output +=		"<th>조회수</th>";
				output +=		"<th>작성자</th>";
				output +=		"<th>작성일자</th>";
				output +=	"</tr>";
	
				
				for(obj of jdata.jlist) {
					output += "<tr>"
					output += "<td>" + obj.rno + "</td>";
					output += "<td>" + obj.btitle + "</td>";
					output += "<td>" + obj.bhits + "</td>";
					output += "<td>" + obj.id + "</td>";
					output += "<td>" + obj.bdate + "</td>";
					output += "</tr>"
				}
				
				output += "<tr>";
				output += "<td colspan='5'><div id='ampaginationsm'></div></td>";
				output += "</tr>";
				output += "</table>";
				
				//output 출력
				
				$("table.board_list").remove();
				$("h1").after(output);
				
				
				//페이징 처리 함수 호출
				pager(jdata.totals, jdata.maxSize, jdata.pageSize, jdata.page);
				
				

	    		
	    		
				
			}//success
		
		}); //ajax
		
		//페이지 번호 클릭 이벤트 처리
		jQuery('#ampaginationsm').on('am.pagination.change',function(e){
	  		 jQuery('.showlabelsm').text('The selected page no: '+e.page);
      		 //$(location).attr('href', "http://localhost:9000/mycgv_jsp/board_list_json_data.do?page="+e.page);         
    		initAjax(e.page);
		});
		
	}// initAjax
	
	
	
	// 페이징 처리 함수
	function pager(totals, maxSize, pageSize, page) {
	 	//alert(totals+", "+maxSize+", "+pageSize+", "+page);
	 	
	 	$(document).ready(function(){
			var pager = jQuery('#ampaginationsm').pagination({
		
		    maxSize: maxSize,	    		// max page size
		    totals: totals,	// total pages	
		    page: page,		// initial page		
		    pageSize: pageSize,			// max number items per page
		
		    // custom labels		
		    lastText: '&raquo;&raquo;', 		
		    firstText: '&laquo;&laquo;',		
		    prevText: '&laquo;',		
		    nextText: '&raquo;',
				     
		    btnSize:'sm'	// 'sm'  or 'lg'		
			});
		
 		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

});  //ready