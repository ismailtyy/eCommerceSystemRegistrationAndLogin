package eCommerceSystemRegistrationAndLogin.business.abstracts;

import java.util.List;

import eCommerceSystemRegistrationAndLogin.entities.concretes.User;

public interface UserService {
	void signIn(User user);
	void logIn(User user);

}
