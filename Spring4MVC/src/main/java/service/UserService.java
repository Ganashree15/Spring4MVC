package service;

import java.util.List;

import model.User;

public interface UserService {

	User findById(long id);

	User findByName(String name);

	void saveUser(User user);

	void updateUser(User user);

	List<User> findAllUsers();

	void deleteAllUsers();

	public boolean isUserExist(User user);

	void deleteUserById(long id);

}
