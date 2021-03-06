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
<<<<<<< HEAD
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
=======
					readonly="readonly">
			</div>

			<div class="form-group row">
				<input type="text" name="title"
					class="form-control form-control-user" placeholder="title"
					value='<c:out value="${vo.title}"/>' readonly="readonly">
			</div>

			<div class="form-group row">
				<input type="text" name="content"
					class="form-control form-control-user" placeholder="content"
					value='<c:out value="${vo.content}"/>' readonly="readonly">
		</div>

			<div class="form-group row">
				<input type="text" name="writer"
					class="form-control form-control-user" placeholder="writer"
					value='<c:out value="${vo.writer}"/>' readonly="readonly">
			</div>

			<button class="btn btn-success modBtn">Modify/Delete</button>

		

			<button class="btn btn-secondary listBtn">Go list</button>


			<button class="btn btn-outline-success addReplyBtn">add reply</button>


		</div>
		<div class="card shadow mb-4">
			<div class="card-body">
				<ul class="replyList List-group">
					<li class="list-group-item">aaa</li>
				</ul>
			</div>
		</div>
	</div>
	<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
<form id="actionForm" action="/board/modify" method="get">
	<input type="hidden" name="bno" value="${cri.bno}">
	<input type="hidden" name="page" value="${cri.page}"> 
	<input type="hidden" name="amount" value="${cri.amount}">
	<input type="hidden" name="type" value="${cri.type}">
	<input type="hidden" name="keyword" value="${cri.keyword}">
</form>

<!-- Logout Modal-->
<div class="modal fade" id="replyModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">add reply</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" class="form-control mbno"  name="bno" value="${cri.bno}" readonly="readonly">
                <input type="text" class="form-control mrno"  name="rno"value="" readonly="readonly">
                <input type="text" class="form-control"name="reply" value="samplegl">
                <input type="text" class="form-control"name="replyer" value="sampleer">
            </div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <butten class="btn btn-primary replyBtn">add reply</butten>
                <butten class="btn btn-info modifyBtn hide">modify reply</butten>
                <butten class="btn btn-danger deleteBtn hide">delete reply</butten>
            </div>
        </div>
    </div>
</div>
<style>
.modal-footer .hide{
display:none;
}
</style>

<script type="text/javascript" src="/resources/js/reply.js"></script>

<script>
	console.log(replyService);

	var actionForm = $("#actionForm");
	var bno = ${vo.bno};
	var replyList= $(".replyList");

	showPage();
	
	replyList.on("click","li",function(){
		var rno = $(this).attr("data-rno")
		replyService.getReply(rno,function(reply){
			$(".mrno").val(reply.rno);
	          $("input[name='reply']").val(reply.reply);
	          $("input[name='replyer']").val(reply.replyer);
	          $("#replyModal").modal('show');
	          $(".modifyBtn").removeClass("hide");
	          $(".replyBtn").addClass("hide");
	          $(".deleteBtn").removeClass("hide");
	          
		})
	});
	
	$(".addReplyBtn").on("click",function(e){
		$("#replyModal").modal("show");
		$(".modifyBtn").addClass("hide");
        $(".replyBtn").removeClass("hide");
        $(".deleteBtn").addClass("hide");
	})
	
	$(".modBtn").on("click",function(e){
		actionForm.submit();
	});
	
	$(".listBtn").on("click",function(e){
		actionForm.find("input[name='bno']").remove();
		actionForm.attr("action","/board/list").submit();
	});
	
	
    $(".replyBtn").on("click",function (e) {
      let obj = {
          bno:$("input[name='bno']").val(),
          reply:$("input[name='reply']").val(),
          replyer:$("input[name='replyer']").val()
      };

      replyService.addReply(obj,function () {
          alert("댓글등록완료")
          $("#replyModal").modal("hide");
          showPage() 
    	  })
	  });
	
     $(".deleteBtn").on("click",function(e){
    	 
    	var rno = $("input[name='rno']").val();

    	replyService.removeReply(rno,function(){
    		alert("removede");
    		$("#replyModal").modal('hide');
    		showPage();
    	})
     });	
     
     $(".modifyBtn").on("click",function(e){
    	 
     	var vo = {rno:$("input[name='rno']").val(),
     			reply:$("input[name='reply']").val()}
     	replyService.updateReply(vo,function(){
     		alert("수정성공");
     		$("#replyModal").modal('hide');
    		showPage();
     		
     	})
      });	
    
 	 function showPage(){
        replyList.html("");
        replyService.getList(bno,function (arr) {
            console.log(arr);
            //구조분해할당 문법, 비 구조화 분해,템플릿 문법

            var str="";
            for(var i =0;i<arr.length; i++){
                var {rno ,bno,reply,replyer,replyDate} =arr[i];
                var temp=
                    "<li class='list-group-item' data-rno="+rno+">"+
                         "<div class='rno'>"+rno+"</div>"+
                         "<div class='reply'>"+reply+"</div>"+
                         "<div class='replyer'>"+replyer+"</div>"+
                    "</li>";
                str += temp;
            };
            replyList.append(str);
        });
   	 };
  
  
	var flag = '${result}';

	if (flag === 'success') {
		alert("작업이 성공했습니다.");
	}
</script>

<%@include file="../includes/footer.jsp"%>



</body>
</html>
>>>>>>> refs/remotes/origin/master
