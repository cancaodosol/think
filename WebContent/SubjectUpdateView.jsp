<%@page import="humor_developer.Subject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="style.css" type="text/css">
	<title>Subject Update</title>
</head>
<body>
	<%Subject subject = (Subject)request.getAttribute("subject"); %>
	<div id = header>
		<h1>WebApp Subject</h1>
		<h3><a href="SubjectListServlet">一覧へ</a></h3>
		<h3><a href = "SubjectDetailServlet?subjectid=<%=subject.getSubjectid()%>">詳細へ</a></h3>
	</div>

	<div id=main>
		<form action="SubjectUpdateServlet" method= "POST">
			<div class = title>
				タイトル<br>
				<textarea name="title" rows="1" cols="70"><%=subject.getTitle() %></textarea><br>
			</div>

			<div class = title>
				URL<br>
				<textarea name="url" rows="1" cols="70"><%=subject.getLinkurl() %></textarea><br>
			</div>

			<div class = content>
				内容<br>
				<textarea id="content" name="content" rows="20" cols="85"><%=subject.getContent() %></textarea><br>

			</div>

			<input type="hidden" name="subjectid" value="<%=subject.getSubjectid()%>">
			<input type="hidden" name="modified" value="<%=subject.getModified()%>">
			<input type="hidden" name="category1" value="<%=subject.getCategory1()%>">
			<input type="hidden" name="category2" value="<%=subject.getCategory2()%>">
			<input type="hidden" name="category3" value="<%=subject.getCategory3()%>">
			更新時刻を
			<input type="radio" name="q1" value="commit"> 更新する
			<input type="radio" name="q1" value="discommit" checked> 更新しない
			<input type="submit" value="更新">
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
			var add_h3 = document.getElementById("add_h3");
			var content = document.getElementById("content");

			add_p.addEventListener("click",function(){
				content.value += "<p></p>";
			});
			add_h2.addEventListener("click",function(){
				content.value += "<h2></h2>";
			});
			add_h3.addEventListener("click",function(){
				content.value += "<h3></h3>";
			});
	</script>
</body>
</html>