package advance_CRUD;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test_Select {

	public static void main(String[] args) throws Exception {

		testSelect();
	}

	public static void testSelect() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM MARKSHEET");

		while (rs.next()) {
			System.out.print("\t" + rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.print("\t" + rs.getInt(6));
			System.out.println("\t" + rs.getInt(7));
		}
		stmt.close();
		conn.close();
	}

}
