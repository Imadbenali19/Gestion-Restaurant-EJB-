package ma.metier;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.*;

import ma.entites.Restaurant;
import ma.entites.Ville;
import ma.entites.Zone;

@Stateless(name="zone")
public class ZoneEJBRemote implements ZoneLocal,ZoneRemote {

	@PersistenceContext
	private EntityManager em;
	
	@EJB
	private RestaurantLocal service;
	
	@Override
	public boolean addZone(Zone z) {
		em.persist(z);
		return true;
	}

	@Override
	public boolean delZone(Long zId) {
		List<Restaurant> r=service.getAllRestau();
		for(Restaurant x: r) {
			if(x.getZone().getId()==zId) {
				x.setSerie(null);
			}
		}
		em.remove(em.find(Zone.class, zId));
		return true;
	}

	@Override
	public boolean updateZone(Zone z) {
		Zone su=em.find(Zone.class, z.getId());
		if(su!=null) {
			su.setNom(z.getNom());
			su.setVille(z.getVille());
			return true;
		}
		return false;
	}

	@Override
	public List<Zone> getAllZones() {
		Query query = em.createQuery("from Zone");
		return query.getResultList();
	}

	@Override
	public Zone getZone(String nom) {
		Query query = em.createQuery("select z from Zone z where z.nom=?1",Zone.class);
		query.setParameter(1, nom);
		return (Zone) query.getSingleResult();
	}

	@Override
	public Zone findById(Long id) {
		Zone cm = em.find(Zone.class, id);
		if (cm == null)
			throw new RuntimeException("Zone introvable");
		return cm;
	}

	
}
