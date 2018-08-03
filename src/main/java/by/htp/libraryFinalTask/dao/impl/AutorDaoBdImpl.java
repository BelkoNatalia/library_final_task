package by.htp.libraryFinalTask.dao.impl;

import static by.htp.libraryFinalTask.dao.utils.MySqlPropertyManager.getLogin;
import static by.htp.libraryFinalTask.dao.utils.MySqlPropertyManager.getPass;
import static by.htp.libraryFinalTask.dao.utils.MySqlPropertyManager.getUrl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.libraryFinalTask.dao.AutorDao;
import by.htp.libraryFinalTask.entity.Autor;

public class AutorDaoBdImpl implements AutorDao{
	private static final String INSERT_AUTOR = "INSERT INTO autors(shifr_autor, name_autor, surname_autor, birthdate_autor) VALUES (?, ?, ?, ?)";
	private static final String SELECT_AUTOR_BY_SHIFR = "SELECT * FROM autors WHERE shifr_autor = ?";
	
	@Override
	public Autor getAutorByShifr(String autorShifr) {
		Autor autor = null;

		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {

			PreparedStatement ps = conn.prepareStatement(SELECT_AUTOR_BY_SHIFR);
			ps.setString(1, autorShifr);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				autor = new Autor();
				String shifrAutor = rs.getString("shifr_autor");
				autor.setShifrAutor(shifrAutor);
				String nameAutor = rs.getString("name_autor");
				autor.setName(nameAutor);
				String surnameAutor = rs.getString("surname_autor");
				autor.setSurname(surnameAutor);
				String birthdateAutor = rs.getString("birthdate_autor");
				autor.setBirsdate(birthdateAutor);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return autor;
		
	}

	@Override
	public void addAutor(Autor autor) {
		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(INSERT_AUTOR);
			ps.setString(1, autor.getShifrAutor());
			ps.setString(2, autor.getName());
			ps.setString(3, autor.getSurname());
			ps.setString(4, autor.getBirsdate());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
