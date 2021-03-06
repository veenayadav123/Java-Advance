package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import in.co.rays.bean.Registrationbean;

public class RegistrationModel {

	public int nextPk() throws Exception {

		int pk = 0;
		ResourceBundle rb = ResourceBundle.getBundle("in.co.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("select max(id) from registration");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

		}
		return pk + 1;

	}

	public void add(Registrationbean bean) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("INSERT INTO REGISTRATION VALUES(?,?,?,?,?,?,?)");

		ps.setInt(1, nextPk());
		ps.setString(2, bean.getFname());
		ps.setString(3, bean.getLname());
		ps.setString(4, bean.getEmail());
		ps.setString(5, bean.getPwd());
		ps.setLong(6, bean.getMno());
		ps.setString(7, bean.getAddrs());

		int i = ps.executeUpdate();
		System.out.println(i + "inserted");

		conn.commit();
		ps.close();
		conn.close();

	}
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
