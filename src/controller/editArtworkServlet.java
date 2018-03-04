package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artwork;


/**
 * Servlet implementation class editArtworkServlet
 */
@WebServlet("/editArtworkServlet")
public class editArtworkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editArtworkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArtworkHelper dao = new ArtworkHelper();
		String radioSelection = request.getParameter("id");
		
		if(radioSelection == null) {
			System.out.println("empty");
			getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
			
		}else {
		
		String title = request.getParameter("title");
		String artist = request.getParameter("artist_name");
		String media = request.getParameter("media");
		String year = request.getParameter("year");
		Double value = Double.parseDouble(request.getParameter("value"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Artwork itemToUpdate = dao.searchForArtworkById(tempId);
		itemToUpdate.setTitle(title);
		itemToUpdate.setArtist_name(artist);
		itemToUpdate.setMedia(media);
		itemToUpdate.setYear(year);
		itemToUpdate.setValue(value);
		
		
		dao.updateArtwork(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
		}
	}

}
