<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
	<form method="post" action="Register">
		<div align="center">
			<table>
				<h1>Registration Form</h1>
					<!-- <tr>
					<th>ID:</th>
					<td><input type="text" name="id"
						></td>
				</tr> -->
				
				<tr>
					<th>First Name :</th>
					<td><input type="text" name="fname"
						placeholder="enter your first name"></td>
				</tr>
				<tr>
					<th>Last Name :</th>
					<td><input type="text" name="lname"
						placeholder="enter your last name"></td>
				</tr>
				<tr>
					<th>D O B :</th>
					<td><input type="date" name="dob"></td>
				</tr>
				<tr>
					<th>Email :</th>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<th>Password :</th>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<th>Gender :</th>
					<td><input type="radio" name="gender">Male <input
						type="radio" name="gender">Female</td>
				</tr>
				<tr>
					<th>Mobile No :</th>
					<td><input type="number" name="mob" maxlength="10"></td>
				</tr>
				<tr>
					<th>Hobbies :</th>
					<td><input type="checkbox" name="ckt">Cricket <input
						type="checkbox" name="hky">Hockey <input type="checkbox"
						name="ches">Chess
					</td>
				</tr>
				<tr>
					<th>City :</th>
					<td><select name="city">
							<option>select</option>
							<option>Indore</option>
							<option>Ujjain</option>
							<option>Delhi</option>
							<option>Mumbai</option></td>

				</tr>
				<tr>
					<th>Address :</th>
					<td><textarea name="add" rows="2" cols="22"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit"> <input
						type="reset" value="Reset"></td>
				</tr>

			</table>
		</div>
	</form>
</body>
</html>