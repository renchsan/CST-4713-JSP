package coreservlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/applications")

public class Applications extends HttpServlet {
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
//		response.setContentType("application/vnd.ms-excel");  // Excel
//		response.setContentType("application/vnd.ms-word");   // Word
//		response.setContentType("application/PDF");   // pdf
//		response.setContentType("application/vnd.ms-word");   // Word
		PrintWriter out = response.getWriter();
		out.println("\tQ1\tQ2\tQ3\tQ4\tTotal");
		out.println("Apples\t78\t87\t92\t29\t=SUM(B2:E2)");
		out.println("Oranges\t77\t86\t93\t30\t=SUM(B3:E3)");
		
	}
	
}
