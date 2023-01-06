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
import ma.metier.SpecialiteLocal;

/**
 * Servlet implementation class SpecialiteController
 */
@WebServlet("/SpecialiteController")
public class SpecialiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	private SpecialiteLocal service;
	
    public SpecialiteController() {
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
                List<Specialite> specialites = service.getAllSpecialites();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(specialites));
            	
                
            }else if(request.getParameter("op").equals("delete")) {
            	Long id=Long.parseLong(request.getParameter("id"));
            	service.delSpecialite(id);
            	
            	response.setContentType("application/json");
                List<Specialite> specialites = service.getAllSpecialites();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(specialites));
                
            }else if(request.getParameter("op").equals("update")) {
            	Long id=Long.parseLong(request.getParameter("id"));
            	String nom = request.getParameter("nom");               
                Specialite s=service.findById(id);
                s.setNom(nom);
                
                service.updateSpecialite(s);
               
               
                response.setContentType("application/json");
                List<Specialite> specialites = service.getAllSpecialites();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(specialites));
            	
                
                
            }else if(request.getParameter("op").equals("searchv2")) {
            	
            	
				
                
            }
		}
		else{
			
			String nom = request.getParameter("nom");
			
	        service.addSpecialite(new Specialite(nom));
	       
	       
	        //response.sendRedirect("machineAdmin.jsp?message=fait");
	        response.setContentType("application/json");
            List<Specialite> specialites = service.getAllSpecialites();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(specialites));
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
