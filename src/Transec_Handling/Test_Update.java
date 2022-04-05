package Transec_Handling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test_Update {
	
	public static void main(String[] args) throws Exception {
		
		testUpdate();
	}
	public static void testUpdate() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		conn.setAutoCommit(false);
		
		int sal = 30000;
		int id =5;
		
		PreparedStatement ps = conn.prepareStatement("UPDATE EMPLOYEE SET SALARY=? WHERE ID=?");
	
		ps.setInt(1,sal );
		ps.setInt(2, id);
		
		int i = ps.executeUpdate();
		conn.commit();
		System.out.println("Updated");
		
		conn.close();
		ps.close();
		
	}

}
