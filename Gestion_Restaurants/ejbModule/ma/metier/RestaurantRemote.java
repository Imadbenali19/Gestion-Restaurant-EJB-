package ma.metier;

import java.util.List;

import javax.ejb.Remote;

import ma.entites.Restaurant;
import ma.entites.Serie;
import ma.entites.Specialite;
import ma.entites.Ville;
import ma.entites.Zone;

@Remote
public interface RestaurantRemote {

	String getHello();

	// CRUD Restau;
	boolean addRestau(Restaurant r);

	boolean delRestau(Long rId);

	boolean updateRestau(Restaurant r);

	List<Restaurant> getAllRestau();

	Restaurant getRestau(String nom);

	boolean addPhotoToRestau(Long rId);

	boolean delPhotoFromRestau(Long rId, Long pId);

	

	
	////
	List<Zone> getRestausInZone(Long zId);

	

	

	
}
