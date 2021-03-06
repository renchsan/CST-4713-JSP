// Matthew Rencher
// CST4713
// 9/25/2018

package forms;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import MyUtilities.ServletUtilities;

@WebServlet("/registration-redirect")
public class registration_redirect extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Reading Three Request Parameters";
    String errorMsg = "";
    boolean formFlag = false;
    String param1 = request.getParameter("param1");
    if ((param1 == null) || (param1.trim().equals(""))) {
    	errorMsg += "Please enter a First Name" + "\n";
    	formFlag = true;
    } else {
    	param1 = ServletUtilities.filter(param1);
    }
    String param2 = request.getParameter("param2");
    if ((param2 == null) || (param2.trim().equals(""))) {
//    	param2 = "Last Name";
    	errorMsg += "Please enter a Last Name" + "\n";
    	formFlag = true;
    } else {
    	param2 = ServletUtilities.filter(param2);
    }
    String param3 = request.getParameter("param3");
    if ((param3 == null) || (param3.trim().equals(""))) {
    	errorMsg += "Please enter an Email Address" + "\n";
    	formFlag = true;
    } else {
    	param3 = ServletUtilities.filter(param3);
    }
    
    if(formFlag == true) {
    	// Redisplay the form with error msg, include entered values
    	String docType =
  		      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
  		      "Transitional//EN\">\n";
    	out.println(docType +
  			  "<HTML><HEAD><TITLE>Collecting Name and Email</TITLE></HEAD>" +
  			  "<BODY BGCOLOR=\"#FDF5E6\">" +
  			  "<H1 ALIGN=\"CENTER\">Collecting Name and Email</H1>" +
  			  "<H2 ALIGN=\"CENTER\">ERROR: " + errorMsg + "</H2>" +
  			  "<FORM ACTION=\"registration-redirect\" method=\"POST\">" +
  			  "First Name:  <INPUT TYPE=\"TEXT\" NAME=\"param1\" VALUE="+param1+"><BR>" +
  			  "Last Name: <INPUT TYPE=\"TEXT\" NAME=\"param2\" VALUE="+param2+"><BR>" +
  			  "Email Address:  <INPUT TYPE=\"TEXT\" NAME=\"param3\" VALUE="+param3+"><BR>" +
  			  "<CENTER><INPUT TYPE=\"SUBMIT\"></CENTER>" +
  			  "</FORM>" +
  			  "</BODY></HTML>");
    } else if(formFlag == false) {
    	// Display results page
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
    }}
    
  public void doPost(HttpServletRequest request, HttpServletResponse response)
		  throws ServletException, IOException 
  {doGet(request, response);};
   
	  
}


