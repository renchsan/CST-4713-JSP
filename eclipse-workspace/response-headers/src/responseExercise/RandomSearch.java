// Matt Rencher
// CST 4713-JSP
// Exercises: HTTP Response Headers #1

package responseExercise;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/random-search-1")
public class RandomSearch extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		if (Math.random() < 0.5) {
			//set redirect manually
			response.setStatus(302);
			response.setHeader("Location", "www.google.com/");
		} else {
			response.setStatus(302);
			response.setHeader("Location", "www.bing.com/");
		} 
		
		// Doesn't redirect to pages properly
	}
}
