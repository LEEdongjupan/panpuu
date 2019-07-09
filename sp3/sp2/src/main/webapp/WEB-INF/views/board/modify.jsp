<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="../includes/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-4 text-gray-800">board modify/delete Page</h1>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">modify/delete</h6>
		</div>
		<div class="card-body">
		<form id='form1'>
			<input type="hidden" name="bno" value="${cri.bno}">
			<input type="hidden" name="page" value="${cri.page}"> 
			<input type="hidden" name="amount" value="${cri.amount}">
			<input type="hidden" name="type" value="${cri.type}">
			<input type="hidden" name="keyword" value="${cri.keyword}">
			<div class="form-group row">
				<input type="text" name="bno" class="form-control form-control-user"
					placeholder="bno" value='<c:out value="${vo.bno}"/>'
					readonly="readonly">>
			</div>

			<div class="form-group row">
				<input type="text" name="title"
					class="form-control form-control-user" placeholder="title"
					value='<c:out value="${vo.title}"/>'>
			</div>
			<div class="form-group row">
				<input type="text" name="content"
					class="form-control form-control-user" placeholder="content"
					value='<c:out value="${vo.content}"/>' >
			</div>
			<div class="form-group row">

				<input type="text" name="writer"
					class="form-control form-control-user" placeholder="writer"
					value='<c:out value="${vo.writer}"/>' readonly="readonly">
			</div>
			</form>
			<button class="btn btn-danger">Delete</button>
			
			<button class="btn btn-warning">Modify</button>

			<hr>



			<button class="btn btn-secondary listBtn"> Go to list </button>
		</div>

	</div>

</div>

<script>
$(".listBtn").on("click",function(e){
	var formObj = $("#form1");
	formObj
	.attr("action","/board/list")
	.attr("method","get")
	.submit();
});

$('.btn-danger').on("click", function () {
	console.log("clikkkkkk");
	
	var formObj = $("#form1");
	formObj
	.attr("action","/board/remove")
	.attr("method","post")
	.submit();		
});

$('.btn-warning').on("click", function () {
	console.log("modi clikkkkkk");
	
	var formObj = $("#form1");
	formObj
	.attr("action","/board/modify")
	.attr("method","post")
	.submit();		
});
</script>

<%@include file="../includes/footer.jsp"%>



</body>
</html>