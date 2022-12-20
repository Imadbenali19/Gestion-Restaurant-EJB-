package controllers;


import java.util.List;

import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import ma.metier.RestaurantLocal;

/**
 * Servlet implementation class FileUploadController
 */
@WebServlet("/FileUploadController")
@MultipartConfig
public class FileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private String UPLOAD_DIRECTORY = "D:\\up";
	
	@EJB
	private RestaurantLocal service;
	
	
    public FileUploadController() {
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
		//UPLOAD_DIRECTORY = getServletContext().getRealPath("/").replace("build\\", "") + "ressource" + File.separator + "images";
		
		/* Receive file uploaded to the Servlet from the HTML5 form */
		Part filePart=(Part) request.getPart("file");
	    //Part filePart = request.getPart("file");
		
	    String fileName="";
		try {
			fileName = filePart.getFileName();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    for (javax.servlet.http.Part part : request.getParts()) {
	      part.write("D:/up/" + fileName);
	    }
	    response.getWriter().print("The file uploaded sucessfully.");
    
	}

}
