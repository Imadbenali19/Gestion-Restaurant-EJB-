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

import ma.entites.Serie;
import ma.entites.Specialite;
import ma.entites.Ville;
import ma.metier.SerieLocal;
import ma.metier.VilleLocal;

/**
 * Servlet implementation class VilleController
 */
@WebServlet("/VilleController")
public class VilleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	private VilleLocal service;
	
    public VilleController() {
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
                List<Ville> villes = service.getAllVilles();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(villes));
            	
                
            }else if(request.getParameter("op").equals("delete")) {
            	Long id=Long.parseLong(request.getParameter("id"));
            	service.delVille(id);
            	
            	response.setContentType("application/json");
                List<Ville> villes = service.getAllVilles();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(villes));
                
            }else if(request.getParameter("op").equals("update")) {
            	Long id=Long.parseLong(request.getParameter("id"));
            	String nom = request.getParameter("nom");               
                Ville s=service.findById(id);
                s.setNom(nom);
                
                service.updateVille(s);
               
               
                response.setContentType("application/json");
                List<Ville> villes = service.getAllVilles();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(villes));
            	
                
                
            }else if(request.getParameter("op").equals("searchv1")) {
            	
                
                
            }else if(request.getParameter("op").equals("searchv2")) {
            	
            	
				
                
            }
		}
		else{
			
			String nom = request.getParameter("nom");
			
	        service.addVille(new Ville(nom));
	       
	       
	        //response.sendRedirect("machineAdmin.jsp?message=fait");
	        response.setContentType("application/json");
            List<Ville> villes = service.getAllVilles();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(villes));
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
