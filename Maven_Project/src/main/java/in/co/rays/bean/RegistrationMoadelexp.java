package in.co.rays.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RegistrationMoadelexp {

	public void authenticate(String email) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rb.app");

		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));
		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("SELECT * FROM REGISTRATION WHERE EMAIL=?");
		ps.setString(1, email);

		ResultSet rs = ps.executeQuery();

		Registrationbean bean = null;

		while (rs.next()) {

			bean = new Registrationbean();
			bean.setEmail(rs.getString(1));
			if(email.equals(bean.getEmail())) {
				System.out.println("Valid User");
			}
			else {
				System.out.println("Invalid User");
			}
		}

		System.out.println("Done");

		conn.commit();
		ps.close();
		conn.close();

	}

}
