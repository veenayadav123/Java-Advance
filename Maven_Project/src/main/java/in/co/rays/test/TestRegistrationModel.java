package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.RegistrationMoadelexp;
import in.co.rays.bean.Registrationbean;
import in.co.rays.model.RegistrationModel;

public class TestRegistrationModel {

	public static void main(String[] args) throws Exception {

		//testget(email);
	}

	public static void testget(String email) throws Exception {
		
		String e = email;
		
		RegistrationMoadelexp model = new RegistrationMoadelexp();

		model.authenticate(e);

	}
}