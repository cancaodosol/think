<%@page import="humor_developer.Subject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="style.css" type="text/css">
	<title>Insert title here</title>
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
					<%=subject.getModified() %><hr>
				</div><!--end.modified-->

				<div class = "contents">
					<%=subject.getContent() %><br>
				</div><!--end.content-->

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
			</div><!--end.textListBox-->
		<%} %>
	</div>


</body>
</html>