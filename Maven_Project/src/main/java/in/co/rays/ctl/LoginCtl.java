package in.co.rays.ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.Loginbean;
import in.co.rays.model.LoginModel;
@WebServlet("/Servlet")
public class LoginCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		//int id = Integer.parseInt(request.getParameter("id"));
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		Loginbean bean = new Loginbean();
		//bean.setId(id);
		bean.setUser(user);
		bean.setPwd(pwd);
		
		LoginModel model = new LoginModel();
		try {
			//model.add(bean);
			bean = model.authenticate(bean.getUser(),bean.getPwd());
			
			if(bean!=null) {
				System.out.println("Login Successfully");
			}else {
				System.out.println("Invalid Login");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.print("Inserted");
		//out.print(user+" "+pwd);
		out.close();
		
	}

}
