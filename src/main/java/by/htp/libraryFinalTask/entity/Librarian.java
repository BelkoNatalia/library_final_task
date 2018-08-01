package by.htp.libraryFinalTask.entity;

public class Librarian {
	private int id;
	private String name;
	private String surname;
	
	public Librarian() {
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

	@Override
	public String toString() {
		return "Librarian [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}
}
