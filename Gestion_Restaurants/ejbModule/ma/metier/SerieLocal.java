package ma.metier;

import java.util.List;

import javax.ejb.Local;

import ma.entites.Restaurant;
import ma.entites.Serie;

@Local
public interface SerieLocal {

	// CRUD Serie;
	boolean addSerie(Serie s);

	boolean delSerie(Long sId);

	boolean updateSerie(Serie s);

	List<Serie> getAllSeries();

	Serie getSerie(String nom);
	
	Serie findById(Long id);
}
