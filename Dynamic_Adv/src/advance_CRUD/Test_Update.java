package advance_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test_Update {
	
	public static void main(String[] args) throws Exception {
		
		testUpdate();
	}
	public static void testUpdate() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
	
	    Statement stmt = conn.createStatement();
	
	    int i = stmt.executeUpdate("UPDATE EMPLOYEE SET SALARY=2000 WHERE ID = 7");
	    
	    System.out.println(i+" Updated");
	    
	    conn.close();
	    stmt.close();
	}

}
