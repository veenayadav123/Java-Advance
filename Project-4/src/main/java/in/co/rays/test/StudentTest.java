package in.co.rays.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.StudentBean;
import in.co.rays.model.StudentModel;

public class StudentTest {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testFindByEmailId();
		// testFindByPk();
		// testUpdate();
		// testDelete();
		// testSearch();
		 testList();
	}

	public static void testAdd() throws Exception {

		StudentBean bean = new StudentBean();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

		bean.setCollegeId(102);
		bean.setCollegeName("J.I.T");
		bean.setFirstName("Reema");
		bean.setLastName("Yadav");
		bean.setDob(sdf.parse("7-12-1996"));
		bean.setMobileNo("9617802365");
		bean.setEmail("yveena24yadav@gmail.com");
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		StudentModel model = new StudentModel();
		model.add(bean);
	}

	public static void testFindByEmailId() throws Exception {

		StudentBean bean = new StudentBean();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

		bean.setEmail("yveena21yadav@gmail.com");

		StudentModel model = new StudentModel();
		StudentBean bean1 = model.findByEmailId(bean);

		if (bean1 == null) {
			System.out.println("Test Find By EmailId failed");
		} else {

			System.out.print(bean1.getId());
			System.out.print(" " + bean1.getCollegeId());
			System.out.print(" " + bean1.getCollegeName());
			System.out.print(" " + bean1.getFirstName());
			System.out.print(" " + bean1.getLastName());
			System.out.print(" " + bean1.getDob());
			System.out.print(" " + bean1.getMobileNo());
			System.out.print(" " + bean1.getEmail());
			System.out.print(" " + bean1.getCreatedBy());
			System.out.print(" " + bean1.getModifiedBy());
			System.out.print(" " + bean1.getCreatedDatetime());
			System.out.print(" " + bean1.getModifiedDatetime());
		}
	}

	public static void testFindByPk() throws Exception {

		StudentBean bean = new StudentBean();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

		bean.setId(1);

		StudentModel model = new StudentModel();
		StudentBean bean1 = model.findByPk(bean);

		if (bean1 == null) {
			System.out.println("Test Find By Pk failed");
		} else {

			System.out.print(bean1.getId());
			System.out.print(" " + bean1.getCollegeId());
			System.out.print(" " + bean1.getCollegeName());
			System.out.print(" " + bean1.getFirstName());
			System.out.print(" " + bean1.getLastName());
			System.out.print(" " + bean1.getDob());
			System.out.print(" " + bean1.getMobileNo());
			System.out.print(" " + bean1.getEmail());
			System.out.print(" " + bean1.getCreatedBy());
			System.out.print(" " + bean1.getModifiedBy());
			System.out.print(" " + bean1.getCreatedDatetime());
			System.out.print(" " + bean1.getModifiedDatetime());
		}
	}

	public static void testUpdate() throws Exception {

		StudentBean bean = new StudentBean();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

		bean.setCollegeId(105);
		bean.setCollegeName("DAVV");
		bean.setFirstName("Ananya");
		bean.setLastName("Sharma");
		bean.setDob(sdf.parse("1-11-2001"));
		bean.setMobileNo("9755413654");
		bean.setEmail("sananya@gmail.com");
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(1);

		StudentModel model = new StudentModel();
		model.update(bean);
	}

	public static void testDelete() throws Exception {

		StudentBean bean = new StudentBean();

		bean.setId(8);

		StudentModel model = new StudentModel();
		model.delete(bean);
	}

	public static void testSearch() throws Exception {

		StudentModel model = new StudentModel();
		List list = model.search();

		Iterator<StudentBean> it = list.iterator();

		while (it.hasNext()) {
			StudentBean bean = it.next();

			System.out.print(bean.getId());
			System.out.print(" " + bean.getCollegeId());
			System.out.print(" " + bean.getCollegeName());
			System.out.print(" " + bean.getFirstName());
			System.out.print(" " + bean.getLastName());
			// System.out.print(" " + bean.getDob());
			System.out.print(" " + bean.getMobileNo());
			System.out.print(" " + bean.getEmail());
			System.out.print(" " + bean.getCreatedBy());
			System.out.print(" " + bean.getModifiedBy());
			System.out.print(" " + bean.getCreatedDatetime());
			System.out.println(" " + bean.getModifiedDatetime());

		}
	}

	public static void testList() throws Exception {

		StudentModel model = new StudentModel();
		List list = model.list(1, 5);

		Iterator it = list.iterator();

		StudentBean bean = null;

		while (it.hasNext()) {
			bean = (StudentBean) it.next();

			System.out.print(bean.getId());
			System.out.print(" " + bean.getCollegeId());
			System.out.print(" " + bean.getCollegeName());
			System.out.print(" " + bean.getFirstName());
			System.out.print(" " + bean.getLastName());
		    System.out.print(" " + bean.getDob());
			System.out.print(" " + bean.getMobileNo());
			System.out.print(" " + bean.getEmail());
			System.out.print(" " + bean.getCreatedBy());
			System.out.print(" " + bean.getModifiedBy());
			System.out.print(" " + bean.getCreatedDatetime());
			System.out.println(" " + bean.getModifiedDatetime());

		}
	}

}
