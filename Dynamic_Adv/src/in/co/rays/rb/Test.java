package in.co.rays.rb;

import java.util.ResourceBundle;

public class Test {

	public static void main(String[] args) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rb.hindi_Contry");

		System.out.println(rb.getString("greeting"));

	}
}
