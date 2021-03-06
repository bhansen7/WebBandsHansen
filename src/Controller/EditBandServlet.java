package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Bands;
 

/**
 * Servlet implementation class EditBandServlet
 */
@WebServlet("/EditBandServlet")
public class EditBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBandServlet() {
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
		BandsHelper dao = new BandsHelper();
		
		String bandName = request.getParameter("name of band"); 
		String locationOfBand = request.getParameter("location of band"); 
		Integer tempId = Integer.parseInt(request.getParameter("bandId"));
		String numberOfMembersStr = request.getParameter("number of members");
		Integer levelOfBand = Integer.parseInt(request.getParameter("level of band"));
		
		 try { 
		        Integer.parseInt(numberOfMembersStr); 
		    } catch(NumberFormatException e) { 
		    	getServletContext().getRequestDispatcher("/BandNumericError.jsp").forward(request, response);
		    } catch(NullPointerException e) {
		    	getServletContext().getRequestDispatcher("/BandNumericError.jsp").forward(request, response);
		    }
		Integer numberOfMembers = Integer.parseInt(request.getParameter("number of members"));
		Bands itemToUpdate = dao.searchForBandById(tempId);
		itemToUpdate.setNameOfBand(bandName);
		itemToUpdate.setLocationOfBand(locationOfBand);
		itemToUpdate.setNumberOfMembers(numberOfMembers);
		itemToUpdate.setLevelBandId(levelOfBand);
		itemToUpdate.setCostOfParticipation(numberOfMembers, levelOfBand);
		
		
		dao.updateBands(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllBandsServlet").forward(request, response);
	}

}
