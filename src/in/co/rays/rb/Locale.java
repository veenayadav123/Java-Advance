package in.co.rays.rb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class Locale {

	public static void main(String[] args) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rb.hindiLang");

		System.out.println(rb.getString("greeting"));

	}
}
