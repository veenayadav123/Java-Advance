package PS_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestPS_Update {
	
	public static void main(String[] args) throws Exception {
		
		testUpdate();
	}
	
	public static void testUpdate() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		int sal = 25000;
		String fn = "ram";
		int id =3;
		
		PreparedStatement ps = conn.prepareStatement("UPDATE EMPLOYEE SET SALARY=?,fname=? WHERE ID=?");
		
		ps.setInt(1, sal);
		ps.setString(2, fn);
		ps.setInt(3, id);
		
		int i = ps.executeUpdate();
		
		System.out.println(i+"  Updated");
		
		conn.close();
		ps.close();
	}

}
