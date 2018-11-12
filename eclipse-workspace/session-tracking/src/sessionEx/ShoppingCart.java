package sessionEx;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import MyUtilities.ServletUtilities;

@WebServlet("/shopping-cart")
public class shoppingCart extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    String[] itemids = {"123","124","125","126"};
	    String[] itemnames = {"Orange","Apple","Banana","Grape"};
	    
	    HttpSession session = request.getSession();
	    boolean hasVisitedPageOne = false;
	   
	    @SuppressWarnings("unchecked")
	    
		ArrayList<String> previousItems = (ArrayList<String>)session.getAttribute("previousItems");
	    
	    if (previousItems == null) {
	      previousItems = new ArrayList<String>();
	      session.setAttribute("previousItems", previousItems);
	    }
	    
	    String[] qty = request.getParameterValues("Qty");
	    
	    for(int q=0;q<itemids.length;q++) {
	    	if (qty!=null) {
	    		if(!qty[q].isEmpty())
	    		{
    	    	    for(int quan=0;quan<Integer.parseInt(qty[q]);quan++)  
    	    	    {
    	    	    	previousItems.add(itemids[q]);
    	    	    }
	    		}
	    	}
	    }
	    
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
	    
	    if (!hasVisitedPageOne) {
	        out.println(ServletUtilities.headWithTitle("Shopping Cart")+"You must visit product list first.<br /><a href='productList.html'>Product List</a>"+ServletUtilities.footerString());
	    } else {
		    out.print(ServletUtilities.headWithTitle("Shopping"));
		    if (previousItems.size() == 0) {
		      out.println("<I>No items</I><br /><br /><a href='productList.html'>Back to Product List</a>");
		    } else {
		    	out.println("<BODY BGCOLOR=\"#FDF5E6\"><CENTER><H1>Order Form</H1><TABLE BORDER=1 CELLPADDING=5 CELLSPACING=0><TR BGCOLOR=\"#FFAD00\">"
		    			+ "<TH>Item ID <TH>Item Name <TH>Quantity </TR>");
		        for(int i=0;i<itemids.length;i++) {		        	
		        	int occurrencesi = Collections.frequency(previousItems,itemids[i]);
		        	out.println("<tr><td>"+ itemids[i]+"</td><td>"+itemnames[i]+"</td><td>"+occurrencesi+"</td></tr>");
		        }
		        out.println("</TABLE>"
		        		+ "<br /><br /><a href='productList.html'>Back to Product List</a> <a href='export'>Export to Excel</a>");
		    }
		    out.print(ServletUtilities.footerString());
		  }
	  }

	  public void doPost(HttpServletRequest request,
				 HttpServletResponse response)
				 throws ServletException, IOException {
			doGet(request,response);
	  };
}
