package P1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckBalance
 */
public class CheckBalance extends HttpServlet {

	private HttpSession session;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		session = request.getSession();
		int accno = (int) session.getAttribute("accno");
		
		try {
			Model m =new Model();
			m.setAccno(accno);
			boolean b=m.checkBalance();
			
			if (b==true) {
				
				session.setAttribute("name", m.getName());
				session.setAttribute("balance", m.getBalance());
				
				response.sendRedirect("/BankApp1/Balance.jsp");
			}
			else {
				response.sendRedirect("/BankApp1/ErrorBalance.jsp");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

		
	

	
	


