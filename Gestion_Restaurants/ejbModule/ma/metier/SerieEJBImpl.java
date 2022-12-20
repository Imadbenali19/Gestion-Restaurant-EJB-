package ma.metier;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.entites.Restaurant;
import ma.entites.Serie;
import ma.entites.Ville;

@Stateless(name = "serie")
public class SerieEJBImpl implements SerieLocal, SerieRemote {

	@PersistenceContext
	private EntityManager em;

	@EJB
	RestaurantLocal service;
	
	@Override
	public boolean addSerie(Serie s) {
		em.persist(s);
		return true;
	}

	@Override
	public boolean delSerie(Long sId) {
		List<Restaurant> r=service.getAllRestau();
		for(Restaurant x: r) {
			if(x.getSerie().getId()==sId) {
				x.setSerie(null);
			}
		}
		em.remove(em.find(Serie.class, sId));
		return true;
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
		Query query = em.createQuery("select s from Serie s where s.nom=?1",Serie.class);
		query.setParameter(1, nom);
		return (Serie) query.getSingleResult();
	}

	@Override
	public Serie findById(Long id) {
		Serie cm = em.find(Serie.class, id);
		if (cm == null)
			throw new RuntimeException("Serie introvable");
		return cm;
	}

	

}
