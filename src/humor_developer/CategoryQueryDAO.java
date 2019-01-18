package humor_developer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryQueryDAO {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost/humor";
	private static final String USER = "postgres";
	private static final String PASS = "pass@490";

	public List<category> getCategorys() throws SQLException, ClassNotFoundException {

		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PASS);

		String sql = null;

		try {
			sql = ReadFile.readSql("category1.sql");
		}catch(IOException e){
			e.printStackTrace();
		}

		PreparedStatement state = conn.prepareStatement(sql);
		ResultSet result = state.executeQuery();

		List<category> category1 = new ArrayList<category>();
		while(result.next()) {
			category category = new category();

			category.setCategory1(result.getInt("category1"));
			category.setCategory2(result.getInt("category2"));
			category.setCategory3(result.getInt("category3"));
			category.setName(result.getString("name"));
			category1.add(category);
		}

		result.close();
		state.close();
		conn.close();

		return category1;
	}
}
