
// Exercise 1
package cookiesExercises;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import MyUtilities.ServletUtilities;

@WebServlet("/info-req")
public class infoReq extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
	  
    Cookie cookie = new Cookie("Entry",
                        "accessGranted");
    // Cookie is valid for an hour, regardless of whether
    // user quits browser, reboots computer, or whatever.
    cookie.setMaxAge(3600);
    response.addCookie(cookie);
  }
      
  public void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
	  	doGet(request, response);
  	};
}
