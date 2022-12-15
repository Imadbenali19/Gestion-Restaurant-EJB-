package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import ma.entites.Zone;
import ma.metier.RestaurantLocal;

/**
 * Servlet implementation class RestauController
 */
@WebServlet("/RestauController")
public class RestauController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@EJB
	private RestaurantLocal service;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestauController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/*if (request.getParameter("op").equals("hello")) {
			response.setContentType("text/html");
			
			response.getWriter().write(service.getHello());
		}
		response.setContentType("text/html");
		
		response.getWriter().write("hello not");*/
		
		/*if (request.getParameter("op") == null) {
			String solde = request.getParameter("solde");
			String dateCreate = request.getParameter("dateCreation").replace("-", "/");
			service.addCompte(new Compte(Double.parseDouble(solde), new Date(dateCreate)));
		}*/
		/*response.setContentType("application/json");
		List<Restaurant> restaurants = service.getAllRestau();
		Gson json = new Gson();
		response.getWriter().write(json.toJson(restaurants));*/
		if (request.getParameter("op") != null) {
            if (request.getParameter("op").equals("load")) {
                response.setContentType("application/json");
                List<Restaurant> restaurants = service.getAllRestau();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(restaurants));
            	
                
            }else if(request.getParameter("op").equals("delete")) {
            	
                
            }else if(request.getParameter("op").equals("update")) {
            	
            	
                
            }else if(request.getParameter("op").equals("searchv1")) {
            	
                
                
            }else if(request.getParameter("op").equals("searchv2")) {
            	
            	
				
                
            }
		}
		else{
			boolean w=false;
			String nom = request.getParameter("nom");
			String description = request.getParameter("description");
			
	        Double lat = Double.parseDouble(request.getParameter("lat"));
	        Double lon = Double.parseDouble(request.getParameter("lon"));
	        String dateOpen = request.getParameter("dateOpen");
	        String dateClose = request.getParameter("dateClose");
	        int rank=Integer.parseInt(request.getParameter("rank"));
	        String weekend=request.getParameter("weekend");
	        if(weekend.equals("true")) {
	        	w=true;
	        }
	        //Date dateAchat = new Date(request.getParameter("dateAchat").replace("-", "/"));
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	        	
	        	//if(service.addRestau(new Restaurant(nom,null, lat,lon,description,new Date(sdf.parse(dateOpen).getTime()) ,new Date(sdf.parse(dateClose).getTime()), w, rank, null, null, null, null))) {
	        		
	        	//}
	        	service.addRestau(new Restaurant(nom,null,lat,lon,description,dateOpen,dateClose,w,rank,null,null,null,null));
	       
	        
	        	
				//ms.create(new Machine(reference,marque, new Date(sdf.parse(dateAchat).getTime()),salle, prix));
			
	       
	        //response.sendRedirect("machineAdmin.jsp?message=fait");
	        response.setContentType("application/json");
            List<Restaurant> restaurants = service.getAllRestau();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(restaurants));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
