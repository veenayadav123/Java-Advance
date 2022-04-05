package Transec_Handling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test_Delete {

	public static void main(String[] args) throws Exception {

		testDelete();
	}

	public static void testDelete() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		conn.setAutoCommit(false);

		int id = 10;
		PreparedStatement ps = conn.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);

		int i = ps.executeUpdate();
		conn.commit();
		System.out.println(i + " Deleted ");

		conn.close();
		ps.close();
	}

}
