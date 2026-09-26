import java.io.*;
import java.util.*;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.sql.*;
import javax.swing.*;
public class Read extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {        
            PrintWriter out = response.getWriter();
            try{
                DAO obj = new DAO();
                ResultSet rs = obj.read();
            while(rs.next()) {
                out.println("<div style='border:1px solid #ccc; padding:15px; margin:10px; border-radius:8px; width:300px; font-family:Arial;'>");
                out.println("<p><strong>Name:</strong> " + rs.getString("name") + "</p>");
                out.println("<p><strong>Email:</strong> " + rs.getString("email") + "</p>");
                out.println("<p><strong>Course:</strong> " + rs.getString("course") + "</p>");
                out.println("<p><strong>Country:</strong> " + rs.getString("country") + "</p>");
                out.println("</div>");
}

            }
            catch(Exception e){
                out.println(e);
            } 
    }

   public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {        
            PrintWriter out = response.getWriter();
            try{
                DAO obj = new DAO();
                ResultSet rs = obj.read();
            while(rs.next()) {
                out.println("<div style='border:1px solid #ccc; padding:15px; margin:10px; border-radius:8px; width:300px; font-family:Arial;'>");
                out.println("<p><strong>Name:</strong> " + rs.getString("name") + "</p>");
                out.println("<p><strong>Email:</strong> " + rs.getString("email") + "</p>");
                out.println("<p><strong>Course:</strong> " + rs.getString("course") + "</p>");
                out.println("<p><strong>Country:</strong> " + rs.getString("country") + "</p>");
                out.println("</div>");
}

            }
            catch(Exception e){
                out.println(e);
            } 
    }
}

