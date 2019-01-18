<%@page import="humor_developer.Comment"%>
<%@page import="humor_developer.Subject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%Subject subject = (Subject)request.getAttribute("subject"); %>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="style.css" type="text/css">
	<title><%=subject.getTitle() %></title>
</head>
<body>
	<div id = header>
		<h1>WebApp Subject</h1>
		<h3><a href="SubjectListServlet">一覧へ</a></h3>
	</div>


	<div id = "container">
		<div id = "textDetailBox">

			<div class = "title">
				<%=subject.getTitle() %>
			</div>

			<div class = "modified">
				<%=subject.getModified() %>
			</div>

			<div class = "content">
				<%=subject.getContent() %>
			</div>

			<div class = "footer">
				<a href = "<%=subject.getLinkurl() %>" class="square_btn">Link</a>
				<a href = "SubjectDetailServlet?subjectid=<%=subject.getSubjectid()%>" class="square_btn">詳細</a>
				<a href = "SubjectUpdateServlet?subjectid=<%=subject.getSubjectid()%>" class="square_btn">編集</a>
				<a href = "SubjectDeleteServlet?subjectid=<%=subject.getSubjectid()%>" class="square_btn" onclick="check(this)">削除</a>
			</div><!-- end.footer -->

		</div><!-- end.textDetailBox -->


		<div id = "insertCommentBox">
			<form action="CommentInsertServlet_02" method= "POST">
				<div class = title>
					コメントタイトル<br>
					<textarea name="title" rows="1" cols="70"></textarea><br>
				</div>
				<div class = content>
					コメント内容
					<textarea id="content" name="content" rows="13" cols="85"></textarea><br>
				</div>

				<input type="hidden" name="subjectid" value="<%=subject.getSubjectid()%>">
				<input type="submit" value="コメント" >
			</form>
			<button id = "add_h2">h2</button>
			<button id = "add_h3">h3</button>
			<button id = "add_p">p</button>
			</div><!-- end.insertBox -->

		<div id = "commentListBox">
			<%List<Comment> comments = (List<Comment>)request.getAttribute("comments"); %>
			<%for(int i=0; i<comments.size(); i++){ %>
				<%Comment comment = comments.get(i); %>

				<div class = "title">
						<%=comment.getTitle() %>
				</div><!-- end.title -->

				<div class = "content">
					<%=comment.getContent() %>
				</div><!-- end.content -->

				<div class = "modified">
					<%=comment.getModified() %>
					<a href="CommentUpdateServlet?commentid=<%=comment.getCommentid()%>" class="square_btn" >編集</a>
					<a href="CommentDeleteServlet?subjectid=<%=comment.getSubjectid()%>&commentid=<%=comment.getCommentid()%>" class="square_btn" onclick="check(this)">削除</a>
				</div><!-- end.modified -->

			<%} %>
		</div><!-- end.commentListBox -->
	</div>
	<script>
		var add_p = document.getElementById("add_p");
		var add_h2 = document.getElementById("add_h2");
		var add_h3 = document.getElementById("add_h3");
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

		function check(element){
			var result = window.confirm('このサブジェクトを本当に削除してもいいですか？');
			if(!result){
				element.href = "SubjectDetailServlet?subjectid=<%=subject.getSubjectid()%>";
			}
		}
	</script>
<body>

</body>
</html>