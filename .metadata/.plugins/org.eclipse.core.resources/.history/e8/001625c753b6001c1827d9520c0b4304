package Transec_Handling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestPS_Add {
	
	public static void main(String[] args) throws Exception {
		
		testAdd();
	}
    public static void testAdd() throws Exception{
    	
    	Class.forName("com.mysql.jdbc.Driver");
    	
    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
    	
    	conn.setAutoCommit(false);
    	
    	PreparedStatement ps = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)");
    
        
    }
}
