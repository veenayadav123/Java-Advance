package Transec_Handling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test_Add {
	
	public static void main(String[] args) throws Exception {
		
		testAdd();
	}
	public static void testAdd() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
	
	    conn.setAutoCommit(false);
	    
	    Statement stmt = conn.createStatement();
	    
	    int i= stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(35,'RIYA','VERMA',20000,4)");
	           stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(36,'RIYA','VERMA',20000,4)");
	           stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(35,'RIYA','VERMA',20000,4)");
	        
	        conn.commit();
	        System.out.println(i+"Inserted");
	        
	        conn.close();
	        stmt.close();
	}

}
