package by.htp.libraryFinalTask.dao;

import java.util.List;

import by.htp.libraryFinalTask.entity.Book;


public interface BookDao {
	Book getBookById(int id);

	List<Book> getBookCatalog();

	void addBook(Book book);

	void deleteBookById(int id);

	void updateBookOwner(int idBook, int idUser);

}