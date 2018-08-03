package by.htp.libraryFinalTask.dao;

import java.util.List;

import by.htp.libraryFinalTask.entity.Book;


public interface BookDao {
	Book getBookByShifr(String shifrBook);

	List<Book> getBookCatalog();

	void addBook(Book book);

	void deleteBookByShifr(String shifrBook);

	void updateBook(Book book);

}