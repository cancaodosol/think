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

				<%if(subject.getLinkurl()!=null){ %>
					[<a href = "<%=subject.getLinkurl() %>">Link</a>]
				<%}else{%>
					[None]
				<%} %>

				[<a href = "SubjectDetailServlet?subjectid=<%=subject.getSubjectid()%>">詳細</a>]
				[<a href = "SubjectUpdateServlet?subjectid=<%=subject.getSubjectid()%>">編集</a>]
				[<a href = "SubjectDeleteServlet?subjectid=<%=subject.getSubjectid()%>">削除</a>]
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
					<code>&lt;h2&gt;</code><code>&lt;/h2&gt;</code>
					<code>&lt;h3&gt;</code><code>&lt;/h3&gt;</code>
					<code>&lt;p&gt;</code><code>&lt;/p&gt;</code><br>
					<textarea name="content" rows="13" cols="85"></textarea><br>
				</div>

				<input type="hidden" name="subjectid" value="<%=subject.getSubjectid()%>">
				<input type="submit" value="コメント">
			</form>
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
					[<a href="CommentUpdateServlet?commentid=<%=comment.getCommentid()%>">編集</a>]
					[<a href="CommentDeleteServlet?subjectid=<%=comment.getSubjectid()%>&commentid=<%=comment.getCommentid()%>">削除</a>]
				</div><!-- end.modified -->

			<%} %>
		</div><!-- end.commentListBox -->
	</div>
<body>

</body>
</html>