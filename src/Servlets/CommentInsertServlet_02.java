package Servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import humor_developer.Comment;
import humor_developer.CommentUpdateDAO;

/**
 * Servlet implementation class CommentInsertServlet_02
 */
@WebServlet("/CommentInsertServlet_02")
public class CommentInsertServlet_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentInsertServlet_02() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		Comment comment = new Comment();
		comment.setSubjectid(Integer.parseInt((String)request.getParameter("subjectid")));
		comment.setTitle(request.getParameter("title"));
		comment.setContent(request.getParameter("content"));
		comment.setModified(new Date(System.currentTimeMillis()));

		try {
			CommentUpdateDAO dao = new CommentUpdateDAO();
			dao.insertComment(comment);

			response.sendRedirect("SubjectDetailServlet?subjectid="+ String.valueOf(comment.getSubjectid()));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
