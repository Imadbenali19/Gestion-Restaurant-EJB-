package ma.metier;

import java.util.List;

import javax.ejb.Local;

import ma.entites.Ville;

@Local
public interface VilleLocal {

	// CRUD Villes;
	boolean addVille(Ville s);

	boolean delVille(Long sId);

	boolean updateVille(Ville s);

	List<Ville> getAllVilles();

	Ville getVille(String nom);
	
	Ville findById(Long id);
}
