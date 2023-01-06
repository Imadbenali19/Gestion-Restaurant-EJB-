package controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import ma.entites.Photo;
import ma.entites.Restaurant;
import ma.metier.PhotoLocal;
import ma.metier.RestaurantLocal;

/**
 * Servlet implementation class FileUploadHandler
 */
@WebServlet("/upload")
public class FileUploadHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private final String UPLOAD_DIRECTORY = "D:/up";
	private  String UPLOAD_DIRECTORY;

	@EJB
	private PhotoLocal service;

	@EJB
	private RestaurantLocal serviceRestau;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadHandler() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String name = "";
		String id = null;
		String webUrl=null;
		//UPLOAD_DIRECTORY=getServletContext().getRealPath("/").replace("build\\", "") + "/ressource" + File.separator + "/images";
		UPLOAD_DIRECTORY="D:/Mes Documents/EMSI/CY.ING.INF/5IIR/Architecture Composants d'entreprise/Projet EJB WEB/FrontEnd/public/images";
		
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						name = new File(item.getName()).getName();
						item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
					} else {
						InputStream input = item.getInputStream();
						if (item.getFieldName().equals("Nom")) {
							byte[] str = new byte[input.available()];
							input.read(str);
							id = new String(str, "UTF8");
						}
						if (item.getFieldName().equals("webUrl")) {
                            byte[] str = new byte[input.available()];
                            input.read(str);
                            webUrl = new String(str, "UTF8");
                        }

					}
				}
				// Long id=Long.parseLong(request.getParameter("id"));
				Long idR=Long.parseLong(id);
				Restaurant r= serviceRestau.findById(idR);
				service.uploadPhoto(new Photo(name,webUrl, r));

				// File uploaded successfully
				request.setAttribute("message", "File Uploaded Successfully" + UPLOAD_DIRECTORY);

			} catch (Exception ex) {
				request.setAttribute("message", "File Upload Failed due to " + ex);
			}

		} else {
			request.setAttribute("message", "Sorry this Servlet only handles file upload request");
		}

		request.getRequestDispatcher("/result.jsp").forward(request, response);

	}

}
