package in.co.rays.rb;

import java.util.Iterator;
import java.util.List;

import Marksheet.MarksheetModel;
import Marksheet.Marksheetbean;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testGet();
		// testSearch();
		// testGetMeritList();

	}

	public static void testAdd() throws Exception {

		Marksheetbean bean = new Marksheetbean();
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

		Marksheetbean bean = new Marksheetbean();
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

		Marksheetbean bean = new Marksheetbean();

		bean.setRno("101Rays");

		MarksheetModel model = new MarksheetModel();
		model.delete(bean);

	}

	public static void testGet() throws Exception {

		MarksheetModel model = new MarksheetModel();
		List list = model.get("101");
		Iterator<Marksheetbean> it = list.iterator();

		while (it.hasNext()) {

			Marksheetbean bean = it.next();
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
		Iterator<Marksheetbean> it = list.iterator();

		while (it.hasNext()) {
			Marksheetbean bean = it.next();
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
		Iterator<Marksheetbean> it = list.iterator();

		while (it.hasNext()) {
			Marksheetbean bean = (Marksheetbean) it.next();
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
