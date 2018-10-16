// Matt Rencher
// CST 4713-JSP
// Exercises: HTTP Response Headers #1

package responseExercise;

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
//			response.setStatus(300);
			response.setHeader("sendRedirect", "www.google.com/");
		} else {
//			response.setStatus(300);
			response.setHeader("sendRedirect", "www.bing.com/");
		} 
		
		// Doesn't redirect to pages properly
	}
}