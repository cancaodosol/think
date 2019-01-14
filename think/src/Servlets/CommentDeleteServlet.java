package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import humor_developer.CommentUpdateDAO;

/**
 * Servlet implementation class CommentDeleteServlet
 */
@WebServlet("/CommentDeleteServlet")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int subjectid = Integer.parseInt(request.getParameter("subjectid"));
		int commentid = Integer.parseInt(request.getParameter("commentid"));

		try {
			new CommentUpdateDAO().deleteComment(subjectid,commentid);
			response.sendRedirect("SubjectDetailServlet?subjectid="+subjectid);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
