package by.htp.libraryFinalTask.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.htp.libraryFinalTask.dao.BookDao;
import by.htp.libraryFinalTask.entity.Book;

public class BookDaoCollectionImpl implements BookDao {

	private List<Book> bookList = new ArrayList<>();

	@Override
	public Book getBookByShifr(String shifrBook) {
		for (int i = 0; i < bookList.size(); i++) {
			Book book = bookList.get(i);
			if (book.getShifrBook().equals(shifrBook)) {
				return book;
			}
		}
		return null;
	}

	@Override
	public List<Book> getBookCatalog() {
		
		return bookList;
	}

	@Override
	public void addBook(Book book) {
		bookList.add(book);		
	}

	@Override
	public void deleteBookByShifr(String shifrBook) {
		for (int i = 0; i < bookList.size(); i++) {
			Book book = bookList.get(i);
			if (book.getShifrBook().equals(shifrBook)) {
				bookList.remove(i);
			}
		}

	}
	@Override
	public void updateBook(Book book) {
		String shifrBook = book.getShifrBook();
		for (int i = 0; i < bookList.size(); i++) {
			Book b = bookList.get(i);
			if (b.getShifrBook().equals(shifrBook)) {
				bookList.set(i, book);
			}
		}

	}

}
