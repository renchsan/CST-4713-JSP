// Niaz Morshed
// Matt Rencher
// CST 4713-JSP
// JSP Servlet, button with take user to either Google or Yahoo
// 10/1/2018

package reqheaders;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/random-search")
public class RandomSearch extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		if (Math.random() < 0.5) {
			response.sendRedirect("https://www.google.com/");
		} else {
			response.sendRedirect("http://www.bing.com/");
		}
	}
}