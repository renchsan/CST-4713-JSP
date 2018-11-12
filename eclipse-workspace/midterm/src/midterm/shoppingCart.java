package midterm;

//Matt Rencher
//CST 4713-JSP
//Midterm

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.util.*;

@WebServlet("/shop-cart")
public class shoppingCart extends HttpServlet {
@Override
public void doGet (HttpServletRequest request,
                   HttpServletResponse response)
   throws ServletException, IOException {
 HttpSession session = request.getSession();
 synchronized(session) {
   @SuppressWarnings("unchecked")
   boolean newbie = true;
   Cookie[] cookies = request.getCookies();
   if (cookies != null) {
     for(Cookie c: cookies) {
       if ((c.getName().equals("repeatVisitor")) &&
           // Could omit test and treat cookie name as a flag
           (c.getValue().equals("yes"))) {
         newbie = false;
         break;
       }
     }
   }
   if (newbie) {
     Cookie returnVisitorCookie =
       new Cookie("repeatVisitor", "yes");
     returnVisitorCookie.setMaxAge(60*60*24*365); // 1 year
     response.addCookie(returnVisitorCookie);
     
     // redirect to productlist
     // You Must Visit Product List First
   } else {
     // returning user, display page
	      
   }
   
   
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   
   Enumeration<String> parameterNames = request.getParameterNames();
//   Array<String> previousCart = (ArrayList<String>)session.getAttribute("previousCart");
   ArrayList<String> previousCart = (ArrayList<String>)session.getAttribute("previousCart");
   
   while (parameterNames.hasMoreElements()) {
	   String paramName = parameterNames.nextElement();
	   out.write(paramName);
	   out.write("n");
	   
	   String[] paramValues = request.getParameterValues(paramName);
	   for (int i = 0; i < paramValues.length; i++) {
		   if (!paramValues[i].isEmpty()) {
//			   String paramValue = paramValues[i];
			   previousCart.add(paramValues[i]);
//			   out.write("t" + paramValue);
//			   out.write("n");
		   }
	   }
   }
   out.print(previousCart);
   
//   Array<String> previousCart = (Array<String>)session.getAttribute("previousCart");
//   
//   if (previousCart == null) {
//       previousCart = new Array<String>();
//   } else {
//	   Array<String> currentCart = previousCart;
//	   
////	   for (int i = 0; i < previousCart.size(); i++){
////		   previousCart.set(i, request.getParameterValues("Qty"));
////	   }
//	   
//	   previousCart = request.getParameterValues("Qty");
////	   (request.getParameterValues("Qty"));
//	   
//   }

//   session.setAttribute("previousCart", previousCart); 

   
   String title = "Shopping Cart";
   String docType =
     "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
     "Transitional//EN\">\n";
   // Display table of item number, item names, and item quantity
//   out.println(previousCart.toString());
   out.println(docType +
               "<HTML>\n" +
               "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
               "<BODY BGCOLOR=\"#FDF5E6\"><CENTER>\n" +
               "<H1>" + title + "</H1>");
   out.println("<TABLE BORDER=1 CELLPADDING=5 CELLSPACING=1>");
   out.print("<tr><th>Item Number</th><th>Item Name</th><th>Item Quantity</th></tr>");

//	  out.print("<tr><td>123</td><td>Orange</td><td>" + previousCart.get(0) + "</td></tr>");
//	  out.print("<tr><td>124</td><td>Apple</td><td>" + previousCart.get(1) + "</td></tr>");
//	  out.print("<tr><td>125</td><td>Banana</td><td>" + previousCart.get(2) + "</td></tr>");
//	  out.print("<tr><td>126</td><td>Grape</td><td>" + previousCart.get(3) + "</td></tr>");
   
   
   out.println("</TABLE>");
   // Back to order form link
//   out.println("<br><a href=\"#\" onclick=\"history.go(-1)\"> << Back To Product List</a>");
   out.println("<br><a href=\"productList.html\"> << Back To Product List</a>");
   out.println("</CENTER></BODY></HTML>");

 }
}

public void doPost(HttpServletRequest request,
	      HttpServletResponse response)
	      throws ServletException, IOException {
		  	doGet(request, response);
	  	};
}