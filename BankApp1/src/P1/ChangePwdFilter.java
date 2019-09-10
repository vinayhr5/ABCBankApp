package P1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  


/**
 * Servlet Filter implementation class ChangePwdFilter
 */
public class ChangePwdFilter implements Filter {

  
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		String npwd=request.getParameter("npwd");
		String cpwd=request.getParameter("cpwd");
		
		
		if(npwd.equals(cpwd)) {
			chain.doFilter(request, response);
		}
		
		else {
			((HttpServletResponse) response).sendRedirect("/BankApp1/ErrorChange.html");
		}
	}

	

}
