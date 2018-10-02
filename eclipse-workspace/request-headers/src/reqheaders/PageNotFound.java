// Niaz Morshed
// Matt Rencher
// CST 4713-JSP
// JSP Servlet, returns 404 error page if "java" isn't entered in form
// 10/1/2018

package reqheaders;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/page-not-found")
public class PageNotFound extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("This won't be seen if sendError() is called");
			String lang = request.getParameter("lang");
		    if (lang.equals("java"))
		    		{
	        	response.sendRedirect("https://docs.oracle.com/javase/tutorial/");
		    }
	                else {
	                	response.sendError(404,"Page not found");

		}
	}
}