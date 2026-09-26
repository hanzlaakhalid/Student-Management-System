import java.io.*;
import java.util.*;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.sql.*;
import javax.swing.*;
public class Update extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{        
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name1");
		String email = request.getParameter("email");
		String course = request.getParameter("course");
		String country = request.getParameter("country");
    try{
      DAO obj = new DAO();
      int rs = obj.update(name, email, course, country);
      if (rs==1)
        out.print("<h1>Updated Successfully</h1>");
      else
        out.print("<h1>Update Failed<h1>");
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
      int rs = obj.update(name, email, course, country);
      if (rs==1)
        out.print("<h1>Updated Successfully</h1>");
      else
        out.print("<h1>Update Failed. Email not found<h1>");
    }
    catch(Exception e){
      out.println("Error: " + e);
    }
	}
}