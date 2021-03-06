package in.co.rays.test;

import java.util.Iterator;
import java.util.List;
import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.MarksheetModel;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

		 testAdd();
		// testUpdate();
		// testDelete();
		// testGet();
		// testSearch();
		// testGetMeritList();

	}

	public static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		bean.setId(16);
		bean.setRno("101Rays");
		bean.setFname("VEENA");
		bean.setLname("YADAV");
		bean.setPhy(94);
		bean.setChe(90);
		bean.setMat(91);

		MarksheetModel model = new MarksheetModel();
		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		bean.setId(13);
		bean.setRno("103Rays");
		bean.setFname("Sanaya");
		bean.setLname("Sharma");
		bean.setPhy(75);
		bean.setChe(78);
		bean.setMat(80);

		MarksheetModel model = new MarksheetModel();
		model.update(bean);
	}

	public static void testDelete() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setRno("101Rays");

		MarksheetModel model = new MarksheetModel();
		model.delete(bean);

	}

	public static void testGet() throws Exception {

		MarksheetModel model = new MarksheetModel();
		List list = model.get("101");
		Iterator<MarksheetBean> it = list.iterator();

		while (it.hasNext()) {

			MarksheetBean bean = it.next();
			System.out.print(bean.getId());
			System.out.print(" " + bean.getRno());
			System.out.print(" " + bean.getFname());
			System.out.print(" " + bean.getLname());
			System.out.print(" " + bean.getPhy());
			System.out.print(" " + bean.getChe());
			System.out.println(" " + bean.getMat());
		}

	}

	public static void testSearch() throws Exception {

		MarksheetModel model = new MarksheetModel();
		List list = model.search();
		Iterator<MarksheetBean> it = list.iterator();

		while (it.hasNext()) {
			MarksheetBean bean = it.next();
			System.out.print(bean.getId());
			System.out.print(" " + bean.getRno());
			System.out.print(" " + bean.getFname());
			System.out.print(" " + bean.getLname());
			System.out.print(" " + bean.getPhy());
			System.out.print(" " + bean.getChe());
			System.out.println(" " + bean.getMat());
		}

	}

	public static void testGetMeritList() throws Exception {

		MarksheetModel model = new MarksheetModel();
		List list = model.getMaritList();
		Iterator<MarksheetBean> it = list.iterator();

		while (it.hasNext()) {
			MarksheetBean bean = (MarksheetBean) it.next();
			System.out.print(bean.getId());
			System.out.print(" " + bean.getRno());
			System.out.print(" " + bean.getFname());
			System.out.print(" " + bean.getLname());
			System.out.print(" " + bean.getPhy());
			System.out.print(" " + bean.getChe());
			System.out.println(" " + bean.getMat());

		}

	}

}
