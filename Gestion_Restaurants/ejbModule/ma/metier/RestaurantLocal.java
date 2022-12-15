package ma.metier;

import java.util.List;

import javax.ejb.Local;

import ma.entites.Restaurant;
import ma.entites.Serie;
import ma.entites.Specialite;
import ma.entites.Ville;
import ma.entites.Zone;

@Local
public interface RestaurantLocal {

	String getHello();

	// CRUD Restau;
	boolean addRestau(Restaurant r);

	boolean delRestau(Long rId);

	boolean updateRestau(Restaurant r);

	List<Restaurant> getAllRestau();

	Restaurant getRestau(String nom);

	boolean addPhotoToRestau(Long rId);

	boolean delPhotoFromRestau(Long rId, Long pId);

	

	/////

	List<Zone> getRestausInZone(Long zId);
	
}
