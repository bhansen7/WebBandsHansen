package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import Model.PepBand;

/**
 * Servlet implementation class EditPepBandServlet
 */
@WebServlet("/EditPepBandServlet")
public class EditPepBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPepBandServlet() {
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
		PepBandHelper dao = new PepBandHelper();
		
		String bandName = request.getParameter("name of band"); 
		String locationOfBand = request.getParameter("location of band"); 
		String eventIdStr = request.getParameter("Event Id");
		
		Integer tempId = Integer.parseInt(request.getParameter("bandId"));
		Integer eventId = Integer.parseInt(eventIdStr);
		
		PepBand itemToUpdate = dao.searchForBandById(tempId);
		itemToUpdate.setNameOfBand(bandName);
		itemToUpdate.setLocationOfBand(locationOfBand);
		itemToUpdate.setEventId(eventId);
		
		dao.updateBands(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllPepBandsServlet").forward(request, response);
	}
	
}
