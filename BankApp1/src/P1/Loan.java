package P1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Loan
 */
public class Loan extends HttpServlet {
	private HttpSession session;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		int accno = (int) session.getAttribute("accno");
		
		
		try {
			Model m = new Model();
			m.setAccno(accno);
			boolean b=m.applyLoan();
			if(b==true) {
				session.setAttribute("name", m.getName());
				session.setAttribute("email", m.getEmail());
				
				response.sendRedirect("/BankApp1/LoanSuccess.jsp");
			}
			else {
				response.sendRedirect("/BankApp1/LoanFailed.html");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
