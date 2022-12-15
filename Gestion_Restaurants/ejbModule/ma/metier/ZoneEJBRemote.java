package ma.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ma.entites.Zone;

@Stateless(name="zone")
public class ZoneEJBRemote implements ZoneLocal,ZoneRemote {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean addZone(Zone z) {
		em.persist(z);
		return true;
	}

	@Override
	public boolean delZone(Long zId) {
		em.remove(em.find(Zone.class, zId));
		return false;
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
		Zone s = em.find(Zone.class, nom);
		if (s == null)
			throw new RuntimeException("Zone introvable");
		return s;
	}

	
}
