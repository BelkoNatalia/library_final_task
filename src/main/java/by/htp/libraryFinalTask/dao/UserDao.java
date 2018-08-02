package by.htp.libraryFinalTask.dao;

import by.htp.libraryFinalTask.entity.User;

public interface UserDao {
	void addUser(User user);
	void updateNumbersBooksByShifrUser(int number, String shifrUser);
	User getUserByShifr(String shifrUser);
}
