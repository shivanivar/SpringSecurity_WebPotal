package com.cisco.dao;

import java.util.List;
import com.cisco.models.User;

public interface UserDAO {
	public long addUser(User p);

	public void updateUser(User p);

	public List<User> listUser();

	public List<User> getUserById(String email);

	public void removeUser(int id);

	public User getUserByUsername(String username);

	public List<String> getPermissions(String username);

	public User getCurrentUser();

	public Boolean isCurrentUserLoggedIn();
}
