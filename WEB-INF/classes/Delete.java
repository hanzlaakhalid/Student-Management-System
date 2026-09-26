import java.io.*;
import java.util.*;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.sql.*;
import javax.swing.*;
public class Delete extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{        
        PrintWriter out = response.getWriter();
        try{
            DAO obj = new DAO();
            int rs = obj.delete(request.getParameter("email"));
            if(rs==1)
                out.println("Successfully deleted");
            else{
                out.println("Failed to delete");
            }
        }
        catch(Exception e){
        out.println("Error: " + e);
        }
	}
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{        
        PrintWriter out = response.getWriter();
        try{
            DAO obj = new DAO();
            int rs = obj.delete(request.getParameter("email"));
            if(rs==1)
                out.println("Successfully deleted");
            else{
                out.println("Failed to delete");
            }
        }
        catch(Exception e){
        out.println("Error: " + e);
        }
	}
}