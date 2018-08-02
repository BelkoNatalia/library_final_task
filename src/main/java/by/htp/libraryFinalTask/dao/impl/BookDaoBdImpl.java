package by.htp.libraryFinalTask.dao.impl;


import static by.htp.libraryFinalTask.dao.utils.MySqlPropertyManager.getLogin;
import static by.htp.libraryFinalTask.dao.utils.MySqlPropertyManager.getPass;
import static by.htp.libraryFinalTask.dao.utils.MySqlPropertyManager.getUrl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.libraryFinalTask.dao.BookDao;
import by.htp.libraryFinalTask.entity.Book;

public class BookDaoBdImpl implements BookDao {
	private static final String SELECT_BOOK_BY_SHIFR = "SELECT * FROM books WHERE shifr_book = ?";
	private static final String SELECT_ALL_BOOK = "SELECT * FROM books";
	private static final String INSERT_BOOK = "INSERT INTO books(shifr_book, title, shifr_autor, shifr_owner, avialable) VALUES (?, ?, ?, ?, ?)";
	private static final String DELETE_BOOK_BY_SHIFR = "DELETE FROM books WHERE shifr_book = ?";
	private static final String UPDATE_BOOK_OWNER = "UPDATE books SET shifr_owner = ? WHERE shifr_book = ?";
	
	@Override
	public Book getBookByShifr(String shifrBook) {

		Book book = null;

		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {

			PreparedStatement ps = conn.prepareStatement(SELECT_BOOK_BY_SHIFR);
			ps.setString(1, shifrBook);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				book = buildBook(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return book;
	}

	@Override
	public List<Book> getBookCatalog() {
		List<Book> catalogBooks = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(SELECT_ALL_BOOK);
			while (rs.next()) {
				Book book = buildBook(rs);
				catalogBooks.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return catalogBooks;
	}

	@Override
	public void addBook(Book book) {

		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(INSERT_BOOK);
			ps.setString(1, book.getShifrBook());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getShifrAutor());
			ps.setString(4, book.getShifrOwner());
			ps.setString(5, book.getAvialable());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteBookByShifr(String shifrBook) {

		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(DELETE_BOOK_BY_SHIFR);
			ps.setString(1, shifrBook);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateBookOwner(String shifrBook, String shifrUser) {

		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(UPDATE_BOOK_OWNER);
			ps.setString(1, shifrUser);
			ps.setString(2, shifrBook);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private Book buildBook(ResultSet rs) throws SQLException {
		Book book = new Book();
		String shifrBook = rs.getString("shifr_book");
		book.setShifrBook(shifrBook);
		String title = rs.getString("title");
		book.setTitle(title);
		String shifrAutor = rs.getString("shifr_autor");
		book.setShifrAutor(shifrAutor);
		String shifrOwner = rs.getString("shifr_owner");
		book.setShifrOwner(shifrOwner);
		String avialable = rs.getString("avialable");
		book.setAvialable(avialable);
		return book;
	}

}
