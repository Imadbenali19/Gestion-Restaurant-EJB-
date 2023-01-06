package ma.metier;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ma.entites.Restaurant;
import ma.entites.Ville;
import ma.entites.Zone;

@Stateless(name = "ville")
public class VilleEJBImpl implements VilleLocal, VilleRemote {

	@PersistenceContext
	private EntityManager em;
	
	@EJB
	private ZoneLocal service;

	@Override
	public boolean addVille(Ville s) {
		em.persist(s);
		return true;
	}

	@Override
	public boolean delVille(Long sId) {
		List<Zone> r=service.getAllZones();
		for(Zone x: r) {
			if(x.getVille().getId()==sId) {
				x.setVille(null);
			}
		}
		em.remove(em.find(Ville.class, sId));
		return true;
	}

	@Override
	public boolean updateVille(Ville s) {
		Ville su = em.find(Ville.class, s.getId());
		if (su != null) {
			su.setNom(s.getNom());
			return true;
		}
		return false;
	}

	@Override
	public List<Ville> getAllVilles() {
		Query query = em.createQuery("from Ville");
		return query.getResultList();
	}

	

//	@Override
//	public Ville getVille(Long id) {
//		Ville s = em.find(Ville.class, id);
//		
//		if (s == null)
//			throw new RuntimeException("Ville introvable");
//		return s;
//	}

	@Override
	public Ville getVille(String nom) {
		Query query = em.createQuery("select v from Ville v where v.nom=?1",Ville.class);
		query.setParameter(1, nom);
		return (Ville) query.getSingleResult();
	}

	@Override
	public Ville findById(Long id) {
		Ville cm = em.find(Ville.class, id);
		if (cm == null)
			throw new RuntimeException("Ville introvable");
		return cm;
	}

}
