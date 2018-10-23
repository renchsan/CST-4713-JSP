// Matt Rencher
// CST 4713-JSP
// Shopping Cart using Session

package sessionEx;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

@WebServlet("/shopping-cart")
public class ShoppingCart extends HttpServlet {
  @Override
  public void doGet (HttpServletRequest request,
                      HttpServletResponse response)
      throws ServletException, IOException {
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
      String item = request.getParameter("item");
      if ((item != null) && (!item.trim().equals(""))) {
    	  if (item.equals("Orange")){
    		  orangeQty++;
    		  previousCart.put(123, orangeQty);
    	  } else if (item.equals("Apple")){
    		  appleQty++;
    		  previousCart.put(124, appleQty);
    	  }	else if (item.equals("Banana")){
    		  bananaQty++;
    		  previousCart.put(125, bananaQty);
    	  } else if (item.equals("Grape")){
    		  grapeQty++;
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
      out.println("<TABLE BORDER=1 CELLPADDING=5 CELLSPACING=1>");
      out.print("<tr><th>Item Number</th><th>Item Name</th><th>Item Quantity</th></tr>");
	  out.print("<tr><td>123</td><td>Orange</td><td>" + orangeQty + "</td></tr>");
	  out.print("<tr><td>124</td><td>Apple</td><td>" + appleQty + "</td></tr>");
	  out.print("<tr><td>125</td><td>Banana</td><td>" + bananaQty + "</td></tr>");
	  out.print("<tr><td>126</td><td>Grape</td><td>" + grapeQty + "</td></tr>");
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