package ma.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.entites.Photo;
import ma.entites.Serie;

@Stateless(name = "Photo")
public class PhotoEJBImpl implements PhotoLocal,PhotoRemote {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public boolean uploadPhoto(Photo p) {
		em.persist(p);
		return true;
	}

	@Override
	public boolean delPhoto(Long pId) {
		em.remove(em.find(Photo.class, pId));
		return true;
	}

	@Override
	public List<Photo> getAllPhotos() {
		Query query = em.createQuery("from Photo");
		return query.getResultList();
	}

	@Override
	public Photo findById(Long id) {
		Photo cm = em.find(Photo.class, id);
		if (cm == null)
			throw new RuntimeException("Photo introvable");
		return cm;
	}

}
