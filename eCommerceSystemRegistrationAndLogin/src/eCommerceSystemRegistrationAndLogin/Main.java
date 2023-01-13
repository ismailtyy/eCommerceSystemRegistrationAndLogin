package eCommerceSystemRegistrationAndLogin;

import eCommerceSystemRegistrationAndLogin.business.abstracts.UserService;
import eCommerceSystemRegistrationAndLogin.business.concretes.UserCheckManager;
import eCommerceSystemRegistrationAndLogin.business.concretes.UserManager;
import eCommerceSystemRegistrationAndLogin.core.GoogleManagerAdater;
import eCommerceSystemRegistrationAndLogin.dataAccess.concretes.HibernateUserDao;
import eCommerceSystemRegistrationAndLogin.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserService service = new UserManager(new UserCheckManager(), new HibernateUserDao(), new GoogleManagerAdater());
		
		User user1 = new User(1, "İsmail", "Toy","toyismailhakki@gmail.com" , "123456");
		
		
		
		service.logIn(user1);
		

	}

}
