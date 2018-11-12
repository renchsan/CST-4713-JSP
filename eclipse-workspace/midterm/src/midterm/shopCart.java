package midterm;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import ServletUtilities.ServletUtilities;

@WebServlet("/shop-cart-1")
public class shopCart extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String itemid = request.getParameter("itemid");
	    String[] itemids = {"123","124","125","126"};
	    String[] itemnames = {"Orange","Apple","Banana","Grape"};
	    HttpSession session = request.getSession();
	    boolean accessCheck = false;
	    
	    @SuppressWarnings("unchecked")
		ArrayList<String> previousItems = (ArrayList<String>)session.getAttribute("previousItems");
	    
	    if (previousItems == null) {
	      previousItems = new ArrayList<String>();
	      session.setAttribute("previousItems", previousItems);
	    }
	    String[] qty = request.getParameterValues("Qty");
	    for(int q=0;q<itemids.length;q++) {
	    	if (request.getParameterValues("Qty")!=null) {
	    		if(!qty[q].isEmpty())
	    		{
    	    	    for(int quan=0;quan<Integer.parseInt(qty[q]);quan++)  
    	    	    {
    	    	    	previousItems.add(itemids[q]);
    	    	    }
	    		}
	    	}
	    }
	    if(request.getParameter("OrderBtn")!=null && !accessCheck)
	    {
	    	Cookie pageOneCookie = new Cookie("visitedPageOne", "yes");
	        pageOneCookie.setMaxAge(60*60*24*365);
	        response.addCookie(pageOneCookie);
	        accessCheck = true;
	    }

	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	      for(Cookie c: cookies) {
	        if ((c.getName().equals("visitedPageOne")) && (c.getValue().equals("yes"))) {
	          accessCheck = true;
	          break;
	        }
	      }
	    }
	    if (!accessCheck) {
	    	response.sendError(404, "You must visit the Product List first");
	    } else {
	    out.print(ServletUtilities.headWithTitle("Shopping"));
	    if (previousItems.size() == 0) {
	        out.println("<I>No items</I><br /><br /><a href='productList.html'>Back to Product List</a>");
	      } else {
	        out.println("<table border='1' cellspacing='1'>" + 
	        		"    <tr><th>Item&nbsp;ID</th><th>Product&nbsp;Name</th><th>Quantity</th></tr>");
	        
	        for(int i=0; i<itemids.length; i++) {
	      	  int occurrencesi = Collections.frequency(previousItems,itemids[i]);
	          out.println("<tr><td>"+ itemids[i]+"</td><td>"+itemnames[i]+"</td><td>"+occurrencesi+"</td></tr>");
	        }
	        out.println("</table>"
	        		+ "<br /><br /><a href='productList.html'>Back to Product List</a> <a href='export'>Export to Excel</a>");
	      }
	    out.print(ServletUtilities.footerString());
	    }
  }
  public void doPost(HttpServletRequest request,
			 HttpServletResponse response)
			 throws ServletException, IOException {
		doGet(request,response);
	}
}