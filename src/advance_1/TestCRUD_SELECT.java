package advance_1;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class TestCRUD_SELECT {

	public static void main(String[] args) throws Exception {

		testSelect();
	}

	public static void testSelect() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM MARKSHEET");

		while (rs.next()) {
			System.out.print("\t" + rs.getString(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.print("\t" + rs.getString(5));
			System.out.print("\t" + rs.getString(6));
			System.out.println("\t" + rs.getString(7));
		}
		stmt.close();
		conn.close();
	}

}
