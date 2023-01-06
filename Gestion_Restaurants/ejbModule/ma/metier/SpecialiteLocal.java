package ma.metier;

import java.util.List;

import javax.ejb.Local;

import ma.entites.Specialite;

@Local
public interface SpecialiteLocal {

	// CRUD Specialite;
	boolean addSpecialite(Specialite s);

	boolean delSpecialite(Long sId);

	boolean updateSpecialite(Specialite s);

	List<Specialite> getAllSpecialites();

	Specialite getSpecialite(String nom);
	
	Specialite findById(Long id);
}
