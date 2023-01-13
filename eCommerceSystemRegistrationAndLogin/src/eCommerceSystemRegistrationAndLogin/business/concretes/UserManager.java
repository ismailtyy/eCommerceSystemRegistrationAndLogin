package eCommerceSystemRegistrationAndLogin.business.concretes;

import eCommerceSystemRegistrationAndLogin.business.abstracts.UserCheckSercvice;
import eCommerceSystemRegistrationAndLogin.business.abstracts.UserService;
import eCommerceSystemRegistrationAndLogin.core.GoogleService;
import eCommerceSystemRegistrationAndLogin.dataAccess.abstracts.UserDao;
import eCommerceSystemRegistrationAndLogin.entities.concretes.User;

public class UserManager implements UserService{
	 private UserCheckSercvice checkSercvice;
	 private UserDao dao;
	 private GoogleService googleService;
	 public UserManager(UserCheckSercvice checkSercvice, UserDao dao, GoogleService googleService) {
		 super();
		 this.checkSercvice = checkSercvice;
		 this.dao = dao;
		 this.googleService = googleService;
	 }
	

	@Override
	public void signIn(User user) {
		if(dao.get(user.getId()).getPassword()== user.getPassword() && dao.get(user.getId()).getEmail() == user.getEmail()) {
			System.out.println(user.getFirstName()+" "+user.getLastName()+" " + "Adlı üye "+" "+" sisteme başarıyla giriş yaptı.");
			
		}else {
			System.out.println(" Giriş başarısız e-posta ve ya Parola hatalı e-posta ve parolanızı kontrol edip tekrar deneyiniz.");
		}
		
		
	}

	@Override
	public void logIn(User user) {
		if(checkSercvice.checkFirstName(user)&& checkSercvice.checkLastName(user)&& 
				checkSercvice.isValidMail(user)&& checkSercvice.isValidPassword(user)&& checkSercvice.isUniquemail(user)) {
			System.out.println("Sayın : " +" "+ user.getFirstName()+ " "+user.getLastName()+ " " +"sisteme başarıyla üye oldunuz." );
			dao.add(user);
			googleService.logIn("toyismailhakki@gmail.com","123456");
		}else {
			System.out.println("Hatal� parametre Tekrar deneyin.");
		}
		
	}

}
