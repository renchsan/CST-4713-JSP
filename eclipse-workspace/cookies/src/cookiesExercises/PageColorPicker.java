// Matt Rencher
// CST 4713-JSP
// Exercises: Cookies Exercise 3
// Servlet to show table with default or selected colors
// uses cookies to remember user's selections

package cookiesExercises;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/page-color-picker")
public class PageColorPicker extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    String docType =
  	      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
  	      "Transitional//EN\">\n";
    
    out.println
      (docType +
       "<html>\n" +
       "<head><title>Select Your Page Colors</title></head>\n" +
       "<body>\n" +
       "<h1>Choose Your Foreground And Background Colors</h1>\n" +
       "<FORM ACTION=\"http://localhost/cookies/page-color\" method=\"POST\">" +
	  	 " <CENTER><label for=\"fgColor\">Foreground Color: </label> " +
	  	 " <INPUT TYPE=\"color\" id=\"fgColor\" name=\"fgColor\"><BR><BR> " +
	  	 " <label for=\"bgColor\">Background Color: </label> " +
	  	 " <INPUT TYPE=\"color\" id=\"bgColor\" name=\"bgColor\"><BR><BR> " +
	  	 " <INPUT TYPE=\"SUBMIT\"></CENTER> " +
		"</FORM> " +
		"</BODY></HTML>");
  }
  public void doPost(HttpServletRequest request,
	      HttpServletResponse response)
	      throws ServletException, IOException {
		  	doGet(request, response);
	  	};
}