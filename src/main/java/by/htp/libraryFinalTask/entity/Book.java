package by.htp.libraryFinalTask.entity;

public class Book {
	private int shifrBook;
	private String title;
	private String shifrAutor;
	private String shifrOwner;//User
	
	public Book(int shifrBook, String title, String shifrAutor, String shifrOwner) {
		this.shifrBook = shifrBook;
		this.title = title;
		this.shifrAutor = shifrAutor;
		this.shifrOwner = shifrOwner;
	}

	public int getShifrBook() {
		return shifrBook;
	}

	public void setShifrBook(int shifrBook) {
		this.shifrBook = shifrBook;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShifrAutor() {
		return shifrAutor;
	}

	public void setShifrAutor(String shifrAutor) {
		this.shifrAutor = shifrAutor;
	}

	public String getShifrOwner() {
		return shifrOwner;
	}

	public void setShifrOwner(String shifrOwner) {
		this.shifrOwner = shifrOwner;
	}

	@Override
	public String toString() {
		return "Book [shifrBook=" + shifrBook + ", title=" + title + ", shifrAutor=" + shifrAutor + ", shifrOwner=" + shifrOwner + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shifrAutor == null) ? 0 : shifrAutor.hashCode());
		result = prime * result + shifrBook;
		result = prime * result + ((shifrOwner == null) ? 0 : shifrOwner.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book other = (Book) obj;
		if (shifrAutor == null) {
			if (other.shifrAutor != null)
				return false;
		} else if (!shifrAutor.equals(other.shifrAutor))
			return false;
		if (shifrBook != other.shifrBook)
			return false;
		if (shifrOwner == null) {
			if (other.shifrOwner != null)
				return false;
		} else if (!shifrOwner.equals(other.shifrOwner))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
}
