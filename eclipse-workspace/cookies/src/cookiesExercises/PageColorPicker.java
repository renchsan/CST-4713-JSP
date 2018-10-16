// use Request Headers to add color picker for extra credit

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
       "<FORM ACTION=\"page-color\" method=\"POST\">" +
	  	 " <CENTER><label for=\"fgColor\">Foreground Color: </label> " +
	  	 " <INPUT TYPE=\"color\" id=\"fgColor\"> name=\"fgColor\"><BR><BR> " +
	  	 " <label for=\"bgColor\">Background Color: </label> " +
	  	 " <INPUT TYPE=\"color\" id=\"bgColor\"> name=\"bgColor\"><BR><BR> " +
	  	 " <INPUT TYPE=\"SUBMIT\"></CENTER> " +
		"</FORM> " +
		"</BODY></HTML>");
  }

}