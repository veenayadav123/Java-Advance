package advance_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DynamicByVar {

	public static void main(String[] args) throws Exception {

		testAdd();
	}

	public static void testAdd() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		Statement stmt = conn.createStatement();

		int id = 12;
		String fn = "Trapti";
		String ln = "Bhagat";
		int sal = 25000;
		int dID = 5;

		int i = stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(" + id + ",'" + fn + "','" + ln + "',"+sal+"," + dID + ")");
				
        System.out.println(i + " Inserted");
        conn.close();
        stmt.close();
	}

}
