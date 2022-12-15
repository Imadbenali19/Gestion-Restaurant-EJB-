package ma.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.entites.Restaurant;
import ma.entites.Serie;

@Stateless(name = "serie")
public class SerieEJBImpl implements SerieLocal, SerieRemote {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean addSerie(Serie s) {
		em.persist(s);
		return true;
	}

	@Override
	public boolean delSerie(Long sId) {
		em.remove(em.find(Serie.class, sId));
		return false;
	}

	@Override
	public boolean updateSerie(Serie s) {
		Serie su=em.find(Serie.class, s.getId());
		if(su!=null) {
			su.setNom(s.getNom());
			return true;
		}
		return false;
	}

	@Override
	public List<Serie> getAllSeries() {
		Query query = em.createQuery("from Serie");
		return query.getResultList();
	}

	@Override
	public Serie getSerie(String nom) {
		Serie s = em.find(Serie.class, nom);
		if (s == null)
			throw new RuntimeException("Serie introvable");
		return s;
	}

}
