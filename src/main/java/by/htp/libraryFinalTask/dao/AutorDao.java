package by.htp.libraryFinalTask.dao;

import by.htp.libraryFinalTask.entity.Autor;

public interface AutorDao {
	Autor getAutorByShifr(String autorShifr);
	void addAutor(Autor autor);

}
