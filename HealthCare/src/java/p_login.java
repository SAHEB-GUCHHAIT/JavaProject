import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class p_login extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
    {
     res.setContentType("text/html");
     PrintWriter pw=res.getWriter();
     String pid=req.getParameter("p1");
     HttpSession email=req.getSession();
      email.setAttribute("nm1",pid); 
     String pass=req.getParameter("p2");
     try
     {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con=DriverManager.getConnection(
             "jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
     Statement stmt=con.createStatement();
     String q1="select * from pharmacist_db where phar_id='"+pid+"' and password='"+pass+"'";
     ResultSet rs=stmt.executeQuery(q1);
     if(rs.next())
     {
        // pw.println("Welcome "+rs.getString(3));
         pw.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Pharmacy home</title>\n" +
"        <style type=\"text/css\">\n" +
"            body{\n" +
"                margin: 0;\n" +
"                background-color: #aaaaaa;\n" +
"            }  \n" +
"            .container{\n" +
"                width: 1200px;\n" +
"                height: 500px;\n" +
"                text-align: center;\n" +
"                background-color: lightpink;\n" +
"                border-radius: 4px;\n" +
"                margin: 0 auto;\n" +
"                margin-top: 20px;\n" +
"                padding-top: 40px;\n" +
"            }             \n" +
"        </style>\n" +
"    </head>\n" +
"    <body>\n" +
"        <table border=\"0\" width=\"100%\" >\n" +
"                 <tr>\n" +
"                 <td align=\"right\">\n" +
"                 <form method=\"post\" action=\"p_logout\"> \n" +
"                 <input type=\"submit\" value=\"Logout\"> \n" +
"                </form>\n" +
"                 </td>\n" +
"                 </tr>\n" +
"                 </table>\n" +
"                 <br>\n" +
"                 <hr>\n" +
"        <div class=\"container\">\n" +
"            \n" +
"            <a href=medi_view?id=><h3>View Stock</h3></a>\n" +
"                <br>\n" +
                 "<a href=\"upload.html\"><h3>Add Medicine</h3></a>\n" +
"                <br>\n" +
"                <a href=medi_req?id=><h3>Requested Medicine by Patient</h3></a>\n" +
"                <br>\n" +
"                <a href=medi_dispatch?id=><h3>Dispatch Status</h3></a>\n" +
"                <br>\n" +
"                <a href=ppayment_details?id=><h3>View Payment</h3></a>\n" +
"                <br>\n" +
"                <a href=\"phar_feedback.html\"><h3>Feedback</h3></a>\n" +
"                <br>\n" +
"        </div>\n" +
"    </body>\n" +
"</html>");
     }
     else
     {
         pw.println("Password don't Match.");
     }
          con.close();
           
     }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}
