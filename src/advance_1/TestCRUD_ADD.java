package advance_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestCRUD_ADD {
	
	public static void main(String[] args) throws Exception {
		
		testAdd();
	}
	public static void testAdd() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
	
		Statement stmt = conn.createStatement();
		
		int rs = stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(9,'AMAN','SHARMA',25000,4)");
		
		System.out.println("Inserted");
		
		conn.close();
		stmt.close();
	}

}
