package ma.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ma.entites.Ville;

@Stateless(name = "ville")
public class VilleEJBImpl implements VilleLocal, VilleRemote {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean addVille(Ville s) {
		em.persist(s);
		return true;
	}

	@Override
	public boolean delVille(Long sId) {
		em.remove(em.find(Ville.class, sId));
		return false;
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

	@Override
	public Ville getVille(String nom) {
		Ville s = em.find(Ville.class, nom);
		if (s == null)
			throw new RuntimeException("Ville introvable");
		return s;
	}

}
