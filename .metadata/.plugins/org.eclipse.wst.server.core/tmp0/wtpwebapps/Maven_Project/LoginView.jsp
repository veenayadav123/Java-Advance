<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body bgcolor="white">

	<form method="post" action="Servlet">
		<div align="center">

			<table>

				<h1>Login Form</h1>
				<!-- <tr>
					<th>ID :</th>
					<td><INPUT TYPE="text" NAME="id"></td>
				</tr> -->
				<tr>
					<th>Username*</th>
					<td><INPUT TYPE="text" NAME="user"
						placeholder="enter your user id"></td>
				</tr>
				<br>
				<tr>
					<th>Password*</th>
					<td><INPUT TYPE="password" NAME="pwd"
						placeholder="enter your password"></td>
				</tr>
				<br>
				<tr>
					<td></td>
					<td><INPUT TYPE="submit" NAME="login" VALUE="submit">
						<INPUT TYPE="reset" NAME="clear" VALUE="reset"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>