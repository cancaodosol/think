package Servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import humor_developer.CategoryQueryDAO;
import humor_developer.Subject;
import humor_developer.SubjectQueryDAO;
import humor_developer.SubjectUpdateDAO;
import humor_developer.category;

/**
 * Servlet implementation class SubjectUpdateServlet
 */
@WebServlet("/SubjectUpdateServlet")
public class SubjectUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Subject subject = new SubjectQueryDAO().getSubject(Integer.parseInt(request.getParameter("subjectid")));
			request.setAttribute("subject", subject);
			List<category> ctgs = new CategoryQueryDAO().getCategorys();
			request.setAttribute("ctgs", ctgs);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		RequestDispatcher rdis = request.getRequestDispatcher("SubjectUpdateView.jsp");
		rdis.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String q1 = (String)request.getParameter("q1");

		Subject subject = new Subject();
		subject.setSubjectid(Integer.parseInt((String)request.getParameter("subjectid")));
		subject.setTitle((String)request.getParameter("title"));
		subject.setContent((String)request.getParameter("content"));
		subject.setLinkurl((String)request.getParameter("url"));
		subject.setCategory1(Integer.parseInt((String)request.getParameter("category1")));
		subject.setCategory2(Integer.parseInt((String)request.getParameter("category2")));
		subject.setCategory3(Integer.parseInt((String)request.getParameter("category3")));

		String modified = (String)request.getParameter("modified");

		if(q1.equals("commit")) {
			subject.setModified(new Date(System.currentTimeMillis()));
		}else {
			subject.setModified(Date.valueOf(modified));
		}

		try {
			new SubjectUpdateDAO().updateSubject(subject);
			request.getRequestDispatcher("SubjectDetailServlet?subjectid="+ subject.getSubjectid()).forward(request, response);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
