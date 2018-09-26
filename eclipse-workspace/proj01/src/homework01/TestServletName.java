// Matthew Rencher
// CST4713
// Simple servlet to print name in "Hello (title)"

package homework01;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/name")
public class TestServletName extends HttpServlet {
	private int nextID = 0;
	public void doGet(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "MATTHEW";
		
		String docType =
		"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
		"Transitional//EN\">\n";
		out.println
	      (docType +
	       "<html>\n" +
	       "<head><title>Hello" + title + "</title></head>\n" +
	       "<body bgcolor=\"#D3D3D3\">\n" +
	       "<h1>Hello " + title + "</h1>\n");
		String id = "User-ID-" + nextID;
		out.println("<H2>" + id + "</H2>");
		nextID = nextID + 1;

	    out.println("</body></html>");
	}
}