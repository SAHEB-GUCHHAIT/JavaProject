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
                      pw.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Appoentment request</title>\n" +
"        <style type=\"text/css\">\n" +
"            body{\n" +
"                margin: 0;\n" +
"                background-color: #aaaaaa;\n" +
"            }  \n" +
"            .container{\n" +
"                width: 900px;\n" +
"                height: 500px;\n" +
"                text-align: center;\n" +
"                background-color: lightpink;\n" +
"                border-radius: 4px;\n" +
"                margin: 0 auto;\n" +
"                margin-top: 20px;\n" +
"                padding-top: 40px;\n" +
"            } \n" +
"          \n" +
"            \n" +
"        </style>\n" +
"    </head>\n" +
"    <body>\n" +
"        <table border=\"0\" width=\"100%\" >\n" +
"                 <tr>\n" +
"                 <td align=\"right\">\n" +
"                 <form method=\"post\" action=\"logout\"> \n" +
"                 <input type=\"submit\" value=\"Logout\"> \n" +
"                </form>\n" +
"                 </td>\n" +
"                 </tr>\n" +
"                 </table>\n" +
"                 <br>\n" +
"                 <hr>\n" +                              
"        \n" +
"        <div class=\"container\">\n" +
"        <h2>Appointment request send successfully.</h2>\n" +
"                 <hr>  \n" +
"                 Go to Home Page<a href=\"UserHome.html\">Click Here</a>        \n" +
"        </div>\n" +
"    </body>\n" +
"</html>\n" +
"");
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

    
    
