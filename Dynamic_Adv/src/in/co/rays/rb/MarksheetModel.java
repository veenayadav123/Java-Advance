package in.co.rays.rb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Marksheet.Marksheetbean;

public class MarksheetModel {

	public void add(Marksheetbean bean) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rb.app");

		Class.forName(rb.getString("driver"));

		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));

		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("INSERT INTO MARKSHEET VALUES(?,?,?,?,?,?,?)");

		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getRno());
		ps.setString(3, bean.getFname());
		ps.setString(4, bean.getLname());
		ps.setInt(5, bean.getPhy());
		ps.setInt(6, bean.getChe());
		ps.setInt(7, bean.getMat());

		int i = ps.executeUpdate();
		System.out.println(i + " Inserted");

		conn.commit();
		conn.close();
		ps.close();
	}

	public void update(Marksheetbean bean) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rb.app");

		Class.forName("driver");

		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));

		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement(
				"UPDATE MARKSHEET SET ROLL_NO=?,FNAME=?,LNAME=?,PHYSICS=?,CHEMISTRY=?,MATHS=? WHERE ID=?");

		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getRno());
		ps.setString(3, bean.getFname());
		ps.setString(4, bean.getLname());
		ps.setInt(5, bean.getPhy());
		ps.setInt(6, bean.getChe());
		ps.setInt(7, bean.getMat());

		int i = ps.executeUpdate();
		System.out.println(i + " Updated");

		conn.commit();
		conn.close();
		ps.close();
	}

	public void delete(Marksheetbean bean) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rb.app");
		Class.forName("driver");

		Connection conn = DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("password"));
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("DELETE FROM MARKSHEET WHERE ROLL_No=?");

		ps.setString(1, bean.getRno());

		int i = ps.executeUpdate();
		System.out.println(i + "Deleted");

		conn.commit();
		conn.close();
		ps.close();
	}

	public List<Marksheetbean> get(String rno) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rb.app");
		
		Class.forName(rb.getString("driver"));

		Connection conn = DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("password"));

		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("SELECT * FROM MARKSHEET WHERE ROLL_NO=?");
		ps.setString(1, rno);

		ResultSet rs = ps.executeQuery();
		ArrayList<Marksheetbean> list = new ArrayList<Marksheetbean>();
		Marksheetbean bean = null;

		while (rs.next()) {

			bean = new Marksheetbean();
			bean.setId(rs.getInt(1));
			bean.setRno(" " + rs.getString(2));
			bean.setFname(" " + rs.getString(3));
			bean.setLname(" " + rs.getString(4));
			bean.setPhy(rs.getInt(5));
			bean.setChe(rs.getInt(6));
			bean.setMat(rs.getInt(7));
			list.add(bean);

		}

		conn.commit();
		conn.close();
		ps.close();
		return list;
	}

	public List<Marksheetbean> search() throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rb.app");
		Class.forName(rb.getString("driver"));

		Connection conn = DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("password"));

		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("SELECT * FROM MARKSHEET");

		ResultSet rs = ps.executeQuery();

		ArrayList<Marksheetbean> list = new ArrayList<Marksheetbean>();
		Marksheetbean bean = null;

		while (rs.next()) {

			bean = new Marksheetbean();

			bean.setId(rs.getInt(1));
			bean.setRno(rs.getString(2));
			bean.setFname(rs.getString(3));
			bean.setLname(rs.getString(4));
			bean.setPhy(rs.getInt(5));
			bean.setChe(rs.getInt(6));
			bean.setMat(rs.getInt(7));
			list.add(bean);
		}

		conn.commit();
		ps.close();
		conn.close();
		return list;

	}

	public List<Marksheetbean> getMaritList() throws Exception {

		
		ResourceBundle rb = ResourceBundle.getBundle("in.co.rb.app");
		Class.forName(rb.getString("driver"));

		Connection conn = DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("password"));

		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement(
				"SELECT *,(PHYSICS+CHEMISTRY+MATHS) AS TOTAL,(PHYSICS+CHEMISTRY+MATHS/3) AS PERCENTAGE FROM MARKSHEET ORDER BY TOTAL DESC LIMIT 3");

		ResultSet rs = ps.executeQuery();

		ArrayList<Marksheetbean> list = new ArrayList<Marksheetbean>();
		Marksheetbean bean = null;

		while (rs.next()) {

			bean = new Marksheetbean();
			bean.setId(rs.getInt(1));
			bean.setRno(rs.getString(2));
			bean.setFname(rs.getString(3));
			bean.setLname(rs.getString(4));
			bean.setPhy(rs.getInt(5));
			bean.setChe(rs.getInt(6));
			bean.setMat(rs.getInt(7));

			list.add(bean);
		}
		conn.commit();
		ps.close();
		conn.close();
		return list;
	}
}
