package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

/**
 * Servlet implementation class AlterCompetitionServlet
 */
@WebServlet("/AlterCompetitionServlet")
public class AlterCompetitionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterCompetitionServlet() {
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
		String act = request.getParameter("doThisToCompetition"); 
		System.out.println("act " + act);
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewCompetitionListServlet").forward(request, response);
			
		} else if (act.equals("Add Band to Competition")) {
			getServletContext().getRequestDispatcher("/addCompetition.html").forward(request, response);
		}
	}

}
