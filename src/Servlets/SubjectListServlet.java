package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import humor_developer.SubjectQueryDAO;

/**
 * Servlet implementation class SubjectListServlet
 */
@WebServlet("/SubjectListServlet")
public class SubjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			SubjectQueryDAO dao = new SubjectQueryDAO();
			List subjects = dao.getAllSubjects();

			RequestDispatcher rdis = request.getRequestDispatcher("SubjectListView.jsp");

			request.setAttribute("subjects", subjects);

			rdis.forward(request, response);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}


}
