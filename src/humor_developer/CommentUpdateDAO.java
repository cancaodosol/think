package humor_developer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentUpdateDAO {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost/humor";
	private static final String USER = "postgres";
	private static final String PASS = "pass@490";

	public void insertComment(Comment comment) throws SQLException, ClassNotFoundException {

		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PASS);

		String sql = "INSERT INTO comments"
				+ "(commentid, subjectid, title, content, modified) "
				+ "VALUES(nextval('comment_id_seq'), ?, ?, ?, ?)";

		PreparedStatement state = conn.prepareStatement(sql);

		state.setInt(1, comment.getSubjectid());
		state.setString(2, comment.getTitle());
		state.setString(3, comment.getContent());
		state.setDate(4, comment.getModified());

		state.executeUpdate();

		state.close();
		conn.close();

	}

	public void updateComment(Comment comment) throws SQLException, ClassNotFoundException {

		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PASS);

		String sql = "UPDATE comments "
				+ "SET title = ?, content = ?, modified = ? "
				+ "WHERE subjectid = ? AND commentid = ?";

		PreparedStatement state = conn.prepareStatement(sql);


		state.setString(1, comment.getTitle());
		state.setString(2, comment.getContent());
		state.setDate(3, comment.getModified());
		state.setInt(4, comment.getSubjectid());
		state.setInt(5, comment.getCommentid());

		state.executeUpdate();

		state.close();
		conn.close();

	}

	public void deleteComment(int subjectid, int commentid) throws SQLException, ClassNotFoundException {

		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PASS);

		String sql = "DELETE FROM comments "
				+ "WHERE subjectid = ? AND commentid = ? ";

		PreparedStatement state = conn.prepareStatement(sql);

		state.setInt(1, subjectid);
		state.setInt(2, commentid);

		state.executeUpdate();

		state.close();
		conn.close();

	}

	public void deleteComment(int subjectid) throws SQLException, ClassNotFoundException {

		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PASS);

		String sql = "DELETE FROM comments "
				+ "WHERE subjectid = ?";

		PreparedStatement state = conn.prepareStatement(sql);

		state.setInt(1, subjectid);

		state.executeUpdate();

		state.close();
		conn.close();

	}

}
