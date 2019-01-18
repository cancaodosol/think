<%@page import="humor_developer.Subject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="style.css" type="text/css">
	<title>Subject List View</title>
</head>
<body>
	<div id = header>
		<h1>WebApp Subject</h1>
		<h3><a href="insertSubject.html">追加</a></h3>

	</div>

	<div id = main>
		<%List<Subject> subjects = (List<Subject>)request.getAttribute("subjects"); %>
		<%for(int i=0; i<subjects.size();i++){ %>
			<div class = textListBox>
				<%Subject subject = (Subject)subjects.get(i); %>

				<div class = "title">
					<%=subject.getTitle() %><br>
				</div><!--end.title-->

				<div class = "modified">
					<%if(!(subject.getCategory1name().equals(null))){%><div class = ctg><%=subject.getCategory1name() %></div><%} %>
					<%if(!(subject.getCategory2name().equals(null))){%><div class = ctg><%=subject.getCategory2name() %></div><%} %>
					<%if(!(subject.getCategory3name().equals(null))){%><div class = ctg><%=subject.getCategory3name() %></div><%} %>
					<%=subject.getModified() %><br>
				</div><!--end.modified-->

				<div class = "contents">
					<%=subject.getContent() %><br>
				</div><!--end.content-->

				<div class = "footer">



				<a href = "<%=subject.getLinkurl() %>" class="square_btn">Link</a>
				<a href="SubjectDetailServlet?subjectid=<%=subject.getSubjectid()%>" class="square_btn">詳細</a>
				<a href = "SubjectUpdateServlet?subjectid=<%=subject.getSubjectid()%>" class="square_btn">編集</a>
				<a href = "SubjectDeleteServlet?subjectid=<%=subject.getSubjectid()%>" class="square_btn" onclick="check(this)">削除</a>
				</div><!-- end.footer -->
			</div><!--end.textListBox-->
		<%} %>
	</div>
	<script>
		function check(element){
			var result = window.confirm('このサブジェクトを本当に削除してもいいですか？');
			if(!result){
				element.href = "SubjectListServlet";
			}
		}
	</script>
</body>
</html>