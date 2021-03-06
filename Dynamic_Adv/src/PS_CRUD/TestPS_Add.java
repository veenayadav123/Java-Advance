package PS_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestPS_Add {
	
	public static void main(String[] args) throws Exception {
		
		testAdd();
	}
	public static void testAdd() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		int id = 13;
		String fn = "Dev";
		String ln = "Sharma";
		int sal = 20000;
		int DID = 3;
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)");
		
		ps.setInt(1, id);
		ps.setString(2, fn);
		ps.setString(3, ln);
		ps.setInt(4, sal);
		ps.setInt(5, DID);
		
		int i = ps.executeUpdate();
		
		System.out.println(i+" Inserted");
		
		conn.close();
		ps.close();
	}

}
