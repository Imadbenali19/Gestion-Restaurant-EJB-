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
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addSpecialite(Specialite s) {
		service.addSpecialite(s);
	}

	@GET
	@Path("/find/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
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
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam(value = "id") Long c1) {
		service.delSpecialite(c1);
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateSpec(Specialite sep) {
		Specialite s = service.findById(sep.getId());
		if (s != null) {
			s.setNom(sep.getNom());
			service.updateSpecialite(s);
		}

	}
}
