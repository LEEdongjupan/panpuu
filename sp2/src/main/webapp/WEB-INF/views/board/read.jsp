<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="../includes/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-4 text-gray-800">board read Page</h1>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">read</h6>
		</div>
		<div class="card-body">
			<div class="form-group row">
				<input type="text" name="bno" class="form-control form-control-user"
					placeholder="bno" value='<c:out value="${vo.bno}"/>'
					readonly="readonly">>
			</div>
			
				<div class="form-group row">
					<input type="text" name="title"
						class="form-control form-control-user" placeholder="title"
						value='<c:out value="${vo.title}"/>' readonly="readonly">>
				</div>
				<div class="form-group row">
					<input type="text" name="content"
						class="form-control form-control-user" placeholder="content"
						value='<c:out value="${vo.content}"/>' readonly="readonly">>
				</div>
				<div class="form-group row">

					<input type="text" name="writer"
						class="form-control form-control-user" placeholder="writer"
						value='<c:out value="${vo.writer}"/>' readonly="readonly">>
				</div>

				<button class="btn btn-success">
				<a href="/board/modify?bno="${vo.bno}">Modify/Delete</a></button>

				<hr>



				<a href="/board/list" class="btn btn-secondary"> Go to list </a>
			</div>

		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- End of Main Content -->

	<script>
		var flag = '${result}';

		if (flag === 'success') {
			alert("작업이 성공했습니다.");
		}
	</script>

	<%@include file="../includes/footer.jsp"%>



	</body>
	</html>