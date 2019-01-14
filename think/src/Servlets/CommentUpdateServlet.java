package Servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import humor_developer.Comment;
import humor_developer.CommentQueryDAO;
import humor_developer.CommentUpdateDAO;

/**
 * Servlet implementation class CommentUpdateServlet
 */
@WebServlet("/CommentUpdateServlet")
public class CommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Comment comment  = new CommentQueryDAO().getComment(Integer.parseInt(request.getParameter("commentid")));
			request.setAttribute("comment", comment);

		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		RequestDispatcher rdis = request.getRequestDispatcher("CommentUpdateView.jsp");
		rdis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Comment comment = new Comment();
		comment.setSubjectid(Integer.parseInt((String)request.getParameter("subjectid")));
		comment.setCommentid(Integer.parseInt((String)request.getParameter("commentid")));
		comment.setTitle((String)request.getParameter("title"));
		comment.setContent((String)request.getParameter("content"));
		comment.setModified(new Date(System.currentTimeMillis()));

		try {
			new CommentUpdateDAO().updateComment(comment);
			request.getRequestDispatcher("SubjectDetailServlet?subjectid="+ comment.getSubjectid()).forward(request, response);

		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
