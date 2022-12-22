package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ma.entites.Photo;
import ma.entites.Restaurant;
import ma.entites.Serie;
import ma.entites.Specialite;
import ma.entites.Ville;
import ma.entites.Zone;
import ma.metier.RestaurantLocal;
import ma.metier.SerieLocal;
import ma.metier.SpecialiteLocal;
import ma.metier.ZoneLocal;

/**
 * Servlet implementation class RestauController
 */
@WebServlet("/RestauController")
public class RestauController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private RestaurantLocal service;

	@EJB
	private ZoneLocal serviceZone;

	@EJB
	private SerieLocal serviceSerie;

	@EJB
	private SpecialiteLocal serviceSpecialite;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RestauController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		/*
		 * if (request.getParameter("op").equals("hello")) {
		 * response.setContentType("text/html");
		 * 
		 * response.getWriter().write(service.getHello()); }
		 * response.setContentType("text/html");
		 * 
		 * response.getWriter().write("hello not");
		 */

		/*
		 * if (request.getParameter("op") == null) { String solde =
		 * request.getParameter("solde"); String dateCreate =
		 * request.getParameter("dateCreation").replace("-", "/"); service.addCompte(new
		 * Compte(Double.parseDouble(solde), new Date(dateCreate))); }
		 */
		/*
		 * response.setContentType("application/json"); List<Restaurant> restaurants =
		 * service.getAllRestau(); Gson json = new Gson();
		 * response.getWriter().write(json.toJson(restaurants));
		 */
		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("load")) {
				response.setContentType("application/json");
				List<Restaurant> restaurants = service.getAllRestau();
				Gson json = new Gson();
				response.getWriter().write(json.toJson(restaurants));

			} else if (request.getParameter("op").equals("delete")) {
				Long id = Long.parseLong(request.getParameter("id"));
				service.delRestau(id);

				response.setContentType("application/json");
				List<Restaurant> restaurants = service.getAllRestau();
				Gson json = new Gson();
				response.getWriter().write(json.toJson(restaurants));

			} else if (request.getParameter("op").equals("update")) {
				boolean w = false;
				Long id = Long.parseLong(request.getParameter("id"));
				Restaurant r = service.findById(id);
				String nom = request.getParameter("nom");
				String description = request.getParameter("description");
				String adresse = request.getParameter("adresse");
				Double lat = Double.parseDouble(request.getParameter("lat"));
				Double lon = Double.parseDouble(request.getParameter("lon"));
				String dateOpen = request.getParameter("dateOpen");
				String dateClose = request.getParameter("dateClose");
				int rank = Integer.parseInt(request.getParameter("rank"));
				String weekend = request.getParameter("weekend");
				if (weekend.equals("true"))
					w = true;
				String zone = request.getParameter("zone");
				Zone z = serviceZone.getZone(zone);

				String serie = request.getParameter("serie");
				Serie s = serviceSerie.getSerie(serie);

				String sp = request.getParameter("specialite");
				String[] spec = sp.split(",");

				List<Specialite> specialites = new ArrayList<Specialite>();
				for (String x : spec) {
					specialites.add(serviceSpecialite.getSpecialite(x));
				}

				r.setNom(nom);
				r.setAdresse(adresse);
				r.setDescription(description);
				r.setDate_open(dateOpen);
				r.setDate_close(dateClose);
				r.setLat(lat);
				r.setLon(lon);
				r.setRank(rank);
				r.setWeekend(w);
				r.setSerie(s);
				r.setZone(z);
				r.setSpecialites(specialites);

				service.updateRestau(r);

				response.setContentType("application/json");
				List<Restaurant> restaurants = service.getAllRestau();
				Gson json = new Gson();
				response.getWriter().write(json.toJson(restaurants));

			} else if (request.getParameter("op").equals("info")) {
				Long id = Long.parseLong(request.getParameter("id"));
				Restaurant r = service.findById(id);
				response.setContentType("application/json");
				Gson json = new Gson();
				response.getWriter().write(json.toJson(r));

			} else if (request.getParameter("op").equals("searchv2")) {

			}
		} else {
			boolean w = false;
			String nom = request.getParameter("nom");
			String description = request.getParameter("description");
			String adresse = request.getParameter("adresse");
			Double lat = Double.parseDouble(request.getParameter("lat"));
			Double lon = Double.parseDouble(request.getParameter("lon"));
			String dateOpen = request.getParameter("dateOpen");
			String dateClose = request.getParameter("dateClose");
			int rank = Integer.parseInt(request.getParameter("rank"));
			String weekend = request.getParameter("weekend");
			if (weekend.equals("true")) {
				w = true;
			}
			String zone = request.getParameter("zone");
			Zone z = serviceZone.getZone(zone);

			String serie = request.getParameter("serie");
			Serie s = serviceSerie.getSerie(serie);

			String sp = request.getParameter("specialite");
			String[] spec = sp.split(",");

			List<Specialite> specialites = new ArrayList<Specialite>();
			for (String x : spec) {
				specialites.add(serviceSpecialite.getSpecialite(x));
			}
			// Date dateAchat = new Date(request.getParameter("dateAchat").replace("-",
			// "/"));
			// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

			// if(service.addRestau(new Restaurant(nom,null, lat,lon,description,new
			// Date(sdf.parse(dateOpen).getTime()) ,new
			// Date(sdf.parse(dateClose).getTime()), w, rank, null, null, null, null))) {

			// }

			service.addRestau(new Restaurant(nom, adresse, lat, lon, description, dateOpen, dateClose, w, rank, z,specialites, s));

			// ms.create(new Machine(reference,marque, new
			// Date(sdf.parse(dateAchat).getTime()),salle, prix));

			// response.sendRedirect("machineAdmin.jsp?message=fait");
			response.setContentType("application/json");
			List<Restaurant> restaurants = service.getAllRestau();
			Gson json = new Gson();
			response.getWriter().write(json.toJson(restaurants));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
