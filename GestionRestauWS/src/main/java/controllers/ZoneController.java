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

import ma.entites.Specialite;
import ma.entites.Ville;
import ma.entites.Zone;
import ma.metier.VilleLocal;
import ma.metier.ZoneLocal;

@Path("/zone")
@Stateless
public class ZoneController {
	@EJB
	private ZoneLocal service;
	@EJB
	private VilleLocal vs;
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public void addZone(@FormParam(value = "nom") String nom, @FormParam(value = "idV") long idV) {
		Zone z = new Zone();
		z.setNom(nom);
		Ville v= vs.findById(idV);
		z.setVille(v);
		service.addZone(z);
	}
	@GET
	@Path("/find/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Zone getZone(@PathParam(value = "id") long id) {
		return service.findById(id);
	}
	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Zone> listSpecialite() {
		return service.getAllZones();
	}
	
	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@FormParam(value = "id") Long c1) {
		service.delZone(c1);
	}
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public void update(@FormParam(value = "nom") String nom, @FormParam(value = "id") long id,@FormParam(value = "idZ") long idZ) {
		Zone z = service.findById(id);
		z.setNom(nom);
		Ville v= vs.findById(idZ);
		z.setVille(v);
		service.updateZone(z);
	}
}
