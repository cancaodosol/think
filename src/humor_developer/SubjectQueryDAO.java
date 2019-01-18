package humor_developer;

import java.io.IOException;
import java.sql.Connection;
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
		String sql = null;

		try {
			sql = ReadFile.readSql("subjectlist.sql");
		}catch(IOException e){
			e.printStackTrace();
		}

		PreparedStatement state = conn.prepareStatement(sql);
		ResultSet result = state.executeQuery();

		List<Subject> subjects = new ArrayList<Subject>();
		while(result.next()) {
			Subject subject = new Subject();
			subject.setSubjectid(result.getInt("subjectid"));
			subject.setTitle(result.getString("title"));
			subject.setContent(result.getString("content"));
			subject.setLinkurl(result.getString("linkurl"));
			subject.setCategory1(result.getInt("category1"));
			subject.setCategory1name(result.getString("TC1"));
			subject.setCategory1(result.getInt("category2"));
			subject.setCategory2name(result.getString("TC2"));
			subject.setCategory1(result.getInt("category3"));
			subject.setCategory3name(result.getString("TC3"));
			subject.setModified(result.getDate("modified"));
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

		String sql = null;

		try {
			sql = ReadFile.readSql("one_subject.sql");
		}catch(IOException e){
			e.printStackTrace();
		}

		PreparedStatement state = conn.prepareStatement(sql);
		state.setInt(1, subjectid);
		ResultSet result = state.executeQuery();

		result.next();

		Subject subject = new Subject();
		subject.setSubjectid(result.getInt("subjectid"));
		subject.setTitle(result.getString("title"));
		subject.setContent(result.getString("content"));
		subject.setLinkurl(result.getString("linkurl"));
		subject.setCategory1(result.getInt("category1"));
		subject.setCategory1name(result.getString("TC1"));
		subject.setCategory1(result.getInt("category2"));
		subject.setCategory2name(result.getString("TC2"));
		subject.setCategory1(result.getInt("category3"));
		subject.setCategory3name(result.getString("TC3"));
		subject.setModified(result.getDate("modified"));

		result.close();
		state.close();
		conn.close();

		return subject;
	}


}
