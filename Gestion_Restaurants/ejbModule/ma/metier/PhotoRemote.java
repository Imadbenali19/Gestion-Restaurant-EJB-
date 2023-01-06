package ma.metier;

import java.util.List;

import javax.ejb.Remote;

import ma.entites.Photo;

@Remote
public interface PhotoRemote {

	boolean uploadPhoto(Photo p);

	boolean delPhoto(Long pId);

	Photo findById(Long id);
	
	List<Photo> getAllPhotos();
}
