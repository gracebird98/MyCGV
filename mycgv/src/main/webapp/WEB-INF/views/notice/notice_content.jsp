<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYCGV</title>
<link rel="stylesheet" href="http://localhost:9000/mycgv_jsp/resources/css/mycgv_jsp.css">
</head>
<body>
	<!-- header -->
	<!-- <iframe src="http://localhost:9000/mycgv_jsp_jsp/header.jsp"
			scrolling="no" width="100%" height="149px" frameborder=0></iframe> -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="content">
		<section class="notice">
			<h1 class="title">공지사항</h1>
			<table class="notice_content">
				<tr>
					<th>제목</th>
					<td>${noticeVo.ntitle }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						${noticeVo.ncontent }<br><br><br>
						<c:if test="${noticeVo.nsfile1 != null }">
							<img src="http://localhost:9000/mycgv_jsp/upload/${noticeVo.nsfile1 }" width="200px" height="200px">
						</c:if>
						<c:if test="${noticeVo.nsfile2 != null }">
							<img src="http://localhost:9000/mycgv_jsp/upload/${noticeVo.nsfile2 }"width="200px" height="200px">
						</c:if>
					</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${noticeVo.nhits }</td>
				</tr>
				<tr>
					<th>작성일자</th>
					<td>${noticeVo.ndate }</td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="notice_list.do">
							<button type="button" class="btn_style">리스트</button></a>
						<a href="index.do">
						<button type="button" class="btn_style">홈으로</button></a>
					</td>
				</tr>
			</table>
		</section>
	</div>
	
	<!-- footer -->
	<!-- <iframe src="http://localhost:9000/mycgv_jsp_jsp/footer.jsp"
			scrolling="no" width="100%" height="500px" frameborder=0></iframe> -->	
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
















