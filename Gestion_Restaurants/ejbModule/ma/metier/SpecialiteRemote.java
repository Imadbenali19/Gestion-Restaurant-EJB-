package ma.metier;

import java.util.List;

import javax.ejb.Remote;

import ma.entites.Specialite;

@Remote
public interface SpecialiteRemote {

	// CRUD Specialite;
	boolean addSpecialite(Specialite s);

	boolean delSpecialite(Long sId);

	boolean updateSpecialite(Specialite s);

	List<Specialite> getAllSpecialites();

	Specialite getSpecialite(String nom);
	
	Specialite findById(Long id);
}
