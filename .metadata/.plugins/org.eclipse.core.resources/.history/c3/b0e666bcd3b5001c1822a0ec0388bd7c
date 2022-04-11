package advance_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select_ {

	public static void main(String[] args) throws Exception {

		testSelect();
	}

	public static void testSelect() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT FNAME,LNAME,SALARY,DEPT_ID FROM EMPLOYEE");
		
		while(rs.next()) {
			
			System.out.print(rs.getString(1));
			System.out.print("\t"+rs.getString(2));
            System.out.print("\t"+rs.getString(3));
            System.out.println("\t"+rs.getString(4));
		}
		stmt.close();
		conn.close();
		rs.close();
	}
}
