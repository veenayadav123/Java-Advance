package Callable_Stat;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CS_Function {

	public static void main(String[] args) throws Exception {

		testSelect();
	}

	public static void testSelect() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		CallableStatement cal = conn.prepareCall("{?=CALL empCount()}");

		cal.registerOutParameter(1, Types.INTEGER);

		cal.execute();
		System.out.println("Count" + cal.getInt(1));

		conn.close();
		cal.close();
	}

}
