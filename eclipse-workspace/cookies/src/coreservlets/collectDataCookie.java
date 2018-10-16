// Matthew Rencher
// CST4713

package coreservlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import MyUtilities.ServletUtilities;

@WebServlet("/collectDataCookie")
public class collectDataCookie extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String docType =
       "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
       "Transitional//EN\">\n";
    
    for(int i=0; i<3; i++) {
        // Default maxAge is -1, indicating cookie
        // applies only to current browsing session.
        Cookie cookie = new Cookie("Session-Cookie-" + i,
                                   "Cookie-Value-S" + i);
        response.addCookie(cookie);
        cookie = new Cookie("Persistent-Cookie-" + i,
                            "Cookie-Value-P" + i);
        // Cookie is valid for an hour, regardless of whether
        // user quits browser, reboots computer, or whatever.
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
      }
    
    String title = "Active Cookies";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
                "<TR BGCOLOR=\"#FFAD00\">\n" +
                "  <TH>Cookie Name\n" +
                "  <TH>Cookie Value");
    Cookie[] cookies = request.getCookies();
    if (cookies == null) {
      out.println("<TR><TH COLSPAN=2>No cookies");
    } else {
      for(Cookie cookie: cookies) {
        out.println
          ("<TR>\n" +
           "  <TD>" + cookie.getName() + "\n" +
           "  <TD>" + cookie.getValue());
      }
    }
    out.println("</TABLE></BODY></HTML>");
  }
  
  public void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
	  	doGet(request, response);
  	};
}
