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

import ma.entites.Photo;
import ma.entites.Restaurant;
import ma.metier.PhotoLocal;

/**
 * Servlet implementation class PhotoController
 */
@WebServlet("/PhotoController")
public class PhotoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private PhotoLocal service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		if (request.getParameter("op").equals("load")) {
			response.setContentType("application/json");
			List<Photo> photos = service.getAllPhotos();
			Gson json = new Gson();
			response.getWriter().write(json.toJson(photos));

		}
	}

}
