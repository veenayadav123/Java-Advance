<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered Data</title>
</head>
<body>
	<form>
		<table>
			<%
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
			    int dob = Integer.parseInt(request.getParameter("dob"));
				String email = request.getParameter("email");
				String pwd = request.getParameter("pwd");
				String gender = request.getParameter("gender");
				String ckt = request.getParameter("ckt");
				String hky = request.getParameter("hky");
				String ches = request.getParameter("ches");
				if (ckt != null && hky != null && ches != null) {

					out.println(ckt);
					out.println(hky);
					out.println(ches);

				} else if (ckt != null || hky != null || ches != null) {

					if (ckt != null) {

						out.println(ckt);
					}
					if (hky != null) {
						out.println(hky);
					}
					if (ches != null) {
						out.println(ches);
					}
				} else {

				}

				int mobile = Integer.parseInt(request.getParameter("mob"));
				String add = request.getParameter("add");
				String city = request.getParameter("city");

				out.println(fname + " " + lname);
				out.println(dob + " " + email + " " + " " + pwd + " " + gender + " " + mobile + " " + add + " " + city);
			%>
		</table>
	</form>
</body>
</html>