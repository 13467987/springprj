<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<table class="table">
		<thead>
		<tr>
		<th>제목:${boardVO.title}</th><th>날짜:<fmt:formatDate value="${boardVO.regDate}" pattern="yy-MM-dd"/></th>
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
			<a href="board.do?action=modifyForm&a=${boardVO.no}"  class="btn btn-default">수정</a>
			<a href="board.do?action=delete&a=${boardVO.no}"  class="btn btn-default">삭제</a>
			<a href="board.do" class="btn btn-default">목록으로</a>
			<!-- 답변 폼 ---------------------------------------------------->
 		<table id="reply" class="table">
			<c:forEach items="${reply}" var="reply">
			<thead>
			<tr>
				<th>${reply.userID}</th>
					<th><fmt:formatDate value="${reply.regDate}" pattern="MM-dd HH:mm"/></th>
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
	   <script type="text/javascript">  
    $(document).ready(function(){
    	$("#menu li:nth-child(2)").addClass("active");
    });
    </script>
</html>