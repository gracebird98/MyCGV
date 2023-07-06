<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYCGV</title>
<link rel="stylesheet" href="http://localhost:9000/mycgv_jsp/resources/css/mycgv_jsp.css">
<link rel="stylesheet" href="http://localhost:9000/mycgv_jsp/resources/css/am-pagination.css">
<script src="http://localhost:9000/mycgv_jsp/resources/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/mycgv_jsp/resources/js/mycgv_jsp_jquery.js"></script>
<script src="http://localhost:9000/mycgv_jsp/resources/js/mycgv_board_list.js"></script>
<script src="http://localhost:9000/mycgv_jsp/resources/js/am-pagination.js"></script>



</head>
<body>
	<!-- header -->
	<!-- <iframe src="http://localhost:9000/mycgv_jsp/header.jsp"
			scrolling="no" width="100%" height="149px" frameborder=0></iframe> -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="content">
		<section class="board">
			<h1 class="title">게시판</h1>

		</section>
	</div>
	
	<!-- footer -->
	<!-- <iframe src="http://localhost:9000/mycgv_jsp/footer.jsp"
			scrolling="no" width="100%" height="500px" frameborder=0></iframe> -->	
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>



















