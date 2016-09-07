<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html >
<html>
<head>
<title>JS Company Beta</title>
<!-- <link href="resource/css/default.css" rel="stylesheet" type="text/css" /> -->
</head>
<body>
	<header>
		<div class="container">
			<jsp:include page="../include/header.jsp" flush="true"></jsp:include>
		</div>
	</header>
	<div class="container">
		<jsp:include page="../include/logo.jsp" flush="true"></jsp:include>
	</div>
	<div class="container">
		<div id="wrap">
			<jsp:include page="../include/menu.jsp" flush="true"></jsp:include>
			<div id="content">
				<form role="form" method="post">
					<input type="hidden" name="no" value="${boardVO.no}">
					<input type="hidden" name="page" value="${cri.page}">
					<input type="hidden" name="boardCnt" value="${cri.boardCnt}">
					<input type="hidden" name="searchType" value="${cri.searchType}">
					<input type="hidden" name="keyword" value="${cri.keyword}"> 
				</form>
				<table class="table">
					<thead>
						<tr>
							<th>제목:${boardVO.title}</th>
							<th>날짜:<fmt:formatDate value="${boardVO.regDate}" pattern="yy-MM-dd" /></th>
							<th>작성자:${boardVO.userID}</th>
						</tr>
					<tbody>
						<tr>
							<td>${boardVO.content}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div id="forms">
				<button type="button"  class="btn btn-default" id="modify">수정</button> 
				<button type="button" class="btn btn-default" id="delete" >삭제</button>
				 <a href="/board/list" class="btn btn-default">목록으로</a>
				<!-- 답변 폼 ---------------------------------------------------->
				<table id="reply" class="table">
					<c:forEach items="${reply}" var="reply">
						<thead>
							<tr>
								<th>${reply.userID}</th>
								<th><fmt:formatDate value="${reply.regDate}" pattern="MM-dd HH:mm" /></th>
							</tr>
						<tbody>
							<tr>
								<td id="replyList">${reply.content}</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
				<form action="reply.do?boardNum=${vo.no}" method="post">
					<textarea class="form-control" rows="3" name="content"></textarea>
					<input class="btn btn-default" type="submit" value="작성">
				</form>
			</div>
		</div>
	</div>
</body>
<script>
	$(document).ready(function() {
		$("#menu li:nth-child(2)").addClass("active");
		
		var formObj = $("form[role='form']");
		
		console.log(formObj);
		
		$("#modify").on("click",function(){
			formObj.attr("action","/sboard/modify");
			formObj.attr("method","get");
			formObj.submit();
		})
		$("#delete").on("click",function(){
			formObj.attr("action","/sboard/delete");
			formObj.submit();	})
			
	});
</script>
</html>