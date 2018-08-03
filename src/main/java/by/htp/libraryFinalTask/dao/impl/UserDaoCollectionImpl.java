package by.htp.libraryFinalTask.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.htp.libraryFinalTask.dao.UserDao;
import by.htp.libraryFinalTask.entity.User;

public class UserDaoCollectionImpl implements UserDao{
	private List<User> userList = new ArrayList<User>();

	@Override
	public void addUser(User user) {
		userList.add(user);
	}

	@Override
	public void updateNumbersBooksByShifrUser(int number, String shifrUser) {
		for(int i=0; i < userList.size(); i++) {
			if (userList.get(i).getShifrUser().equals(shifrUser)) {
			User user = userList.get(i);
			user.setNumbersBooks(number);
			userList.set(i, user);
			}
		}
	}

	@Override
	public User getUserByShifr(String shifrUser) {
		for (int i=0; i < userList.size(); i++) {
			if (userList.get(i).getShifrUser().equals(shifrUser)) {
				User user = userList.get(i);
				return user;
			}
		}
		return null;
	}

}
