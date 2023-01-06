package controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ma.entites.Ville;
import ma.entites.Zone;
import ma.metier.VilleLocal;
import ma.metier.ZoneLocal;

/**
 * Servlet implementation class ZoneController
 */
@WebServlet("/ZoneController")
public class ZoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	private ZoneLocal service;
	@EJB
	private VilleLocal serviceVille;
	
    public ZoneController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if (request.getParameter("op") != null) {
            if (request.getParameter("op").equals("load")) {
                response.setContentType("application/json");
                List<Zone> zones = service.getAllZones();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(zones));
            	
                
            }else if(request.getParameter("op").equals("delete")) {
            	Long id=Long.parseLong(request.getParameter("id"));
            	service.delZone(id);
            	
            	response.setContentType("application/json");
                List<Zone> zones = service.getAllZones();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(zones));
                
            }else if(request.getParameter("op").equals("update")) {
            	Long id=Long.parseLong(request.getParameter("id"));
            	String nom = request.getParameter("nom");
            	String ville=request.getParameter("ville");
            	Ville v=serviceVille.getVille(ville);
                Zone s=service.findById(id);
                s.setNom(nom);
                s.setVille(v);
                
                service.updateZone(s);
               
               
                response.setContentType("application/json");
                List<Zone> zones = service.getAllZones();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(zones));        	
                
            }else if(request.getParameter("op").equals("searchv1")) {
            	
                
                
            }else if(request.getParameter("op").equals("searchv2")) {
            	
            	
				
                
            }
		}
		else{
			
			String nom = request.getParameter("nom");
			String ville=request.getParameter("ville");
	        Ville v=serviceVille.getVille(ville);
	        service.addZone(new Zone(nom,v));
	       
	       
	        //response.sendRedirect("machineAdmin.jsp?message=fait");
	        response.setContentType("application/json");
            List<Zone> zones = service.getAllZones();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(zones));
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
