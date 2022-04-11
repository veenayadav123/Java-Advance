package Marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Batch_Processing {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		Statement stmt = conn.createStatement();

		stmt.addBatch("INSERT INTO MARKSHEET (ID,FNAME,Maths) values(34,'Ram',56)");
		stmt.addBatch("INSERT INTO MARKSHEET (ID,FNAME,Maths) values(35,'Raman',85)");
		stmt.addBatch("INSERT INTO MARKSHEET (ID,FNAME,Maths) values(36,'Aman',89)");
		stmt.addBatch("INSERT INTO MARKSHEET (ID,FNAME,Maths) values(37,'Raghav',90)");

		int[] count = stmt.executeBatch();
		System.out.println("Inserted...");
		
		
		//PreparedStatement 

	}
}
