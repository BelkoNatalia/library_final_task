package by.htp.libraryFinalTask.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.htp.libraryFinalTask.dao.AutorDao;
import by.htp.libraryFinalTask.entity.Autor;

public class AutorDaoCollectionImpl implements AutorDao{
	
	private List<Autor> autorsList= new ArrayList <Autor>();

	@Override
	public Autor getAutorByShifr(String autorShifr) {
		for (int i = 0; i<autorsList.size(); i++) {
			if (autorsList.get(i).getShifrAutor().equals(autorShifr)) {
				Autor autor = autorsList.get(i);
				return autor;
			}
		}
		return null;
		
	}

	@Override
	public void addAutor(Autor autor) {
		autorsList.add(autor);
	}

}
