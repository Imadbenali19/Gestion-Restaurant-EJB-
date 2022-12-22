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

import ma.entites.Serie;
import ma.entites.Specialite;
import ma.metier.SpecialiteLocal;

@Path("/specialite")
@Stateless
public class SpecialiteController {
	@EJB
	private SpecialiteLocal service;

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public void addSpecialite(@FormParam(value = "nom") String nom) {
		Specialite s = new Specialite();
		s.setNom(nom);
		service.addSpecialite(s);
	}

	@GET
	@Path("/find/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Specialite getSpec(@PathParam(value = "id") long id) {
		return service.findById(id);
	}

	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Specialite> listSpecialite() {
		return service.getAllSpecialites();
	}

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@FormParam(value = "id") Long c1) {
		service.delSpecialite(c1);
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public void updateSpec(@FormParam(value = "nom") String nom, @FormParam(value = "id") long id) {
		Specialite s = service.findById(id);
		s.setNom(nom);
		service.updateSpecialite(s);
	}
}
