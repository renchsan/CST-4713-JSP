// Matt Rencher
// JSP Servlet to detect client's browser
// 9/26/2018

package reqheaders;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

import MyUtilities.ServletUtilities;

@WebServlet("/show-headers")
public class showheaders extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Browser Check Browser Using Request Headers";
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
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
	      		out.println("<TR><TD><h2>Firefox</h2>");
	            out.println("    <TD>Best Browser for me!");
	     	} else if (userAgent.toLowerCase().indexOf(chrome.toLowerCase()) != -1 ) {
	     		// System.out.println("CHROME");
	     		out.println("<TR><TD><h2>Chrome</h2>");
	            out.println("    <TD>I like Firefox more.");
	     	} else if (userAgent.toLowerCase().indexOf(ie.toLowerCase()) != -1 ) {
	     		// System.out.println("INTERNET EXPLORER");
	     		out.println("<TR><TD><h2>Internet Explorer</h2>");
	            out.println("    <TD>Best Browser for me!");
	     	} else {
	     		// System.out.println("What the heck browser are you using?");
	     		out.println("<TR><TD><h2>????</h2>");
	            out.println("    <TD>Maybe you're using Eclipse or IDE");
	     	}
    	}
    }
    out.println("</TABLE>\n</BODY></HTML>");
  }

  @Override
  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
