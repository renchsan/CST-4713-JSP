package coreservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Student
 */
@WebServlet("/Student")
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String socialNo = request.getParameter("SSN");
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://s16988308.onlinehome-server.com:1433;databaseName=CUNY_DB;integratedSecurity=false;" , "cst3613", "password1");
			PreparedStatement ps = con.prepareStatement("select * from Students where ssn = ?");
			ps.setString(1, socialNo);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
//				out.println("ssn: " + rs.getString(1));
//				out.println("FirstName: " + rs.getString(2));
				request.setAttribute("ssn", rs.getString(1));
				request.setAttribute("firstName", rs.getString(2));
				request.setAttribute("lastName", rs.getString(4));
				request.setAttribute("phone", rs.getString(7));
				request.setAttribute("address", rs.getString(6));
				request.getRequestDispatcher("/StudentInfo.jsp").forward(request, response);
				
			} else {
			    response.sendRedirect("NotFound.jsp");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			out.close();
		}
	}

}
