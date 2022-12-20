package ma.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import ma.entites.Specialite;
import ma.entites.Ville;

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
		return true;
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
		Query query = em.createQuery("select s from Specialite s where s.nom=?1",Specialite.class);
		query.setParameter(1, nom);
		return (Specialite) query.getSingleResult();
	}

	@Override
	public Specialite findById(Long id) {
		Specialite cm = em.find(Specialite.class, id);
		if (cm == null)
			throw new RuntimeException("Specialite introvable");
		return cm;
	}
}
