package P1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangePwd
 */
public class ChangePwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session=request.getSession();
		
		int accno = (int) session.getAttribute("accno");
		
		
		String pwd = request.getParameter("npwd");
		try {
			Model m = new Model();
			m.setPwd(pwd);
			m.setAccno(accno);
			boolean b = m.changePwd();
			
			if(b==true) {
				response.sendRedirect("/BankApp1/ChangeSuccess.html");
			}
			else {
				response.sendRedirect("/BankApp1/ChangeFail.html");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
