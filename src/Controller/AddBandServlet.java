package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Bands; 

/**
 * Servlet implementation class AddBandServlet
 */
@WebServlet("/AddBandServlet")
public class AddBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBandServlet() {
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
		String nameOfBand = request.getParameter("name of band");
		String numberOfMembersStr = request.getParameter("number of members"); 
		String locationOfBand = request.getParameter("location of band");
		String levelBandIdStr = request.getParameter("level of band"); 
		
		int numberOfMembers = Integer.valueOf(numberOfMembersStr);
		int levelBandId = Integer.valueOf(levelBandIdStr);
 
		Bands li = new Bands(numberOfMembers, nameOfBand, locationOfBand, levelBandId);
		BandsHelper dao = new BandsHelper();
		dao.insertBands(li);

		getServletContext().getRequestDispatcher("/addBand.html").forward(request, response);
	}

}
