package by.htp.libraryFinalTask.dao.impl;

import static by.htp.libraryFinalTask.dao.utils.MySqlPropertyManager.getLogin;
import static by.htp.libraryFinalTask.dao.utils.MySqlPropertyManager.getPass;
import static by.htp.libraryFinalTask.dao.utils.MySqlPropertyManager.getUrl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.libraryFinalTask.dao.UserDao;
import by.htp.libraryFinalTask.entity.User;

public class UserDaoBdImpl implements UserDao{
	private static final String INSERT_USER = "INSERT INTO users(shifr_user, name_user, surname_user, role_user, password_user, numbers_books ) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_NUMBERS_BOOKS = "UPDATE users SET numbers_books = ? WHERE shifr_user = ?";
	private static final String SELECT_USER_BY_SHIFR = "SELECT * FROM users WHERE shifr_user = ?";
	
	@Override
	public void addUser(User user) {
		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(INSERT_USER);
			ps.setString(1, user.getShifrUser());
			ps.setString(2, user.getName());
			ps.setString(3, user.getSurname());
			ps.setString(4, user.getRole());
			ps.setString(5, user.getPassword());
			ps.setInt(6, user.getNumbersBooks());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateNumbersBooksByShifrUser(int number, String shifrUser) {
		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(UPDATE_NUMBERS_BOOKS);
			ps.setInt(1, number);
			ps.setString(2, shifrUser);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User getUserByShifr(String shifrUser) {
		User user = null;

		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {

			PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_SHIFR);
			ps.setString(1, shifrUser);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = buildUser(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	private User buildUser(ResultSet rs) throws SQLException {
		User user = new User();
		String shifrUser = rs.getString("shifr_user");
		user.setShifrUser(shifrUser);
		String nameUser = rs.getString("name_user");
		user.setName(nameUser);
		String surnameUser = rs.getString("surname_user");
		user.setSurname(surnameUser);
		String roleUser = rs.getString("role_user");
		user.setRole(roleUser);
		String passwordUser = rs.getString("password_user");
		user.setPassword(passwordUser);
		int numbersBooks = rs.getInt("numbers_books");
		user.setNumbersBooks(numbersBooks);
		
		return user;
	}

}
