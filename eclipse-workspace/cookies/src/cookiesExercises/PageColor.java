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
    String bgColorDefault = "#008080";
    String fgColorDefault = "#000000";
    String foregroundColor = "", backgroundColor = "";
    
    Enumeration<String> paramNames = request.getParameterNames();
    // Enumeration<String> paramNames = request.getParameterNames();
    while(paramNames.hasMoreElements()) {
      String paramName = paramNames.nextElement();
      String[] paramValues =
  	        request.getParameterValues(paramName);
      if (paramName.equals("fgColor")) {
    	  if (paramValues.length == 1) {
//    		  foregroundColor = ServletUtilities.filter(paramValues[0]).trim();
    		  foregroundColor = paramValues[0];
	    	  Cookie fgColorCookie =
	    		        new Cookie("fgColor", foregroundColor);
	    		      fgColorCookie.setMaxAge(60*60*24*365); // 1 year
	    		      response.addCookie(fgColorCookie);
  	      }
      }
      if (paramName.equals("bgColor")) {
    	  if (paramValues.length == 1) {
//    		  backgroundColor = ;
    		  backgroundColor = paramValues[0];
	    	  Cookie bgColorCookie =
	    		        new Cookie("backgroundColor", backgroundColor);
	    		      bgColorCookie.setMaxAge(60*60*24*365); // 1 year
	    		      response.addCookie(bgColorCookie);
  	      }
      }
    }
    
    out.println
      ("<!DOCTYPE html>\n" +
       "<html>\n" +
       "<head><title>Table generated with Loop</title>"+
//       "<style>body{ color: "+ foregroundColor +"  }</style>" +
       "</head>\n" +
       "<body bgcolor="+backgroundColor+">\n" +
       "<h2>Foreground Color Default: "+fgColorDefault+"</h2>\n"+
       "<h2>Background Color Default: "+bgColorDefault+"</h2>\n");

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

}
