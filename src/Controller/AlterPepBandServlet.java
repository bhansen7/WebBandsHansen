package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import Model.PepBand;

/**
 * Servlet implementation class AlterPepBandServlet
 */
@WebServlet("/AlterPepBandServlet")
public class AlterPepBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterPepBandServlet() {
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
		String act = request.getParameter("doThisToBand");
		PepBandHelper dao = new PepBandHelper(); 
		System.out.println("act " + act);
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllPepBandsServlet").forward(request, response);
		}else if (act.equals("Edit Selected Band")) {
				System.out.println("In Edit");
				Integer tempId = Integer.parseInt(request.getParameter("bandId"));
				System.out.println("temp id " + tempId);
				PepBand bandToEdit = dao.searchForBandById(tempId);
				request.setAttribute("bandToEdit", bandToEdit);
				getServletContext().getRequestDispatcher("/editPepBands.jsp").forward(request,response);
		} else if (act.equals("Delete Selected Band")) {
			Integer tempId = Integer.parseInt(request.getParameter("bandId"));
			PepBand bandToDelete = dao.searchForBandById(tempId);
			
			dao.deletePepBand(bandToDelete);

			getServletContext().getRequestDispatcher("/viewAllPepBandsServlet").forward(request, response);
			
		} else if (act.equals("Add New Band")) {
			getServletContext().getRequestDispatcher("/addPepBand.html").forward(request, response);
		}
	}

}
