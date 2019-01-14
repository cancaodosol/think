package humor_developer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubjectUpdateDAO {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost/humor";
	private static final String USER = "postgres";
	private static final String PASS = "pass@490";

	public void insertSubject(Subject subject) throws SQLException, ClassNotFoundException {

		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PASS);

		String sql = "INSERT INTO subjects "
				+ "(subjectid, title, content, linkurl, category1, category2, category3, modified) "
				+ "VALUES(nextval('subject_id_seq'), ?, ?, ?, ?, ?, ?, ? )";

		PreparedStatement state = conn.prepareStatement(sql);

		state.setString(1, subject.getTitle());
		state.setString(2, subject.getContent());
		state.setString(3, subject.getLinkurl());
		state.setInt(4, subject.getCategory1());
		state.setInt(5, subject.getCategory2());
		state.setInt(6, subject.getCategory3());
		state.setDate(7, subject.getModified());

		state.executeUpdate();

		state.close();
		conn.close();

	}

	public void updateSubject(Subject subject) throws SQLException, ClassNotFoundException {

		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PASS);

		String sql = "UPDATE subjects "
				+ "SET title = ?, content = ?, linkurl = ?, category1 = ?, category2 = ?, category3 = ?, modified = ? "
				+ "WHERE subjectid = ?";

		PreparedStatement state = conn.prepareStatement(sql);

		state.setString(1, subject.getTitle());
		state.setString(2, subject.getContent());
		state.setString(3, subject.getLinkurl());
		state.setInt(4, subject.getCategory1());
		state.setInt(5, subject.getCategory2());
		state.setInt(6, subject.getCategory3());
		state.setDate(7, subject.getModified());
		state.setInt(8, subject.getSubjectid());

		state.executeUpdate();

		state.close();
		conn.close();

	}

	public void deleteSubject(int subjectid) throws SQLException, ClassNotFoundException {

		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PASS);

		String sql = "DELETE FROM subjects "
					+"WHERE subjectid = ?";

		PreparedStatement state = conn.prepareStatement(sql);

		state.setInt(1, subjectid);

		state.executeUpdate();

		state.close();
		conn.close();

	}

}
