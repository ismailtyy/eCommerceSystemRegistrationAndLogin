package eCommerceSystemRegistrationAndLogin.core;

import Google.GoogleManager;

public class GoogleManagerAdater implements GoogleService{

	@Override
	public void logIn(String email, String password) {
		System.out.println("Google ile giriş yapıldı.");
		
	}

}
