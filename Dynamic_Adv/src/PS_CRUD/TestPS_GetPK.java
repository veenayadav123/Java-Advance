package PS_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestPS_GetPK {

	public static void main(String[] args) throws Exception {

		testGet(5);
	}

	public static void testGet(int PK) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID = ?");

		ps.setInt(1, PK);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t"+rs.getString(2));
			System.out.print("\t"+rs.getString(3));
			System.out.print("\t"+rs.getInt(4));
			System.out.println("\t"+rs.getInt(5));
		}
		conn.close();
		ps.close();
	}
}
