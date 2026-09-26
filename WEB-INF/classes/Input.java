import java.io.*;
import java.util.*;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.sql.*;
import javax.swing.*;
public class Input extends HttpServlet {
  public void init() throws ServletException {
    // Initialization code, if needed
  }
public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{        
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name1");
		String email = request.getParameter("email");
		String course = request.getParameter("course");
		String country = request.getParameter("country");
    try{
      DAO obj = new DAO();
      int rs = obj.insert(name, email, course, country);
      request.getRequestDispatcher("Read").include(request, response);
      if (rs==1){
        out.print("<h1>Inserted Successfully</h1>");
        response.sendRedirect("index.html");
      }
      else
        out.print("<h1>Insertion Failed<h1>");
    }
    catch(Exception e){
      out.println("Error: " + e);
    }
  }
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{        
    PrintWriter out = response.getWriter();
		String name = request.getParameter("name1");
		String email = request.getParameter("email");
		String course = request.getParameter("course");
		String country = request.getParameter("country");
    try{
      DAO obj = new DAO();
      int rs = obj.insert(name, email, course, country);
      if (rs==1)
        out.print("<h1>Inserted Successfully</h1>");
      else
        out.print("<h1>Insertion Failed<h1>");
    }
    catch(Exception e){
      out.println("Error: " + e);
    }
	}
}