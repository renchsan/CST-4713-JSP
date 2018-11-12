package midterm;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.util.*;

@WebServlet("/exportExcel")
public class exportExcel extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("application/vnd.ms-excel");
    
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

	      PrintWriter out = response.getWriter();
	      out.println("ItemID\tName\tQty");
	      out.println("123\tOrange\t" + previousCart.get(123));
	      out.println("123\tApple\t" + previousCart.get(124));
	      out.println("123\tBanna\t" + previousCart.get(125));
	      out.println("123\tGrape\t" + previousCart.get(126));
	      out.println("\tSum\t=SUM(C1:C4)");
	      out.println();	      
	      
	}// end of sync
    
  }
  
  public void doPost(HttpServletRequest request,
	      HttpServletResponse response)
	      throws ServletException, IOException {
		  	doGet(request, response);
	  	};  
}
