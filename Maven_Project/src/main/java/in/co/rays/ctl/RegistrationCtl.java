package in.co.rays.ctl;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.Registrationbean;
import in.co.rays.model.RegistrationModel;
import in.co.rays.test.TestRegistrationModel;

@WebServlet(urlPatterns = "/Register")
public class RegistrationCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		//int id = Integer.parseInt(request.getParameter("id"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		long mobile = Long.parseLong(request.getParameter("mob"));
		String add = request.getParameter("add");
		/*
		 * String dob = request.getParameter("dob");
		 * 
		 * String gender = request.getParameter("gender");
		 * 
		 */
		Registrationbean bean = new Registrationbean();
		//bean.setId(id);
		
		bean.setFname(fname);
		bean.setLname(lname);
		bean.setEmail(email);
		bean.setPwd(pwd);
		bean.setMno(mobile);
		bean.setAddrs(add);

		/*
		 * TestRegistrationModel trm = new TestRegistrationModel(); trm.testget(email);
		 */
		RegistrationModel model = new RegistrationModel();
		try {
			model.add(bean);
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		PrintWriter out = response.getWriter();
		out.println("Inserted");

		/*
		 * out.println(fname + " " + lname); out.println(dob + " " + email + " " + " " +
		 * pwd + " " + gender + " " + mobile + " " + add); out.close();
		 */
	}

}
