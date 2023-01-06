package ma.metier;

import java.util.List;

import javax.ejb.Local;

import ma.entites.Photo;

@Local
public interface PhotoLocal {

	boolean uploadPhoto(Photo p);

	boolean delPhoto(Long pId);
	
	Photo findById(Long id);

	List<Photo> getAllPhotos();

}
