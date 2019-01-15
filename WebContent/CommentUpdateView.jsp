<%@page import="humor_developer.Comment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="style.css" type="text/css">
	<title>Comment Update</title>
</head>
<body>
	<%Comment comment = (Comment)request.getAttribute("comment"); %>
	<div id = header>
		<h1>WebApp Subject</h1>
		<h3><a href="SubjectListServlet">一覧へ</a></h3>
		<h3><a href = "SubjectDetailServlet?subjectid=<%=comment.getSubjectid()%>">詳細へ</a></h3>
	</div>

	<div id=main>
		<form action="CommentUpdateServlet" method= "POST">
			<div class = title>
				タイトル<br>
				<textarea name="title" rows="1" cols="70"><%=comment.getTitle() %></textarea><br>
			</div>

			<div class = content>
				内容<br>
				<textarea name="content" rows="20" cols="85"><%=comment.getContent() %></textarea><br>

			</div>

			<input type="hidden" name="subjectid" value="<%=comment.getSubjectid()%>">
			<input type="hidden" name="commentid" value="<%=comment.getCommentid()%>">
			<input type="submit" value="変更">
		</form>
	</div>
	<div id=footer>
		<button id = "add_h2">h2</button>
		<button id = "add_h3">h3</button>
		<button id = "add_p">p</button>
	</div>
	<script>
			var add_p = document.getElementById("add_p");
			var add_h2 = document.getElementById("add_h2");
			var content = document.getElementById("content");

			add_p.addEventListener("click",function(){
				content.value += "\n<p></p>";
			});
			add_h2.addEventListener("click",function(){
				content.value += "\n<h2></h2>";
			});
			add_h3.addEventListener("click",function(){
				content.value += "\n<h3></h3>";
			});


		</script>
</body>
</html>