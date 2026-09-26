import java.sql.*;
public class DAO{
    Statement st;
    Connection con;
    //ClassNotFoundException is thrown when jdbc class is not found and SQLException is for SQL connection.nullPointerException is thrown when a con pointer contain null.
    DAO()throws ClassNotFoundException, SQLException,NullPointerException
    {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1/student_management_system";
            con = DriverManager.getConnection(url, "root", "root");
            st = con.createStatement();
    }
    public int insert(String name,String email,String course,String country)throws Exception
    {
        int rs = 0;
        String query = "INSERT INTO student(name,email,course,country)VALUES('"+name+"','"+email+"','"+course+"','"+country+"')";
        rs = st.executeUpdate( query );
       return rs;
    }
    public ResultSet read()throws Exception
    {
        String query = "SELECT * FROM student";
        ResultSet rs = st.executeQuery(query);
        return rs;
    }
    public int delete(String gmail)throws Exception
    {
        int rs = 0;
        String query = "Delete from student where email = '"+gmail+"'";
        rs = st.executeUpdate(query);
        return rs;
    }
    //NullPointerException is thrown when a st pointer contain null and SQLException is for SQL connection.
    public int update(String name,String email,String course,String country)throws NullPointerException, SQLException
    {
        int rs = 0;
        String query = "Update student set name = '"+name+"',course = '"+course+"',country = '"+country+"' where email = '"+email+"'";
        rs = st.executeUpdate( query );
       return rs;
    }
    public void close() throws SQLException
    {
        if(st != null) st.close();
        if(con != null) con.close();
    }
}