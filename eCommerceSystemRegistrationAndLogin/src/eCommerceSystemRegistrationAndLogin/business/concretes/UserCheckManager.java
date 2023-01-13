package eCommerceSystemRegistrationAndLogin.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceSystemRegistrationAndLogin.business.abstracts.UserCheckSercvice;
import eCommerceSystemRegistrationAndLogin.entities.concretes.User;

public class UserCheckManager implements UserCheckSercvice{
	List<User> users = new ArrayList<User>();

	@Override
	public boolean isValidPassword(User user) {
		if(user.getPassword().isEmpty()) {
			System.out.println("Burası boş bırakılmaz bir parolla giriniz.");
			return false;
		}else {
			if(user.getPassword().length()<6) {
				System.out.println("Parola en az 6 karakterden oluşturulmalıdır.");
				return false;
				
			}
		}
		return true;
	}

	@Override
	public boolean isValidMail(User user) {
		String regex = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		if(user.getEmail().isEmpty()) {
			System.out.println("Burası boş bırakılmaz bir e-mail giriniz.");
			return false;
			
		}else {
			if(pattern.matcher(user.getEmail()).find() == false) {
				System.out.println("Geçersiz!");
				return false;
			}
		}
		
		
		
		return true;
	}

	@Override
	public boolean checkFirstName(User user) {
		if(user.getFirstName().isEmpty()) {
			System.out.println("Burası boş bırakılmaz bir isim girirniz.");
			return false;
		}else {
			if(user.getFirstName().length()<=2) {
				System.out.println("İsim en az 2 karakterden oluşmalıdır");
				return false;
			}
			
		}
		return true;
	}

	@Override
	public boolean checkLastName(User user) {
		if(user.getFirstName().isEmpty()) {
			System.out.println("Burası boş bırakılmaz bir soyisim girirniz.");
			return false;
		}else {
			if(user.getFirstName().length()<=2) {
				System.out.println("Soyisim en az 2 karakterden oluşmalıdır");
				return false;
			}
			
		}
		return true;
	}

	@Override
	public boolean isUniquemail(User user) {
		for (User u : users) {
			if(u.getEmail() == user.getEmail()) {
				System.out.println("Bu e-mail sistemde kayıtlıdır yeni bir mail adresi giriniz.");
				return false;
			}
		}
		users.add(user);
		return true;
	}

	@Override
	public boolean isValid(User user) {
		if(isValidPassword(user) && isValidMail(user) && checkFirstName(user) && checkLastName(user) && isUniquemail(user)) {
			return true;
		}
		return false;
	}

}
