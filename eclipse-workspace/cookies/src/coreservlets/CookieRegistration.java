// Matthew Rencher
// CST4713
// 9/25/2018

package coreservlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import MyUtilities.ServletUtilities;

@WebServlet("/send-cookie")
public class CookieRegistration extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Reading Three Request Parameters";
    String param1 = request.getParameter("param1");
    if ((param1 == null) || (param1.trim().equals(""))) {
    	param1 = "First Name";
    } else {
    	param1 = ServletUtilities.filter(param1);
    }
    String param2 = request.getParameter("param2");
    if ((param2 == null) || (param2.trim().equals(""))) {
    	param2 = "Last Name";
    } else {
    	param2 = ServletUtilities.filter(param2);
    }
    String param3 = request.getParameter("param3");
    if ((param3 == null) || (param3.trim().equals(""))) {
    	param3 = "Email";
    } else {
    	param3 = ServletUtilities.filter(param3);
    }
    
    // send cookie to client
    Cookie c = new Cookie("firstName", param1);
    c.setMaxAge(60*60*24*7);
    response.addCookie(c);
    
    
    // read client cookies
    String cookieName = "userID";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
    	for(Cookie cookie: cookies) {
    		if (cookieName.equals(cookie.getName())) {
    			doSomethingWith(cookie.getValue());
    		}
    	}
    }

    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<UL>\n" +
                "  <LI><B>First Name</B>: "
                + param1 + "\n" +
                "  <LI><B>Last Name</B>: "
                + param2 + "\n" +
                "  <LI><B>Email</B>: "
                + param3 + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");
  }
  public void doPost(HttpServletRequest request,
	      HttpServletResponse response)
	      throws ServletException, IOException {
		  	doGet(request, response);
  		};
}
