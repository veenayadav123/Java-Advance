package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import in.co.rays.bean.Loginbean;

public class LoginModel {

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

	public void add(Loginbean bean) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));
		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("INSERT INTO LOGIN VALUES(?,?)");

		ps.setInt(1, nextPk());
		ps.setString(2, bean.getUser());
		ps.setString(3, bean.getPwd());

		int i = ps.executeUpdate();
		conn.commit();
		ps.close();
		conn.close();
	}

	public Loginbean authenticate(String user,String pwd) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));
		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("SELECT * FROM LOGIN WHERE USER_NAME=? AND PASSWORD=?");

		ps.setString(1, user);
		ps.setString(2, pwd);

		ResultSet rs = ps.executeQuery();

		Loginbean bean1 = null;
		while (rs.next()) {

			bean1 = new Loginbean();
			bean1.setUser(rs.getString(1));
			bean1.setPwd(rs.getString(2));
		}
		return bean1;

	}
}
