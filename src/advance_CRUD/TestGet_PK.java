package advance_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestGet_PK {
	
	public static void main(String[] args) throws Exception {
		
		testGet();
	}
    public static void testGet() throws Exception {
    	
    	Class.forName("com.mysql.jdbc.Driver");
    	
    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
   
        Statement stmt = conn.createStatement();
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE ID=5");
        
        while(rs.next()) {
        	
        	System.out.print("\t"+rs.getString(1));
        	System.out.print("\t"+rs.getString(2));
        	System.out.print("\t"+rs.getString(3));
        	System.out.print("\t"+rs.getString(4));
        	System.out.println("\t"+rs.getString(5));
        }
        conn.close();
        stmt.close();
    }
}
