package by.htp.libraryFinalTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import by.htp.libraryFinalTask.dao.AutorDao;
import by.htp.libraryFinalTask.dao.BookDao;
import by.htp.libraryFinalTask.dao.UserDao;
import by.htp.libraryFinalTask.dao.impl.AutorDaoBdImpl;
import by.htp.libraryFinalTask.dao.impl.BookDaoBdImpl;
import by.htp.libraryFinalTask.dao.impl.UserDaoBdImpl;
import by.htp.libraryFinalTask.entity.Autor;
import by.htp.libraryFinalTask.entity.Book;
import by.htp.libraryFinalTask.entity.User;

public class LibraryManager {
	Scanner scaner = new Scanner(System.in);
	BookDao bookDao = new BookDaoBdImpl();
	UserDao userDao = new UserDaoBdImpl();
	AutorDao autorDao = new AutorDaoBdImpl();

	public void showMainMenu() {
		System.out.println("Enter the item number, please.");
		System.out.println("1. You are reader");
		System.out.println("2. You are librarian");
		System.out.println("3. Exit from the program");

		int pointMenu = scaner.nextInt();

		switch (pointMenu) {
		case 1:
			showReaderLoginMenu();
			showOverdueBooks();
			showMainReaderMenu();
			break;
		case 2:
			showLibrarianLoginMenu();
			showMainLibrarianMenu();
			break;

		case 3:
			System.out.println("Exit");
			break;
		default:
			System.out.println("Wrong number");
			System.out.println("Please repeat choose item number!");
			showMainMenu();

		}

	}

	private void showOverdueBooks() {
		System.out.println("--showOverdueBooks will be implemented");
	}

	private void showMainLibrarianMenu() {
		System.out.println("Enter the item number, please.");
		System.out.println("1. Add reader");
		System.out.println("2. Add new book");
		System.out.println("3. Give away book");
		System.out.println("4. Take away book");
		System.out.println("5. Show report about readers with overdue");
		System.out.println("6. Show report about books have been read");
		System.out.println("7. Show report about readers who read at least two books");
		System.out.println("8. Exit");

		int pointMenu = scaner.nextInt();

		switch (pointMenu) {
		case 1:
			addReader();
			showMainLibrarianMenu();
			break;
		case 2:
			addNewBook();
			showMainLibrarianMenu();
			break;
		case 3:
			giveAwayBook();
			showMainLibrarianMenu();
			break;
		case 4:
			takeAwayBook();
			showMainLibrarianMenu();
			break;
		case 5:
			showReportReadersOverdue();
			showMainLibrarianMenu();
			break;
		case 6:
			showReportBooksHaveBeenRead();
			showMainLibrarianMenu();
			break;
		case 7:
			showReportReadersReadMoreTwoBooks();
			showMainLibrarianMenu();
			break;

		case 8:
			showMainMenu();
			break;
		default:
			System.out.println("Wrong number");
			System.out.println("Please repeat choose item number!");
			showMainMenu();

		}

	}

	private void showReportReadersReadMoreTwoBooks() {
		System.out.println("--showReportReadersReadMoreTwoBooks will be implemented");
	}

	private void showReportBooksHaveBeenRead() {
		System.out.println("--showReportBooksHaveBeenRead will be implemented");
	}

	private void showReportReadersOverdue() {
		System.out.println("--showReportReadersOverdue will be implemented");
	}

	private void takeAwayBook() {
		System.out.println("Input shifr of book");
		String shifrBook = scaner.next();
		Book book = new Book();
		book = bookDao.getBookByShifr(shifrBook);
		book.setShifrOwner("");
		book.setAvialable("yes");
		bookDao.updateBook(book);

	}

	private void giveAwayBook() {
		System.out.println("Input shifr of book");
		String shifrBook = scaner.next();
		Book book = new Book();
		book = bookDao.getBookByShifr(shifrBook);

		if (book.getAvialable().equals("yes")) {
			System.out.println("Input shifr of owner");
			String shifrOwner = scaner.next();
			book.setAvialable("no");
			book.setShifrOwner(shifrOwner);
			bookDao.updateBook(book);

			User user = new User();
			user = userDao.getUserByShifr(shifrOwner);
			int numbersBooks = user.getNumbersBooks();
			numbersBooks++;
			userDao.updateNumbersBooksByShifrUser(numbersBooks, shifrOwner);

		}

	}

	private void addNewBook() {
		System.out.println("Input shifr of book");
		String shifrBook = scaner.next();
		System.out.println("Input title of book");
		String titleBook = scaner.next();
		System.out.println("Input name autor of book");
		String nameAutor = scaner.next();
		System.out.println("Input surname autor of book");
		String surnameAutor = scaner.next();
		System.out.println("Input birthdate of autor (use format:dd-mm-yyyy");
		String birthdateAutor = scaner.next();
		System.out.println("Input shifr of autor");
		String shifrAutor = scaner.next();
		Book book = new Book(shifrBook, titleBook, shifrAutor, "", "yes");

		bookDao.addBook(book);
		
		Autor autor = new Autor();
		autor = autorDao.getAutorByShifr(shifrAutor);
		if(autor == null) {
			Autor newAutor = new Autor(nameAutor, surnameAutor, birthdateAutor, shifrAutor);
			autorDao.addAutor(newAutor);
		}

		System.out.println("Book was added");
	}

	private void addReader() {
		System.out.println("Input shifr of user");
		String shifrUser = scaner.next();
		System.out.println("Input name of user");
		String name = scaner.next();
		System.out.println("Input surname  of user");
		String surname = scaner.next();
		System.out.println("Input role of user");
		String roleUser = scaner.next();
		System.out.println("Input password of user");
		String passwordUser = scaner.next();

		User user = new User(0, roleUser, name, surname, passwordUser, shifrUser);

		userDao.addUser(user);

		System.out.println("User was added");

	}

	public void showReaderLoginMenu() {
		System.out.println("Enter the libraryTicketNumber");
		String libraryTicketNumber = scaner.next();

		System.out.println("Enter the readerPassword");
		String readerPassword = scaner.next();

	}

	private void showMainReaderMenu() {
		System.out.println("1.View books catalog");
		System.out.println("2.Search  book by id");
		System.out.println("3.Exit");
		int pointMenu = scaner.nextInt();

		switch (pointMenu) {
		case 1:
			showBooksCatalog();
			break;
		case 2:
			showBookById();
			break;
		case 3:
			showMainMenu();
			break;
		default:
			System.out.println("Wrong number");
			System.out.println("Please repeat choose item number!");
			showMainReaderMenu();

		}

	}

	private Book showBookById() {
		System.out.println("Input books shifr");
		String shifrBook = scaner.next();
		Book book = null;
		book = bookDao.getBookByShifr(shifrBook);
		System.out.println(book);
		showMainReaderMenu();

		return book;
	}

	private void showBooksCatalog() {
		List<Book> catalogBooks = new ArrayList<>();
		catalogBooks = bookDao.getBookCatalog();
		for (int i = 0; i < catalogBooks.size(); i++) {
			System.out.println(catalogBooks.get(i));
		}
		showMainReaderMenu();
	}

	public void showLibrarianLoginMenu() {
		System.out.println("Enter the login");
		int libraryTicketNumber = scaner.nextInt();

		System.out.println("Enter the password");
		int librarianPassword = scaner.nextInt();
	}

}
