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
@WebServlet("/AlterBandServlet")
public class AlterBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterBandServlet() {
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
		BandsHelper dao = new BandsHelper(); 
		System.out.println("act " + act);
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllBandsServlet").forward(request, response);
		}else if (act.equals("Edit Selected Band")) {
				System.out.println("In Edit");
				Integer tempId = Integer.parseInt(request.getParameter("bandId"));
				System.out.println("temp id " + tempId);
				Bands bandToEdit = dao.searchForBandById(tempId);
				request.setAttribute("bandToEdit", bandToEdit);
				getServletContext().getRequestDispatcher("/editBands.jsp").forward(request,response);
		} else if (act.equals("Delete Selected Band")) {
			Integer tempId = Integer.parseInt(request.getParameter("bandId"));
			Bands bandToDelete = dao.searchForBandById(tempId);
			
			dao.deleteBands(bandToDelete);

			getServletContext().getRequestDispatcher("/viewAllBandsServlet").forward(request, response);
			
		} else if (act.equals("Add New Band")) {
			getServletContext().getRequestDispatcher("/addBand.html").forward(request, response);
		}
	}

}
