// Matthew Rencher
// CST4713
// 9-17-2018
// Servlet that prints out param1, param2, param3
// Filters out code injections

package forms;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import MyUtilities.ServletUtilities;


@WebServlet("/three-params-post-filter")
public class ThreeParamsPostFilter extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Reading Three Request Parameters";
    String param1 = ServletUtilities.filter(request.getParameter("param1"));
    String param2 = ServletUtilities.filter(request.getParameter("param2"));
    String param3 = ServletUtilities.filter(request.getParameter("param3"));
    
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<UL>\n" +
                "  <LI><B>Name</B>: "
                + param1 + "\n" +
                "  <LI><B>Email</B>: "
                + param2 + "\n" +
                "  <LI><B>Image</B>: <img src=\""
                + param3 + "\"/>\n" +
                "</UL>\n" +
                "</BODY></HTML>");
  }
  
  public void doPost(HttpServletRequest request,
	      HttpServletResponse response)
	      throws ServletException, IOException {
		  	doGet(request, response);
	  	};
}
