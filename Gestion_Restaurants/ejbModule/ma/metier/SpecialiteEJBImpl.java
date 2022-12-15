package ma.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import ma.entites.Specialite;

@Stateless(name="specialite")
public class SpecialiteEJBImpl implements SpecialiteLocal,SpecialiteRemote {

	@PersistenceContext
	private EntityManager em;

	

	@Override
	public boolean addSpecialite(Specialite s) {
		em.persist(s);
		return true;
	}

	@Override
	public boolean delSpecialite(Long sId) {
		em.remove(em.find(Specialite.class, sId));
		return false;
	}

	@Override
	public boolean updateSpecialite(Specialite s) {
		Specialite su=em.find(Specialite.class, s.getId());
		if(su!=null) {
			su.setNom(s.getNom());
			return true;
		}
		return false;
	}

	@Override
	public List<Specialite> getAllSpecialites() {
		Query query = em.createQuery("from Specialite");
		return query.getResultList();
	}

	@Override
	public Specialite getSpecialite(String nom) {
		Specialite s = em.find(Specialite.class, nom);
		if (s == null)
			throw new RuntimeException("Specialite introvable");
		return s;
	}
}
