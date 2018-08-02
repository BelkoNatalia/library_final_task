package by.htp.libraryFinalTask.entity;

public class Autor {
	private String name;
	private String surname;
	private String birsdate;
	private String shifrAutor;

	public Autor() {
		super();
	}

	public Autor(String name, String surname, String birsdate, String shifrAutor) {
		super();
		this.name = name;
		this.surname = surname;
		this.birsdate = birsdate;
		this.shifrAutor = shifrAutor;
	}

	public String getBirsdate() {
		return birsdate;
	}

	public void setBirsdate(String birsdate) {
		this.birsdate = birsdate;
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
		return "Autor [name=" + name + ", surname=" + surname + ", birsdate=" + birsdate + ", shifrAutor=" + shifrAutor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birsdate == null) ? 0 : birsdate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((shifrAutor == null) ? 0 : shifrAutor.hashCode());
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
		Autor other = (Autor) obj;
		if (birsdate == null) {
			if (other.birsdate != null)
				return false;
		} else if (!birsdate.equals(other.birsdate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (shifrAutor == null) {
			if (other.shifrAutor != null)
				return false;
		} else if (!shifrAutor.equals(other.shifrAutor))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

}
