package Transec_Handling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test_Add1 {

	public static void main(String[] args) throws Exception {

		testAdd();
	}

	public static void testAdd() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		conn.setAutoCommit(false);

		Statement stmt = conn.createStatement();

		try {

			int i = stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(32,'RIYA','VERMA',20000,4)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(33,'RIYA','VERMA',20000,4)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(32,'RIYA','VERMA',20000,4)");
			conn.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
			conn.rollback();
		}

		stmt.close();
		conn.close();
	}

}
