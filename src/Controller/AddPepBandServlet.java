package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import Model.PepBand;

/**
 * Servlet implementation class AddPepBandServlet
 */
@WebServlet("/AddPepBandServlet")
public class AddPepBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPepBandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nameOfBand = request.getParameter("name of band");
		String numberOfMembersStr = request.getParameter("number of members"); 
		String locationOfBand = request.getParameter("location of band");
		String levelBandIdStr = request.getParameter("level of band"); 
		String eventIdStr = request.getParameter("Event Id");  
		
		try { 
	        Integer.parseInt(numberOfMembersStr); 
	    } catch(NumberFormatException e) { 
	    	getServletContext().getRequestDispatcher("/PepBandNumericError.jsp").forward(request, response);
	    } catch(NullPointerException e) {
	    	getServletContext().getRequestDispatcher("/PepBandNumericError.jsp").forward(request, response);
	    }
		int numberOfMembers = Integer.valueOf(numberOfMembersStr);
		int levelBandId = Integer.valueOf(levelBandIdStr);
		
		int eventId = Integer.valueOf(eventIdStr); 
		
		System.out.println("#Members " + numberOfMembers);
		System.out.println("EventId " + eventId);
		
 
		PepBand li = new PepBand(numberOfMembers, nameOfBand, locationOfBand, levelBandId, eventId);
		PepBandHelper dao = new PepBandHelper();
		dao.insertPepBand(li);

		getServletContext().getRequestDispatcher("/addPepBand.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
