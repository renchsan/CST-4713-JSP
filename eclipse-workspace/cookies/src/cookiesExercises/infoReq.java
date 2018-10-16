package cookiesExercises;

import java.io.*;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import MyUtilities.ServletUtilities;

@WebServlet("/info-req")
public class infoReq extends HttpServlet {
	@Override
	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	      throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String title = "Reading Three Request Parameters with Cookies";
	    String docType =
	  	      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	  	      "Transitional//EN\">\n";
		
		String param1 = "";
	    String param2 = "";
		String param3 = "";
		
		// Check for form submission
		boolean submit = false;
		Enumeration<String> paramNames = request.getParameterNames();
		if(!paramNames.hasMoreElements()) {
			submit = false;
		} else {
			submit = true;
		    // Enumeration<String> paramNames = request.getParameterNames();
		    while(paramNames.hasMoreElements()) {
		      String paramName = paramNames.nextElement();
		      String[] paramValues =
		  	        request.getParameterValues(paramName);
		      if (paramName.equals("fname")) {
		    	  if (paramValues.length == 1) {
		    		  param1 = ServletUtilities.filter(paramValues[0]).trim();
			    	  Cookie fnameCookie =
			    		        new Cookie("fname", param1);
			    		      fnameCookie.setMaxAge(60*60*24*365); // 1 year
			    		      response.addCookie(fnameCookie);
		  	      } else {
			    	  param1 = "Unknown";
			      }
		      }
		      if (paramName.equals("lname")) {
		    	  if (paramValues.length == 1) {
			  	      param2 = ServletUtilities.filter(paramValues[0]).trim();
			    	  Cookie lnameCookie =
			    		        new Cookie("lname", param2);
			    		      lnameCookie.setMaxAge(60*60*24*365); // 1 year
			    		      response.addCookie(lnameCookie);
			      } else if (paramValues.length == 0) {
			    	  param2 = "Unknown";
			      }
			  }
		      if (paramName.equals("email")) {
		    	  if (paramValues.length == 1) {
		    		  param3 = ServletUtilities.filter(paramValues[0]).trim();
			    	  Cookie emailCookie =
			    		        new Cookie("email", param3);
			    		      emailCookie.setMaxAge(60*60*24*365); // 1 year
			    		      response.addCookie(emailCookie);		    		  
			      } else {
			    	  param3 = "Unknown";
			      } 
			  }	  
		    }
		}

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
	        if (c.getName().equals("fname")) {
	            param1 = c.getValue();
	        }
	        if (c.getName().equals("lname")) {
	            param2 = c.getValue();
	        }
	        if (c.getName().equals("email")) {
	            param3 = c.getValue();
	        }
	      }
	    }
	    
	    // If first time visitor...
	    if (newbie) {
	      Cookie returnVisitorCookie =
	        new Cookie("repeatVisitor", "yes");
	      returnVisitorCookie.setMaxAge(60*60*24*365); // 1 year
	      response.addCookie(returnVisitorCookie);
	      title = "Welcome Aboard";	      
	    } else {
	      title = "Welcome Back";	      
	    }
	    
//	    Debug Inputs
//		out.println("Param 1: " + param1);
//		out.println("Param 2: " + param2);
//		out.println("Param 3: " + param3);
		
		// Show Form or Display
		if(!submit) {
			out.println(docType +
			"<HTML><HEAD><TITLE>Collecting Name and Email</TITLE></HEAD>"+
			"<BODY BGCOLOR=\"#FDF5E6\">"+
			"<H1 ALIGN=\"CENTER\">Collecting Name and Email</H1>" +
			"<FORM ACTION=\"\" method=\"POST\">" +
			 " <label for=\"fname\">First Name: </label> " +
			 " <INPUT TYPE=\"TEXT\" id=\"fname\" NAME=\"fname\" PLACEHOLDER="+param1+"><BR> " +
			 " <label for=\"lname\">Last Name: </label> " +
			 " <INPUT TYPE=\"TEXT\" id=\"lname\" NAME=\"lname\" PLACEHOLDER="+param2+"><BR> " +
			 " <label for=\"email\">Email Address: </label> " +
			 " <INPUT TYPE=\"TEXT\" id=\"email\" NAME=\"email\" PLACEHOLDER="+param3+"><BR> " +
			 " <CENTER><INPUT TYPE=\"SUBMIT\"></CENTER> " +
			"</FORM> " +
			"</BODY></HTML>");
		} else {
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
	  }

	  public void doPost(HttpServletRequest request,
		      HttpServletResponse response)
		      throws ServletException, IOException {
			  	doGet(request, response);
		  	};
}
