package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import in.co.rays.bean.UserBean;

public class UserModel {

	public int nextPk() throws Exception {

		int pk = 0;
		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("pwd"));

		PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM REGISTRATION");
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			
			pk = rs.getInt(1);
		}
		return pk + 1;
	}

	public void add(UserBean bean) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("INSERT INTO USER VALUES(?,?,?,?,?)");
		
		ps.setInt(1,ne);
	

		ResultSet rs = ps.executeQuery();
		System.out.println("inserted");

		conn.commit();
		ps.close();
		conn.close();

	}
}
