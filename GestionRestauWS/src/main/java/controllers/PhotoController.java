package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ma.entites.Photo;
import ma.entites.Serie;
import ma.metier.PhotoLocal;
import ma.metier.SerieLocal;

@Path("/photo")
@Stateless
public class PhotoController {

	@EJB
	private PhotoLocal service;

	@POST
	@Path("/upload")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addPhoto(Photo p) {
		service.uploadPhoto(p);
	}

	@GET
	@Path("/find/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Photo getPhoto(@PathParam(value = "id") Long id) {
		return service.findById(id);
	}

	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Photo> listPhotos() {
		return service.getAllPhotos();
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam(value = "id") Long c1) {
		service.delPhoto(c1);
	}

}
