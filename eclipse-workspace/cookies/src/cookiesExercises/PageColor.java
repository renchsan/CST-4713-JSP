package cookiesExercises;

import java.io.*;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


@WebServlet("/page-color")
public class PageColor extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String foregroundColor = "#008080", backgroundColor = "#663399";
    
	boolean newbie = true;
    Cookie[] cookies = request.getCookies();
    
    // Check if visitor is repeat visitor
    if (cookies != null) {
      for(Cookie c: cookies) {
        if ((c.getName().equals("repeatVisitor")) &&
            // Could omit test and treat cookie name as a flag
            (c.getValue().equals("yes"))) {
          newbie = false;
        }
        if (c.getName().equals("fgColor")) {
            foregroundColor = c.getValue();
        }
        if (c.getName().equals("bgColor")) {
            backgroundColor = c.getValue();
        }
      }
    }
    // If first time visitor...
    if (newbie) {
      Cookie returnVisitorCookie =
        new Cookie("repeatVisitor", "yes");
      returnVisitorCookie.setMaxAge(60*60*24*365); // 1 year
      response.addCookie(returnVisitorCookie);	      
    } else {
//      title = "Welcome Back";	      
    }
    
    Enumeration<String> paramNames = request.getParameterNames();
    while(paramNames.hasMoreElements()) {
      String paramName = paramNames.nextElement();
      String[] paramValues =
  	        request.getParameterValues(paramName);
      if (paramName.equals("fgColor")) {
    	  if (paramValues.length == 1) {
    		  foregroundColor = paramValues[0];
	    	  Cookie fgColorCookie =
	    		        new Cookie("fgColor", foregroundColor);
	    		      fgColorCookie.setMaxAge(60*60*24*365); // 1 year
	    		      response.addCookie(fgColorCookie);
  	      }
      }
      if (paramName.equals("bgColor")) {
    	  if (paramValues.length == 1) {
    		  backgroundColor = paramValues[0];
	    	  Cookie bgColorCookie =
	    		        new Cookie("bgColor", backgroundColor);
	    		      bgColorCookie.setMaxAge(60*60*24*365); // 1 year
	    		      response.addCookie(bgColorCookie);
  	      }
      }
    }
    
    out.println
      ("<!DOCTYPE html>\n" +
       "<html>\n" +
       "<head><title>Table generated with Loop</title>"+
       "<style>body{color: "+ foregroundColor +"}</style>" +
       "</head>\n" +
       "<body bgcolor="+backgroundColor+">\n" +
       "<h2>Foreground Color: "+ foregroundColor +"</h2>\n"+
       "<h2>Background Color: "+ backgroundColor +"</h2>\n");

     out.println("<table BORDER=1 CELLPADDING=5 CELLSPACING=1>");
     for(int rows = 1; rows <= 15; rows++){
    	 out.println("<tr>");
    	 for (int cols = 1; cols <= 20; cols++){
    		 int rand = (int)(Math.random()*100);
    		 out.print("<td>" + rand + "</td>");
    	 }
       out.println("</tr>");
      }
      out.println("</table>");

      out.println("</body></html>");
  }
  public void doPost(HttpServletRequest request,
	      HttpServletResponse response)
	      throws ServletException, IOException {
		  	doGet(request, response);
	  	};

}
