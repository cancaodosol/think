package Servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import humor_developer.Subject;
import humor_developer.SubjectUpdateDAO;

/**
 * Servlet implementation class SubjectInsertServlet
 */
@WebServlet("/SubjectInsertServlet")
public class SubjectInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		Subject subject = new Subject();
		subject.setTitle(request.getParameter("title"));
		subject.setContent(request.getParameter("content"));
		subject.setLinkurl(request.getParameter("url"));
		subject.setModified(new Date(System.currentTimeMillis()));

		try {
			SubjectUpdateDAO dao = new SubjectUpdateDAO();
			dao.insertSubject(subject);

			response.sendRedirect("SubjectListServlet");
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
