package controllers;

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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import ma.entites.Specialite;
import ma.entites.Ville;
import ma.metier.SpecialiteLocal;
import ma.metier.VilleLocal;

@Path("/ville")
@Stateless
public class VilleController {
	@EJB
	private VilleLocal service;

	/*
	 * @POST
	 * 
	 * @Path("/add")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public void addVille(@FormParam(value =
	 * "nom") String nom) { Ville v = new Ville(); v.setNom(nom);
	 * service.addVille(v); }
	 */
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addVille(Ville v) {
		service.addVille(v);
	}

	@GET
	@Path("/find/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Ville getVille(@PathParam(value = "id") long id) {
		return service.findById(id);
	}

	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ville> listVille() {
		return service.getAllVilles();
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam(value = "id") Long c1) {
		service.delVille(c1);
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void update(Ville vil) {
		Ville s = service.findById(vil.getId());
		if (s != null) {
			s.setNom(vil.getNom());
			service.updateVille(s);
		}

	}
}
