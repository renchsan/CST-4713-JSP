// Matt Rencher
// CST 4713-JSP
// Exercises: Cookies Exercise 1
// Redirect users who visit page 2, without visiting page 1
// Using cookies

package cookiesExercises;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import MyUtilities.ServletUtilities;

@WebServlet("/seq-pg-1")
public class SeqPage1 extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String docType =
       "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
       "Transitional//EN\">\n";
    
    Cookie cookie = new Cookie("Entry",
                        "accessGranted");
    // Cookie is valid for an hour, regardless of whether
    // user quits browser, reboots computer, or whatever.
    cookie.setMaxAge(3600);
    response.addCookie(cookie);
    
    
    String title = "Landing Page";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<H2 ALIGN=\"CENTER\"> Thank you for visiting the landing page" + 
                "<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
                "<TR BGCOLOR=\"#FFAD00\">\n" +
                "  <TH>Cookie Name\n" +
                "  <TH>Cookie Value");
    
    Cookie[] cookies = request.getCookies();
    if (cookies == null) {
      out.println("<TR><TH COLSPAN=2>No cookies");
    } else {
	    out.println
	      ("<TR>\n" +
	       "  <TD>" + cookie.getName() + "\n" +
	       "  <TD>" + cookie.getValue());
    
    }
    out.println("</TABLE>");
    out.println("<A HREF=\"http://localhost/cookies/seq-pg-2\">Continue to the website</A>" + 
    "</BODY></HTML>");
  }
  
  public void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
	  	doGet(request, response);
  	};
}
