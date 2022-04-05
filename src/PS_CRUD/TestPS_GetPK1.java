package PS_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestPS_GetPK1 {
	
	public static void main(String[] args) throws Exception {
		
		testGet();
	}
	public static void testGet() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		int id=4;
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID=?");
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			System.out.print(rs.getInt(1));
			System.out.print("\t"+rs.getString(2));
			System.out.print("\t"+rs.getString(3));
			System.out.print("\t"+rs.getInt(4));
			System.out.println("\t"+rs.getInt(5));
		}
		
		conn.close();
		ps.close();
	}

}
