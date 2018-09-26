package proj01;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/hello")

public class HelloServlet extends HttpServlet {
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	out.println("<html><h1>Hello World</h1></html>");
}
}
