package controllers;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ma.entites.Photo;
import ma.entites.Restaurant;
import ma.entites.Serie;
import ma.entites.Ville;
import ma.entites.Zone;
import ma.metier.RestaurantEJBImpl;
import ma.metier.RestaurantLocal;
import ma.metier.SerieLocal;
import ma.metier.ZoneLocal;

@Path("/restau")
@Stateless
public class RestauController {
	@EJB
	private RestaurantLocal service;
	@EJB
	private ZoneLocal zs;
	@EJB
	private SerieLocal ss;

	/*
	 * @POST
	 * 
	 * @Path("/add")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public void addRestau(@FormParam(value
	 * = "nom") String nom ,
	 * 
	 * @FormParam(value = "adresse") String adresse,
	 * 
	 * @FormParam(value = "lat") double lat,
	 * 
	 * @FormParam(value = "lon") double lon,
	 * 
	 * @FormParam(value = "description") String description,
	 * 
	 * @FormParam(value = "open") String date_open,
	 * 
	 * @FormParam(value = "close") String date_close,
	 * 
	 * @FormParam(value = "weekend") boolean weekend,
	 * 
	 * @FormParam(value = "rank") int rank,
	 * 
	 * @FormParam(value = "idZ") long idZ,
	 * 
	 * @FormParam(value = "idS") long idS) {
	 * 
	 * Restaurant r1= new Restaurant(); r1.setAdresse(adresse); r1.setNom(nom);
	 * r1.setLat(lat); r1.setLon(lon); Serie s= ss.findById(idS); r1.setSerie(s);
	 * r1.setDescription(description); r1.setDate_close(date_close);
	 * r1.setDate_open(date_open); r1.setWeekend(weekend); r1.setRank(rank); Zone
	 * z=zs.findById(idZ); r1.setZone(z); service.addRestau(r1); }
	 */
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addRestaurant(Restaurant v) {

		service.addRestau(v);
	}

	@GET
	@Path("/find/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Restaurant getRestau(@PathParam(value = "id") long id) {
		return service.findById(id);
	}

	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Restaurant> listRestaux() {
		return service.getAllRestau();
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam(value = "id") Long c1) {
		service.delRestau(c1);
	}

	@GET
	@Path("/findByZone/{nom}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Restaurant> findByZone(@PathParam(value = "nom") String nom) {
		return service.getRestausInZone(nom);
	}

	@GET
	@Path("/findByVille/{nom}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Restaurant> findByVille(@PathParam(value = "nom") String nom) {
		return service.getRestauInVille(nom);
	}

	@GET
	@Path("/findRestau/{nom}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Restaurant> findByName(@PathParam(value = "nom") String nom) {
		return service.getRestau(nom);
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateR(Restaurant res) {
		Restaurant r = service.findById(res.getId());
		if(r!=null) {
			r.setAdresse(res.getAdresse());
			r.setDate_close(res.getDate_close());
			r.setDate_open(res.getDate_open());
			r.setNom(res.getNom());
			r.setLat(res.getLat());
			r.setLon(res.getLon());
			r.setRank(res.getRank());
			r.setSerie(res.getSerie());
			r.setSpecialites(res.getSpecialites());
			r.setZone(res.getZone());
			r.setDescription(res.getDescription());
			service.updateRestau(r);
		}
	}
	
	@GET
	@Path("/search/{ville}/{zone}/{spec}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Restaurant> searchRestaurants(@PathParam(value = "ville") String ville,@PathParam(value = "zone") String zone,@PathParam(value = "spec") String spec) {
		return service.searchRestaux(ville, zone, spec);
	}
	
	@GET
	@Path("/getPhotos/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Photo> getPhotos(@PathParam(value = "id") Long id) {
		return service.getPhotoOfRestau(id);
	}
}
