package ma.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.entites.Restaurant;
import ma.entites.Serie;
import ma.entites.Specialite;
import ma.entites.Ville;
import ma.entites.Zone;

@Stateless(name = "Restau")
public class RestaurantEJBImpl implements RestaurantLocal, RestaurantRemote {

	@PersistenceContext
	private EntityManager em;
	
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
		em.remove(em.find(Restaurant.class, rId));
		return false;
	}

	@Override
	public boolean updateRestau(Restaurant r) {
		Restaurant ru=em.find(Restaurant.class, r.getId());
		if(ru!=null) {
			ru.setLat(r.getLat());
			ru.setLon(r.getLon());
			ru.setAdress(r.getAdress());
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
	public Restaurant getRestau(String nom) {
		Query query = em.createQuery("select r from Restaurant r where r.nom=?1",Restaurant.class);
		query.setParameter(1, nom);
		return (Restaurant) query.getSingleResult();
	}

	@Override
	public boolean addPhotoToRestau(Long rId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delPhotoFromRestau(Long rId, Long pId) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public List<Zone> getRestausInZone(Long zId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
