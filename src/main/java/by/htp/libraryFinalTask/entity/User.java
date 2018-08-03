package by.htp.libraryFinalTask.entity;

public class User {
	private int numbersBooks;
	private String role;
	private String name;
	private String surname;
	private String password;
	private String shifrUser;
	
	public User() {
	}

	public User(int numbersBooks, String role, String name, String surname, String password, String shifrUser) {
		this.numbersBooks = numbersBooks;
		this.role = role;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.shifrUser = shifrUser;
	}

	public int getNumbersBooks() {
		return numbersBooks;
	}

	public void setNumbersBooks(int numbersBooks) {
		this.numbersBooks = numbersBooks;
	}

	public String getShifrUser() {
		return shifrUser;
	}

	public void setShifrUser(String shifrUser) {
		this.shifrUser = shifrUser;
	}

	public int getId() {
		return numbersBooks;
	}

	public void setId(int id) {
		this.numbersBooks = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [numbersBooks=" + numbersBooks + ", role=" + role + ", name=" + name + ", surname=" + surname + ", password=" + password + ", shifrUser=" + shifrUser + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numbersBooks;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((shifrUser == null) ? 0 : shifrUser.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numbersBooks != other.numbersBooks)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (shifrUser == null) {
			if (other.shifrUser != null)
				return false;
		} else if (!shifrUser.equals(other.shifrUser))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}


	

}
