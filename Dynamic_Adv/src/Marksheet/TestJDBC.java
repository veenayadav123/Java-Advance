package Marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJDBC {

	public static void main(String[] args) throws Exception {

		for (int i = 1; i <= 40; i++) {

			System.out.println("Loop =" + i);
			testJDBC();
		}

	}

	private static void testJDBC() throws Exception {
		Connection conn = null;
		conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("SELECT * FROM MARKSHEET limit 0, 5");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			System.out.print(rs.getInt(1));
			System.out.print(" " + rs.getString(2));
			System.out.print(" " + rs.getString(3));
			System.out.print(" " + rs.getString(4));
			System.out.print(" " + rs.getInt(5));
			System.out.print(" " + rs.getInt(6));
			System.out.println(" " + rs.getInt(7));

		}

		System.out.println("\t-------------------------------------------------");

	}
}
