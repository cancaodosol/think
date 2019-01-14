package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import humor_developer.CommentUpdateDAO;
import humor_developer.SubjectUpdateDAO;

/**
 * Servlet implementation class SubjectDeleteServlet
 */
@WebServlet("/SubjectDeleteServlet")
public class SubjectDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int subjectid = Integer.parseInt(request.getParameter("subjectid"));

		try {
			new CommentUpdateDAO().deleteComment(subjectid);
			new SubjectUpdateDAO().deleteSubject(subjectid);
			response.sendRedirect("SubjectListServlet");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
