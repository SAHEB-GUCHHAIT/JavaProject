import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class insert extends HttpServlet 
{
    public void doPost (HttpServletRequest req,HttpServletResponse res) throws 
            ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String policy_no=req.getParameter("p1");
       
        try
        {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
           Statement stmt=con.createStatement();
           String q1="insert into policy_doc values('"+policy_no+"')";
           int x=stmt.executeUpdate(q1);
           if(x>0)
                   {
                      pw.println("Insert Success.");
                   }
           else
           {
               pw.println("Insert Failed.");
           }
           con.close();
           
        }
        catch(Exception e)
        {
            pw.println(e);
        }
        
    }
}

    
    
