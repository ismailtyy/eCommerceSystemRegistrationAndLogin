package eCommerceSystemRegistrationAndLogin.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceSystemRegistrationAndLogin.dataAccess.abstracts.UserDao;
import eCommerceSystemRegistrationAndLogin.entities.concretes.User;

public class HibernateUserDao implements UserDao {
	List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		System.out.println("Hibernate ile eklendi : " + user.getFirstName() + " " + user.getLastName());
	}

	@Override
	public void delete(User user) {

	}

	@Override
	public void update(User user) {

	}

	@Override
	public User get(User user) {
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public User get(int id) {
		User user1 = new User();
		for (User user : users) {
			if(user.getId() == id) {
				user1 = user;
			}

		}
		return user1;
	}

}
