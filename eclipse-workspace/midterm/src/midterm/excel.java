package midterm;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/** Servlet that creates Excel spreadsheet comparing
 *  apples and oranges.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages 2nd Edition
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2003 Marty Hall; may be freely used or adapted.
 */
@WebServlet("/export")
public class excel extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
      response.setContentType("application/vnd.ms-excel");
      String[] itemids = {"123","124","125","126"};
	  String[] itemnames = {"Orange","Apple","Banana","Grape"};
      PrintWriter out = response.getWriter();
      HttpSession session = request.getSession();
      ArrayList<String> previousItems = (ArrayList<String>)session.getAttribute("previousItems");
      out.println("Item ID\tName\tQty");
      for(int i=0;i<itemids.length;i++) {
      	
    	    int occurrencesi = Collections.frequency(previousItems,itemids[i]);
        out.println(""+itemids[i]+"\t"+itemnames[i]+"\t"+occurrencesi+"");
      }
      out.println("\tTotal Qty\t=SUM(C2:C5)");
  }
}