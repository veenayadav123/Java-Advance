package Transec_Handling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test_Add2 {

	public static void main(String[] args) throws Exception {

		testAdd();
	}

	public static void testAdd() throws Exception {

		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		conn.setAutoCommit(false);

		int id = 28;
		String fn = "Garima";
		String ln = "Gupta";
		int sal = 35000;
		int dID = 4;
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)");

			ps.setInt(1, id);
			ps.setString(2, fn);
			ps.setString(3, ln);
			ps.setInt(4, sal);
			ps.setInt(5, dID);

			int i = ps.executeUpdate();
			System.out.println("Inserted");

			conn.commit();
			ps.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
			conn.rollback();
		}

		conn.close();

	}

}
