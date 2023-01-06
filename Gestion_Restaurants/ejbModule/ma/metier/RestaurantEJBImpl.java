package ma.metier;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.entites.Photo;
import ma.entites.Restaurant;
import ma.entites.Serie;
import ma.entites.Specialite;
import ma.entites.Ville;
import ma.entites.Zone;

@Stateless(name = "Restau")
public class RestaurantEJBImpl implements RestaurantLocal, RestaurantRemote {

	@PersistenceContext
	private EntityManager em;
	
	@EJB
	PhotoLocal service;
	
	@Override
	public String getHello() {
		// TODO Auto-generated method stub
		return "Hello from restau ejbImpl";
	}

	@Override
	public boolean addRestau(Restaurant r) {
		em.persist(r);
		return true;
	}

	@Override
	public boolean delRestau(Long rId) {
//		Query query = em.createNativeQuery("delete from restaurant_specialite r where r.restaurant_id=?1");
//		query.setParameter(1, rId);
//		query.executeUpdate();
		List<Photo> r=service.getAllPhotos();
		for(Photo x: r) {
			if(x.getRestaurant().getId()==rId) {
				service.delPhoto(x.getId());
			}
		}
		em.remove(em.find(Restaurant.class, rId));
		return true;
	}

	@Override
	public boolean updateRestau(Restaurant r) {
		Restaurant ru=em.find(Restaurant.class, r.getId());
		if(ru!=null) {
			ru.setLat(r.getLat());
			ru.setLon(r.getLon());
			ru.setAdresse(r.getAdresse());
			ru.setDate_close(r.getDate_close());
			ru.setDate_open(r.getDate_open());
			ru.setWeekend(r.isWeekend());
			ru.setDescription(r.getDescription());
			ru.setNom(r.getNom());
			ru.setRank(r.getRank());
			ru.setZone(r.getZone());
			ru.setSerie(r.getSerie());
			ru.setSpecialites(r.getSpecialites());
			return true;
		}
		return false;
	}

	@Override
	public List<Restaurant> getAllRestau() {
		Query query = em.createQuery("from Restaurant");
		return query.getResultList();
	}

	@Override
	public List<Restaurant> getRestau(String nom) {
		Query query = em.createQuery("select r from Restaurant r where r.nom like :nom",Restaurant.class);
		query.setParameter("nom","%"+nom+"%");
		return query.getResultList();
	}
	

	@Override
	public List<Zone> getRestausInZone(Long zId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant findById(Long id) {
		Restaurant cm = em.find(Restaurant.class, id);
		if (cm == null)
			throw new RuntimeException("Restau introvable");
		return cm;
	}
	
	@Override
	public List<Restaurant> getRestausInZone(String nom) {
		Query query = em.createQuery("select r from Restaurant r where r.zone.nom like ?1",Restaurant.class);
		query.setParameter(1, nom);
		return (List<Restaurant>) query.getResultList();
		
	}

	@Override
	public List<Restaurant> getRestauInVille(String nom) {
		Query query = em.createQuery("select r from Restaurant r where r.zone.ville.nom like ?1",Restaurant.class);
		query.setParameter(1, nom);
		return (List<Restaurant>) query.getResultList();
	
	}

	@Override
	public List<Photo> getPhotoOfRestau(Long rId) {
		Query query = em.createQuery("select p from Photo p where p.restaurant.id=?1");
		query.setParameter(1, rId);
		return (List<Photo>) query.getResultList();
	}
	
	public Specialite getSpecialiteByNom(String nom) {
		Query query = em.createQuery("select s from Specialite s where s.nom like ?1",Specialite.class);
		query.setParameter(1, nom);
		return (Specialite) query.getSingleResult();
	}
	
	@Override
	public List<Restaurant> searchRestaux(String ville, String zone, String specialite) {
		Specialite s = getSpecialiteByNom(specialite);
		Query query = em.createQuery("select r from Restaurant r where r.zone.ville.nom like concat('%', ?1, '%') AND r.zone.nom like concat('%', ?2, '%') AND ?3 in elements(r.specialites)",Restaurant.class);
		query.setParameter(1, ville);
		query.setParameter(2, zone);
		query.setParameter(3, s);
		return (List<Restaurant>) query.getResultList();
	}

	
}
