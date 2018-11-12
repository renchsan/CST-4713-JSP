package midterm;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

@WebServlet("/shopping-cart")
public class ShoppingCartFinal extends HttpServlet {
  @Override
  public void doGet (HttpServletRequest request,
                      HttpServletResponse response)
      throws ServletException, IOException {

		boolean hasVisitedPageOne = false;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
		  for(Cookie c: cookies) {
		    if ((c.getName().equals("visitedPageOne")) && (c.getValue().equals("yes"))) {
		      hasVisitedPageOne = true;
		      break;
		    }
		  }
		}
		  //check if it is coming from productList.html page or not
		if (request.getParameterValues("Qty") == null)
		{	  
				if (!hasVisitedPageOne) {
					response.sendError(HttpServletResponse.SC_NOT_FOUND,
			                "You must visit Product List page first.");		
				}
		}
		else
		{
			  if (!hasVisitedPageOne) {
		  		Cookie pageOneCookie = new Cookie("visitedPageOne", "yes");
			    pageOneCookie.setMaxAge(60*60*24*365);		
			    response.addCookie(pageOneCookie);
			  }
		}
		
	HttpSession session = request.getSession();
	synchronized(session) {
	      @SuppressWarnings("unchecked")
	      
	      int orangeQty = 0, appleQty = 0, bananaQty = 0, grapeQty = 0;
	      
	      Map<Integer, Integer> previousCart = (HashMap<Integer, Integer>)session.getAttribute("previousCart");
	      if (previousCart == null) {
	    	  previousCart = new HashMap<Integer, Integer>();
	        previousCart.put(123, 0);
	        previousCart.put(124, 0);
	        previousCart.put(125, 0);
	        previousCart.put(126, 0);
	      } 
	  
	      if (!previousCart.get(123).equals(0)) {
	    	  orangeQty = previousCart.get(123);
	    	  previousCart.put(123, orangeQty);
	      }
	      if (!previousCart.get(124).equals(0)) {
	    	  appleQty = previousCart.get(124);
	    	  previousCart.put(124, appleQty);
	      }
	      if (!previousCart.get(125).equals(0)) {
	    	  bananaQty = previousCart.get(125);
	    	  previousCart.put(125, bananaQty);
	      }
	      if (!previousCart.get(126).equals(0)) {
	    	  grapeQty = previousCart.get(126);
	    	  previousCart.put(126, grapeQty);
	      }
	   
	      // Check which button was pushed, add to fruit quantity
	      if (request.getParameterValues("Qty") != null)
	      {  
		      //String item = request.getParameter("item");
		      String[] qtyValues = request.getParameterValues("Qty");
		      if ((qtyValues[0] != null) && (!qtyValues[0].trim().equals(""))) {
		//Orange
		    		  orangeQty = orangeQty + Integer.parseInt(qtyValues[0]);
		    		  previousCart.put(123, orangeQty);
		      } 
		      if ((qtyValues[1] != null) && (!qtyValues[1].trim().equals(""))) {
		//Apple
		    		  appleQty = appleQty + Integer.parseInt(qtyValues[1]);
		    		  previousCart.put(124, appleQty);
		      }	
		      if ((qtyValues[2] != null) && (!qtyValues[2].trim().equals(""))) {
		    	  //Banana
		    		  bananaQty = bananaQty + Integer.parseInt(qtyValues[2]);
		    		  previousCart.put(125, bananaQty);
		      } 
		      if ((qtyValues[3] != null) && (!qtyValues[3].trim().equals(""))) {
		    		  grapeQty = grapeQty + Integer.parseInt(qtyValues[3]);
		    		  previousCart.put(126, grapeQty);
		      }
	      }

	      session.setAttribute("previousCart", previousCart);
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
	      out.println("<FORM ACTION='exportExcel' METHOD='POST'>");
	      out.println("<TABLE BORDER=1 CELLPADDING=5 CELLSPACING=1>");
	      out.print("<tr><th>Item Number</th><th>Item Name</th><th>Item Quantity</th></tr>");
		  out.print("<tr><td>123</td><td>Orange</td><td>" + orangeQty + "</td></tr>");
		  out.print("<tr><td>124</td><td>Apple</td><td>" + appleQty + "</td></tr>");
		  out.print("<tr><td>125</td><td>Banana</td><td>" + bananaQty + "</td></tr>");
		  out.print("<tr><td>126</td><td>Grape</td><td>" + grapeQty + "</td></tr>");
	      out.println("</TABLE>");
	      // Back to order form link
	      out.println("<br><a href=\"productList.html\" > << Back To Product List</a>");
	      out.println("<br><br><BUTTON TYPE='SUBMIT' NAME='ExportBtn' VALUE='ExportBtn' size=150>Export to Excel</BUTTON>");
	      out.println("</FORM></CENTER></BODY></HTML>");
    	}// end of synchronized
  }
  
  public void doPost(HttpServletRequest request,
	      HttpServletResponse response)
	      throws ServletException, IOException {
		  	doGet(request, response);
	  	};
}