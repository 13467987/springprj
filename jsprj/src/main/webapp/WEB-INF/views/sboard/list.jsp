<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html >
<html>
<head>

<title>JS Company Beta</title>
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
				<table class="table table-hover">
					<thead>
						<tr>
							<th>글번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>날짜</th>
							<th>조회수</th>
						</tr>
					<tbody>
						<c:forEach var="list" items="${list}">
							<tr>
								<td>${list.no}</td>
								<td><a href="/sboard/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&no=${list.no}">${list.title}</a></td>
								<td>${list.userID}</td>
								<td><fmt:formatDate value="${list.regDate}" pattern="yy-MM-dd" /></td>
								<td>${list.hit}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!--  새로운 페이징 -->
				<nav>
					<ul class="pasgination pager">
						<c:if test="${pageMaker.prev}">
							<li><a href="list${pageMaker.makeSearch(pageMaker.startPage - 1)}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
						</c:if>
						<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
							<li <c:out value="${pageMaker.cri.page == idx?'class=active':''}"/>><a href="list?page=${idx}">${idx}</a></li>
						</c:forEach>
						<c:if test="${pageMaker.next && pageMaker.endPage>0}">
							<li><a href="list${pageMaker.makeSearch(pageMaker.endPage+1)}">&raquo;</a></li>
						</c:if>
					</ul>
				</nav>

				
					<input type="hidden" name="searchFlag" value="true">
					<div class="form-group">
						<label class="sr-only" for="exampleInputEmail3">검색</label> <select name="searchType" class="form-control">
							<option value="n"
								<c:out value="${cri.searchType == null ?'selected:' : ''}" />>
								---</option>
							<option value="t"
								<c:out value="${cri.searchType eq 't' ?'selected:' : ''}" />>
								제목</option>
							<option value="c"
								<c:out value="${cri.searchType eq 'c'?'selected:' : ''}" />>
								내용</option>
							<option value="w"
								<c:out value="${cri.searchType eq 'w' ?'selected:' : ''}" />>
								작성자</option>
							<option value="tc"
								<c:out value="${cri.searchType eq 'tc' ?'selected:' : ''}" />>
								제목+내용</option>
						</select> <input type="text" class="form-control" placeholder="검색" name="keyword" id="keywordInput" value="${cri.keyword}">
					</div>
					<button id="searchBtn" class="btn btn-default" >검색</button>
					<button id="newBtn" class="btn btn-default" >글쓰기</button>
			
			</div>
		</div>
	</div>
</body>

<!-- 활성화 작업 -->
<script type="text/javascript">
	$(document).ready(function() {
		$("#menu li:nth-child(2)").addClass("active");

		$("#searchBtn").on("click",function(event){
			self.location = "list"+'${pageMaker.makeQuery(1)}'
			+"&searchType="
			+$("select option:selected").val()
			+"&keyword=" +$("#keywordInput").val();
	});
	});
	
	
</script>
<%-- 		
		$("#searchBtn").on("click",function(event){
			self.location = "list"+"${pageMaker.makeQuery(1)}"
			+"&searchType="
			+$("select option:selected").val()
			+"&keyword=" +$("#keywordInput").val();
		});
		$("#newBtn").on("click",function(evt){
			self.loction="retister";
		});  --%>
</html>