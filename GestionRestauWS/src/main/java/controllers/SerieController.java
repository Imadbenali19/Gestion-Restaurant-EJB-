package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ma.entites.Restaurant;
import ma.entites.Serie;
import ma.metier.SerieLocal;

@Path("/serie")
@Stateless
public class SerieController {
      @EJB
      private SerieLocal service;
      
      
    @POST
  	@Path("/add")
  	@Produces(MediaType.APPLICATION_JSON)
    public void addSerie(@FormParam(value = "nom") String nom) {
    	Serie s =new Serie();
    	s.setNom(nom);
    	service.addSerie(s);
    }
    @GET
	@Path("/find/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Serie getSerie(@PathParam(value = "id") long id) {
		return service.findById(id);
	}
    
    @GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Serie> listSeries() {
		return service.getAllSeries();
	}
    @DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@FormParam(value = "id") Long c1) {
		service.delSerie(c1);
	}
    @PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
    public void updateSerie(@FormParam(value = "nom") String nom, @FormParam(value = "id") long id) {
    	Serie s= service.findById(id);
    	s.setNom(nom);
    	service.updateSerie(s);
    }
      
}
