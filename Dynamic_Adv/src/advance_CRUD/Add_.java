package advance_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Add_ {
	
	public static void main(String[] args) throws Exception {
		
		testAdd();
	}
	public static void testAdd() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(102,'DIYA','PATIDAR',5000,4)");
		
		System.out.println(i+"  Inserted");
		
		conn.close();
		stmt.close();
	}

}
