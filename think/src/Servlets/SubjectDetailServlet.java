package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import humor_developer.Comment;
import humor_developer.CommentQueryDAO;
import humor_developer.Subject;
import humor_developer.SubjectQueryDAO;

/**
 * Servlet implementation class SubjectDetailServlet
 */
@WebServlet("/SubjectDetailServlet")
public class SubjectDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int subjectid = Integer.parseInt((String)request.getParameter("subjectid"));

		try {
			Subject subject = new SubjectQueryDAO().getSubject(subjectid);

			try {
				List<Comment> comments = new CommentQueryDAO().getAllComments(subjectid);
				request.setAttribute("comments", comments);

			}catch(Exception e) {
				e.printStackTrace();
			}

			RequestDispatcher rdis = request.getRequestDispatcher("SubjectDetailView.jsp");

			request.setAttribute("subject", subject);

			rdis.forward(request, response);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
