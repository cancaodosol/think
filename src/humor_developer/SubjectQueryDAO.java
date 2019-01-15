package humor_developer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectQueryDAO {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost/humor";
	private static final String USER = "postgres";
	private static final String PASS = "pass@490";

	public List<Subject> getAllSubjects() throws SQLException, ClassNotFoundException {

		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PASS);

		String sql = "SELECT * FROM subjects ORDER BY modified DESC,subjectid";

		PreparedStatement state = conn.prepareStatement(sql);
		ResultSet result = state.executeQuery();

		List<Subject> subjects = new ArrayList<Subject>();
		while(result.next()) {
			int subjectid = result.getInt("subjectid");
			String title = result.getString("title");
			String content = result.getString("content");
			String linkurl = result.getString("linkurl");
			int category1 = result.getInt("category1");
			int category2 = result.getInt("category2");
			int category3 = result.getInt("category3");
			Date modified = result.getDate("modified");

			Subject subject = new Subject();

			subject.setSubjectid(subjectid);
			subject.setTitle(title);
			subject.setContent(content);
			subject.setLinkurl(linkurl);
			subject.setCategory1(category1);
			subject.setCategory2(category2);
			subject.setCategory3(category3);
			subject.setModified(modified);

			subjects.add(subject);
		}

		result.close();
		state.close();
		conn.close();

		return subjects;
	}


	public Subject getSubject(int subjectid) throws SQLException, ClassNotFoundException {

		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PASS);

		String sql = "SELECT * FROM subjects WHERE subjectid = ?";

		PreparedStatement state = conn.prepareStatement(sql);
		state.setInt(1, subjectid);
		ResultSet result = state.executeQuery();

		result.next();

		String title = result.getString("title");
		String content = result.getString("content");
		String linkurl = result.getString("linkurl");
		int category1 = result.getInt("category1");
		int category2 = result.getInt("category2");
		int category3 = result.getInt("category3");
		Date modified = result.getDate("modified");

		Subject subject = new Subject();

		subject.setSubjectid(subjectid);
		subject.setTitle(title);
		subject.setContent(content);
		subject.setLinkurl(linkurl);
		subject.setCategory1(category1);
		subject.setCategory2(category2);
		subject.setCategory3(category3);
		subject.setModified(modified);

		result.close();
		state.close();
		conn.close();

		return subject;
	}


}
