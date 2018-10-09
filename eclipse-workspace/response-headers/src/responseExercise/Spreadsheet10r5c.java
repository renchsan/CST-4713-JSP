// Matt Rencher
// CST 4713-JSP
// Exercises: HTTP Response Headers #3
// Servlet to display Excel sheet with 10 rows and 5 columns
// Containing random numbers

// IE and Firefox have different dialogs to open/save the file

package responseExercise;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/excel-header-test")

public class Spreadsheet10r5c extends HttpServlet {
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		response.setContentType("application/vnd.ms-excel");  // Excel
		
		PrintWriter out = response.getWriter();

	    for(int rows = 1; rows <= 10; rows++){	    	
	    	for (int cols = 1; cols <= 5; cols++){
	    		int rand = (int)(Math.random()*100);
	    		out.print(rand + "\t" );  // print row
	    	} 
	    	out.println("");  // new row
	    }
	}
	
}
