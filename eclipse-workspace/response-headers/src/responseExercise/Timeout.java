// Matt Rencher
// CST 4713-JSP
// Exercises: HTTP Response Headers #4
// Detect browser, IE or Firefox
// Redirect IE users to microsoft.com after 10 sec
// Firefox users redirect to mozilla.org after 10 sec

package responseExercise;
import java.io.*;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import MyUtilities.ServletUtilities;
@WebServlet("/timeout")

public class Timeout extends HttpServlet {
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String title = "IE/Firefox browser redirect";
	    String docType =
	      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	      "Transitional//EN\">\n";
	    out.println(docType +
	                "<HTML>\n" +
	                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
	                "<BODY>\n" +
	                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
	                "<TABLE BORDER=1 ALIGN=\"CENTER\">\n");
	    
	    // Flags found in browsers user-agent
	    String firefox  = "firefox";
	    String chrome  = "chrome";
	    String ie  = "wow64";
	    String userAgent = "";
	    Enumeration<String> headerNames = request.getHeaderNames();
	    while(headerNames.hasMoreElements()) {
	    	String headerName = headerNames.nextElement();
	    	// System.out.println(headerName);
	    	if(headerName.contentEquals("user-agent")) {
	    		userAgent = ServletUtilities.filter(request.getHeader(headerName));
	    		userAgent = userAgent.trim();
	    		
		      	if (userAgent.toLowerCase().indexOf(firefox.toLowerCase()) != -1 ) {
		      		// System.out.println("FIREFOX");
		      		out.println("<h2>Redirecting to http://www.mozilla.org in 10 seconds</h2>");
		      		response.setHeader("Refresh", "10; URL=http://www.mozilla.org");
		      		
		     	} else if (userAgent.toLowerCase().indexOf(chrome.toLowerCase()) != -1 ) {
		     		// System.out.println("CHROME");

		     	} else if (userAgent.toLowerCase().indexOf(ie.toLowerCase()) != -1 ) {
		     		// System.out.println("INTERNET EXPLORER");
		     		out.println("<h2>Redirecting to http://www.microsoft.com in 10 seconds</h2>");
		      		response.setHeader("Refresh", "10; URL=http://www.microsoft.com");
		     	} else {
		     		// System.out.println("What the heck browser are you using?");

		     	}
	    	}
	    }
	    out.println("</TABLE>\n</BODY></HTML>");
	}
	
}