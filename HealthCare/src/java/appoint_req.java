import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class appoint_req extends HttpServlet 
{
    public void doPost (HttpServletRequest req,HttpServletResponse res) throws 
            ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String doctor=req.getParameter("p5");
        String name=req.getParameter("p1");
        String email=req.getParameter("p2");
       String mobile=req.getParameter("p3");
       String symptom=req.getParameter("p4");
       String status="No";
       String policyno;
        try
        {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
           Statement stmt=con.createStatement();
           String q2="select * from doctors_db where name='"+doctor+"'";
           ResultSet rs=stmt.executeQuery(q2);
           if(rs.next())
           {
            policyno=rs.getString("policy_no");
            String q1="insert into patient values('"+doctor+"','"+name+"','"+email+"','"+mobile+"','"+symptom+"','"+status+"','"+policyno+"')";
           int x=stmt.executeUpdate(q1);
           if(x>0)
                   {
                      pw.println("Appointment request send successfully.");
                   }
           else
           {
               pw.println("Request not send.");
           }
           }
           
           con.close();
           
        }
        catch(Exception e)
        {
            pw.println(e);
        }
        
    }
}

    
    
