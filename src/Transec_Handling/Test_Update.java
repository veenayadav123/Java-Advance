package Transec_Handling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test_Update {

	public static void main(String[] args) throws Exception {

		testUpdate();
	}

	public static void testUpdate() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		conn.setAutoCommit(false);

		int sal = 30000;
		int id = 4;

		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE EMPLOYEE SET ID=? WHERE SALARY=?");

			ps.setInt(1, id);
			ps.setInt(2, sal);

			int i = ps.executeUpdate();
			conn.commit();
			System.out.println("Updated");
			ps.close();
		
		} catch (Exception e) {

			System.out.println(e.getMessage());
			// e.printStackTrace();
			conn.rollback();
		}

		conn.close();

	}
}
