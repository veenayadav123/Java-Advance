package advance_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCRUD_DELETE {
	
	public static void main(String[] args) throws Exception {
		
		testDelete();
		
	}
    public static void testDelete() throws Exception {
    	
    	Class.forName("com.mysql.jdbc.Driver");
    	
    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
    	
    	Statement stmt = conn.createStatement();
    	
    	int i = stmt.executeUpdate("DELETE FROM EMPLOYEE WHERE ID = 9");
    	
    	System.out.println(i+"  Deleted");
    	
    	conn.close();
    	stmt.close();
    }
}
