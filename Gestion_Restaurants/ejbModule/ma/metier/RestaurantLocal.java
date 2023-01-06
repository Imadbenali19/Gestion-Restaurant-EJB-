package ma.metier;

import java.util.List;

import javax.ejb.Local;

import ma.entites.Photo;
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

	List<Restaurant> getRestau(String nom);
	
	Restaurant findById(Long id);

	/*boolean addPhotoToRestau(Long rId,List<Photo> photos);

	boolean delPhotoFromRestau(Long rId, Long pId);*/
	
	List<Photo> getPhotoOfRestau(Long rId);
	
	List<Restaurant> getRestausInZone(String nom);
	List<Restaurant> getRestauInVille(String nom);

	List<Restaurant> searchRestaux(String ville, String zone, String specialite);
	

	/////

	List<Zone> getRestausInZone(Long zId);
	
}
