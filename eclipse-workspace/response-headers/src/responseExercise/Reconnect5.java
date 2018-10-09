// Matt Rencher
// CST 4713-JSP
// Exercises: HTTP Response Headers #2
// Servlet that reconnects every 5 seconds
// Display Time and date upon refresh

package responseExercise;

import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/reconnect-5")
public class Reconnect5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		String title = "Reconnect Every 5 Seconds";
		
		// Fancy Way
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		// Simple Way to get time and date
	    Date date = new Date();
	    System.out.println(date.toString());
		
		String docType =
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
		
		out.println(docType +
	        "<HTML>\n" +
	        "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
	        "<BODY BGCOLOR=\"#FDF5E6\">\n" +
	        "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
	        "<H3 ALIGN=\"CENTER\">" + dateFormat.format(cal.getTime()) + "</H3>\n" +
	        "</BODY></HTML>");
		
		response.setIntHeader("Refresh", 5);
		
	}
}

