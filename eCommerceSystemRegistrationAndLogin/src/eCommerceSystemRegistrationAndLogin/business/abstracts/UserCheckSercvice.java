package eCommerceSystemRegistrationAndLogin.business.abstracts;

import eCommerceSystemRegistrationAndLogin.entities.concretes.User;

public interface UserCheckSercvice {
	boolean isValidPassword(User user);
	boolean isValidMail(User user);
	boolean checkFirstName(User user);
	boolean checkLastName(User user);
	boolean isUniquemail(User user);
	boolean isValid(User user);

}
