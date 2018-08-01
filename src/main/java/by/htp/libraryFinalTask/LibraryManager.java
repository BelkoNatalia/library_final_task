package by.htp.libraryFinalTask;

import java.util.Scanner;

public class LibraryManager {
	Scanner scaner = new Scanner(System.in);

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
		System.out.println("--takeAwayBook will be implemented");
	}

	private void giveAwayBook() {
		System.out.println("--giveAwayBook will be implemented");
	}

	private void addNewBook() {
		System.out.println("--addNewBook will be implemented");
	}

	private void addReader() {
		System.out.println("--addReader will be implemented");
		
	}

	public void showReaderLoginMenu() {
		System.out.println("Enter the libraryTicketNumber");
		int libraryTicketNumber = scaner.nextInt();

		System.out.println("Enter the readerPassword");
		int readerPassword = scaner.nextInt();
		
		
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

	private void showBookById() {
		System.out.println("--showBookById will be implemented");
		showMainReaderMenu();

	}

	private void showBooksCatalog() {
		
		System.out.println("--showBooksCatalog will be implemented");
		showMainReaderMenu();
	}

	public void showLibrarianLoginMenu() {
		System.out.println("Enter the login");
		int libraryTicketNumber = scaner.nextInt();

		System.out.println("Enter the password");
		int librarianPassword = scaner.nextInt();
	}

}
