import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class doctor_feedback extends HttpServlet 
{
    public void doPost (HttpServletRequest req,HttpServletResponse res) throws 
            ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        HttpSession policy=req.getSession();
        String pol=(String)policy.getAttribute("nm1");
        String type=req.getParameter("q3");
        String feedback=req.getParameter("q4");
        String fname=req.getParameter("q5_name[first]");
        String lname=req.getParameter("q5_name[last]");
        String mail=req.getParameter("q6_email");
        String mobile=req.getParameter("q7_mobile");
        try
        {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
           Statement stmt=con.createStatement();
           String q1="insert into dfeedback values('"+type+"','"+feedback+"','"+fname+"','"+lname+"','"+mail+"','"+mobile+"','"+pol+"')";
           int x=stmt.executeUpdate(q1);
           if(x>0)
                   {
                      pw.println("Send successfuly.");
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

    
    
