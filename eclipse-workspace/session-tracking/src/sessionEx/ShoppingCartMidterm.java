// Matt Rencher
// CST 4713-JSP
// Shopping Cart using Session

package sessionEx;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

@WebServlet("/shopping-cart-midterm")
public class ShoppingCartMidterm extends HttpServlet {
  @Override
  public void doGet (HttpServletRequest request,
                      HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    synchronized(session) {
    	@SuppressWarnings("unchecked")
    	
    	// From shopping cart SESSION
//        int orangeQty = 0, appleQty = 0, bananaQty = 0, grapeQty = 0;
    	String[] itemids = {"123","124","125","126"};
	    String[] itemnames = {"Orange","Apple","Banana","Grape"};
//	    ArrayList<String> itemQty = new ArrayList<>(Arrays.asList("0", "0", "0", "0"));
//	    ArrayList<String> itemQty = new ArrayList<String>();
	    ArrayList<String> itemQty = new ArrayList<String>();
	    
    	boolean hasVisitedPageOne = false;
    	boolean newCart = true;
    	
//	    if (request.getParameter("OrderBtn")!=null && !hasVisitedPageOne) {
//	    	Cookie pageOneCookie = new Cookie("Entry", "accessGranted");
//	        pageOneCookie.setMaxAge(60*60*24*365);
//	        response.addCookie(pageOneCookie);
//	        hasVisitedPageOne = true;
//	    }
//
//		Cookie[] cookies = request.getCookies();
//	    if (cookies != null) {
//	    	for(Cookie c: cookies) {
//	    		if ((c.getName().equals("Entry")) && (c.getValue().equals("accessGranted"))) {
//	    			hasVisitedPageOne = true;
//	    			break;
//		        } else {
//		        	response.sendError(403, "Please visit the Product Page first");
//		        }
//	    	}
//		}
    	
	    if(request.getParameter("OrderBtn")!=null && !hasVisitedPageOne) {
	    	Cookie pageOneCookie = new Cookie("visitedPageOne", "yes");
	        pageOneCookie.setMaxAge(60*60*24*365);
	        response.addCookie(pageOneCookie);
	        hasVisitedPageOne = true;
	    }

	    Cookie[] cookies = request.getCookies();
	    
	    if (cookies != null) {
	      for(Cookie c: cookies) {
	        if ((c.getName().equals("visitedPageOne")) && (c.getValue().equals("yes"))) {
	          hasVisitedPageOne = true;
	          break;
	        }
	      }
	    }
		
		ArrayList<String> previousItems = (ArrayList<String>)session.getAttribute("previousItems");
	    
	    if (previousItems == null) {  
	    	// If no previous cart
	    	previousItems = new ArrayList<String>();

//	    	System.out.println("NO PREVIOUS CART");
	    	newCart = true;
	    } else {     
	    	// If there's a previous cart, get those quantities
	    	for(int j=0; j<itemids.length; j++) {
	    		itemQty.add(j, previousItems.get(j));
//	    		System.out.println("itemQty[" + j + "]: "+ itemQty.get(j));
	    	}
//	    	System.out.println("itemQty: " + itemQty);
	    	newCart = false;
	    }
	    
	    String[] qty = request.getParameterValues("Qty");
	    
	    if(newCart) {
	    	// new cart, just add initial quantity values
	    	if (qty != null) {
		    	for(int j=0; j<itemids.length; j++) {
		    		if(!qty[j].isEmpty()) {
		    			previousItems.add(j, qty[j]);
//		    			System.out.println("qty[" + j + "]: "+ qty[j]);
		    		}
		    	}
	    	}
	    } else {
	    	// returning cart, add new quantities to existing quantities
	    	if (qty != null) {
		    	for(int j=0; j<itemids.length; j++) {
		    		if(!qty[j].isEmpty()) {
		    			int total = Integer.parseInt(qty[j]) + Integer.parseInt(previousItems.get(j));
		    			previousItems.set(j, Integer.toString(total));
//		    			System.out.println("qty[" + j + "]: "+ qty[j]);
		    		}
		    	}
	    	}
	    }
	        
	      

	  session.setAttribute("previousItems", previousItems); 
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      
      String title = "Shopping Cart";
      String docType =
        "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
        "Transitional//EN\">\n";
      // Display table of item number, item names, and item quantity
      out.println(docType +
                  "<HTML>\n" +
                  "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                  "<BODY BGCOLOR=\"#FDF5E6\"><CENTER>\n" +
                  "<H1>" + title + "</H1>");
      out.println("<TABLE BORDER=1 CELLPADDING=5 CELLSPACING=1>");
      out.print("<tr><th>Item Number</th><th>Item Name</th><th>Item Quantity</th></tr>");
	  out.print("<tr><td>123</td><td>Orange</td><td>" + previousItems.get(0) + "</td></tr>");
	  out.print("<tr><td>124</td><td>Apple</td><td>" + previousItems.get(1) + "</td></tr>");
	  out.print("<tr><td>125</td><td>Banana</td><td>" + previousItems.get(2) + "</td></tr>");
	  out.print("<tr><td>126</td><td>Grape</td><td>" + previousItems.get(3) + "</td></tr>");
      out.println("</TABLE>");
      // Back to order form link
      out.println("<br><a href=\"#\" onclick=\"history.go(-1)\"> << Back To Product List</a>");
      out.println("</CENTER></BODY></HTML>");

    }
  }
  
  public void doPost(HttpServletRequest request,
	      HttpServletResponse response)
	      throws ServletException, IOException {
		  	doGet(request, response);
	  	};
}