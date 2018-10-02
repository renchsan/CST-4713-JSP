// Niaz Morshed
// Matt Rencher
// CST 4713-JSP
// JSP Servlet, button redirects to Wash Post first 9 clicks, then every 10th it redirects to NY Times
// 10/1/2018

package reqheaders;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/spec-req")
public class SpecificRequest extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// check counter
		if (num()) {
			response.sendRedirect("https://www.nytimes.com/");

		} else {
			response.sendRedirect("https://www.washingtonpost.com/");

		}
	}

	int counter = 0;

	boolean num() {
		++counter;
		counter %= 10;
		return (counter == 0);
	}
}