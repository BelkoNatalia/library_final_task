package by.htp.libraryFinalTask.entity;

public class Reader {
	private int id;
	private String name;
	private String surname;
	private int libraryTicketNumber;

	public Reader() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getLibraryTicketNumber() {
		return libraryTicketNumber;
	}

	public void setLibraryTicketNumber(int libraryTicketNumber) {
		this.libraryTicketNumber = libraryTicketNumber;
	}

	@Override
	public String toString() {
		return "Reader [id=" + id + ", name=" + name + ", surname=" + surname + ", libraryTicketNumber=" + libraryTicketNumber + "]";
	}

}
