<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/board/register" method="post">
		<div>
			<label>title</label> <input type="text" name="title" value="한글제목">
		</div>
		<div>
			<label>content</label> <input type="text" name="content" value="한글내용">
		</div>
		<div>
			<label>writer</label> <input type="text" name="writer" value="user00">
		</div>
		<div>
			<input type="reset">
			 <input type="submit">
			 <a herf="/board/list">목록가기</a>
		</div>
	</form>


</body>
</html>