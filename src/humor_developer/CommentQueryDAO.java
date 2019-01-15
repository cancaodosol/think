package humor_developer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentQueryDAO {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost/humor";
	private static final String USER = "postgres";
	private static final String PASS = "pass@490";

	public List<Comment> getAllComments(int subjectid) throws SQLException, ClassNotFoundException {

		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PASS);

		String sql = "SELECT * FROM comments WHERE subjectid = ? ORDER BY modified,commentid";

		PreparedStatement state = conn.prepareStatement(sql);
		state.setInt(1, subjectid);
		ResultSet result = state.executeQuery();

		List<Comment> comments = new ArrayList<Comment>();
		while(result.next()) {
			Comment comment = new Comment();

			comment.setCommentid(result.getInt("commentid"));
			comment.setSubjectid(result.getInt("subjectid"));
			comment.setTitle(result.getString("title"));
			comment.setContent(result.getString("content"));
			comment.setModified(result.getDate("modified"));

			comments.add(comment);
		}

		result.close();
		state.close();
		conn.close();

		return comments;
	}


	public Comment getComment(int commentid) throws SQLException, ClassNotFoundException {

		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PASS);

		String sql = "SELECT * FROM comments WHERE commentid = ?";

		PreparedStatement state = conn.prepareStatement(sql);
		state.setInt(1, commentid);
		ResultSet result = state.executeQuery();

		result.next();

		Comment comment = new Comment();

		comment.setCommentid(result.getInt("commentid"));
		comment.setSubjectid(result.getInt("subjectid"));
		comment.setTitle(result.getString("title"));
		comment.setContent(result.getString("content"));
		comment.setModified(result.getDate("modified"));

		result.close();
		state.close();
		conn.close();

		return comment;
	}


}
