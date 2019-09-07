package P1;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	
	private HttpSession session;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String custid = request.getParameter("custid");
		String pwd = request.getParameter("pwd");
		
		session = request.getSession(true);
		
		try {
			Model m = new Model();
			m.setCustid(custid);
			m.setPwd(pwd);
			boolean b =m.login();
			
			if (b==true) {
				session.setAttribute("accno", m.getAccno());
				response.sendRedirect("/BankApp1/Home.html");
			}
			else {
				response.sendRedirect("BankApp1/Error.html");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  
	}


