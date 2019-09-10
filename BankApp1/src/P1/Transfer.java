package P1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Transfer
 */
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String acc = request.getParameter("accno1");
		Integer i = Integer.parseInt(acc);
		int accno1 = i.intValue();
		
		session = request.getSession();
		
		
		String bal = request.getParameter("amount");
		Integer i1 = Integer.parseInt(bal);
		int amount = i1.intValue();
		
		session = request.getSession();
		
		int accno =(int) session.getAttribute("accno");
				
				try {
					Model m = new Model();
					m.setAccno(accno);
					m.setAccno1(accno1);
					m.setBalance(amount);
					boolean b = m.transfer();
					if(b==true) {
						response.sendRedirect("/BankApp1/TransferSuccess.html");
					}
					else {
						response.sendRedirect("/BankApp1/TransferFailed.html");
					}
				}
				catch (Exception e){
					e.printStackTrace();
				}
		
	}

}
