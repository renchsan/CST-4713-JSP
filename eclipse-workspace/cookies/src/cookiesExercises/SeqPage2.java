
// Exercise 1
package cookiesExercises;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import MyUtilities.ServletUtilities;

@WebServlet("/seq-pg-2")
public class SeqPage2 extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
//    Cookie cookie = new Cookie("Entry",
//                        "accessGranted");
//    // Cookie is valid for an hour, regardless of whether
//    // user quits browser, reboots computer, or whatever.
//    cookie.setMaxAge(3600);
//    response.addCookie(cookie);
    
    
    Cookie[] cookies = request.getCookies();
    if (cookies == null) {
//      out.println("No cookies");
    	response.sendRedirect("http://localhost/cookies/seq-pg-1");
    } else {
    	for(Cookie cookie: cookies) {
            String cookieName = cookie.getName();
            String cookieValue = cookie.getValue();
            
            if (cookieName.equals("Entry") && cookieValue.equals("accessGranted")) {
            	response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                String docType =
                   "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
                   "Transitional//EN\">\n";
                
            	// ACCESS GRANTED PAGE /////////////////
            	String title = "ACCESS GRANTED";
                out.println(docType +
                            "<HTML>\n" +
                            "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                            "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                            "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                            "<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
                            "<TR BGCOLOR=\"#FFAD00\">\n" +
                            "  <TH>Cookie Name\n" +
                            "  <TH>Cookie Value" +
                			"<TR><TH COLSPAN=2>" +
                			"<TR>\n" +
                			"  <TD>" + cookies[0].getName() + "\n" +
                			"  <TD>" + cookies[0].getValue());
                out.println("</TABLE></BODY></HTML>");
              } else {
            	// ACCESS DENIED - No cookie from page 1 ////////////////
            	response.sendRedirect("http://localhost/cookies/seq-pg-1");
              }
        }
    }
    

    }
    
    
  
//  public void doPost(HttpServletRequest request,
//      HttpServletResponse response)
//      throws ServletException, IOException {
//	  	doGet(request, response);
//  	};
}
