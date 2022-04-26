package in.co.rays.model;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import in.co.rays.bean.StudentBean;

public class StudentModel {

	public int nextPk() throws Exception {

		int pk = 0;
		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));
		PreparedStatement ps = conn.prepareStatement("select max(id) from st_student");
		conn.setAutoCommit(false);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);
		}

		return pk + 1;

	}

	public void add(StudentBean bean) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("insert into st_student values(?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setInt(1, nextPk());
		ps.setLong(2, bean.getCollegeId());
		ps.setString(3, bean.getCollegeName());
		ps.setString(4, bean.getFirstName());
		ps.setString(5, bean.getLastName());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(7, bean.getMobileNo());
		ps.setString(8, bean.getEmail());
		ps.setString(9, bean.getCreatedBy());
		ps.setString(10, bean.getModifiedBy());
		ps.setTimestamp(11, bean.getCreatedDatetime());
		ps.setTimestamp(12, bean.getModifiedDatetime());

		int i = ps.executeUpdate();

		System.out.println(i + "Inserted");

		conn.commit();
		ps.close();
		conn.close();
	}

	public StudentBean findByEmailId(StudentBean bean) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ST_STUDENT WHERE EMAIL=?");

		ps.setString(1, bean.getEmail());
		ResultSet rs = ps.executeQuery();

		StudentBean bean1 = null;

		while (rs.next()) {

			bean1 = new StudentBean();
			bean1.setId(rs.getInt(1));
			bean1.setCollegeId(rs.getLong(2));
			bean1.setCollegeName(rs.getString(3));
			bean1.setFirstName(rs.getString(4));
			bean1.setLastName(rs.getString(5));
			bean1.setDob(rs.getDate(6));
			bean1.setMobileNo(rs.getString(7));
			bean1.setEmail(rs.getString(8));
			bean1.setCreatedBy(rs.getString(9));
			bean1.setModifiedBy(rs.getString(10));
			bean1.setCreatedDatetime(rs.getTimestamp(11));
			bean1.setModifiedDatetime(rs.getTimestamp(12));

		}
		rs.close();
		return bean1;
	}

	public StudentBean findByPk(StudentBean bean) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ST_STUDENT WHERE ID=?");

		ps.setLong(1, bean.getId());

		ResultSet rs = ps.executeQuery();
		StudentBean bean1 = null;

		while (rs.next()) {

			bean1 = new StudentBean();
			bean1.setId(rs.getInt(1));
			bean1.setCollegeId(rs.getLong(2));
			bean1.setCollegeName(rs.getString(3));
			bean1.setFirstName(rs.getString(4));
			bean1.setLastName(rs.getString(5));
		    bean1.setDob(rs.getDate(6));
			bean1.setMobileNo(rs.getString(7));
			bean1.setEmail(rs.getString(8));
			bean1.setCreatedBy(rs.getString(9));
			bean1.setModifiedBy(rs.getString(10));
			bean1.setCreatedDatetime(rs.getTimestamp(11));
			bean1.setModifiedDatetime(rs.getTimestamp(12));

		}
		rs.close();
		return bean1;

	}

	public static void update(StudentBean bean) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement(
				"UPDATE ST_STUDENT SET COLLEGE_ID=?,COLLEGE_NAME=?,FIRST_NAME=?,LAST_NAME=?,DATE_OF_BIRTH=?,MOBILE_NO=?,EMAIL=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?");

		ps.setLong(1, bean.getCollegeId());
		ps.setString(2, bean.getCollegeName());
		ps.setString(3, bean.getFirstName());
		ps.setString(4, bean.getLastName());
		ps.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(6, bean.getMobileNo());
		ps.setString(7, bean.getEmail());
		ps.setString(8, bean.getCreatedBy());
		ps.setString(9, bean.getModifiedBy());
		ps.setTimestamp(10, bean.getCreatedDatetime());
		ps.setTimestamp(11, bean.getModifiedDatetime());
		ps.setLong(12, bean.getId());

		int i = ps.executeUpdate();
		System.out.println(i + "Updated");
		conn.commit();
		ps.close();
		conn.close();
	}

	public void delete(StudentBean bean) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("DELETE FROM ST_STUDENT WHERE ID=?");
		ps.setLong(1, bean.getId());

		int i = ps.executeUpdate();
		System.out.println(i + " Deleted");
		conn.commit();
		ps.close();
		conn.close();
	}

	public List<StudentBean> search() throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));

		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ST_STUDENT");
		ResultSet rs = ps.executeQuery();

		ArrayList<StudentBean> list = new ArrayList<StudentBean>();
		StudentBean bean = null;

		while (rs.next()) {
			bean = new StudentBean();
			bean.setId(rs.getLong(1));
			bean.setCollegeId(rs.getLong(2));
			bean.setCollegeName(rs.getString(3));
			bean.setFirstName(rs.getString(4));
			bean.setLastName(rs.getString(5));
		    bean.setDob(rs.getDate(6));
			bean.setMobileNo(rs.getString(7));
			bean.setEmail(rs.getString(8));
			bean.setCreatedBy(rs.getString(9));
			bean.setModifiedBy(rs.getString(10));
			bean.setCreatedDatetime(rs.getTimestamp(11));
			bean.setModifiedDatetime(rs.getTimestamp(12));
			list.add(bean);
		}
		ps.close();
		conn.close();
		return list;

	}

	public List list(int pageNo, int pageSize) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));

		StringBuffer sql = new StringBuffer("SELECT * FROM ST_STUDENT WHERE 1=1");

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}

		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();

		ArrayList<StudentBean> list = new ArrayList<StudentBean>();

		StudentBean bean = null;
		while (rs.next()) {

			bean = new StudentBean();
			bean.setId(rs.getLong(1));
			bean.setCollegeId(rs.getLong(2));
			bean.setCollegeName(rs.getString(3));
			bean.setFirstName(rs.getString(4));
			bean.setLastName(rs.getString(5));
			// bean.setDob(rs.getDate(6));
			bean.setMobileNo(rs.getString(7));
			bean.setEmail(rs.getString(8));
			bean.setCreatedBy(rs.getString(9));
			bean.setModifiedBy(rs.getString(10));
			bean.setCreatedDatetime(rs.getTimestamp(11));
			bean.setModifiedDatetime(rs.getTimestamp(12));
			list.add(bean);
		}
		ps.close();
		conn.close();
		return list;

	}

}
