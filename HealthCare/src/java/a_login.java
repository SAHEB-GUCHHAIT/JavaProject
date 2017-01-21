import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class a_login extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
    {
     res.setContentType("text/html");
     PrintWriter pw=res.getWriter();
     String uid=req.getParameter("a1");
     String pass=req.getParameter("a2");
     if(uid.equals("Admin")&&(pass.equals("13795")))
     {
         pw.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Admin View</title>\n" +
"        <style type=\"text/css\">\n" +
"            body{\n" +
"                margin: 0;\n" +
"                background-color: #aaaaaa;\n" +
"            }  \n" +
"            .container{\n" +
"                width: 900px;\n" +
"                height: 550px;\n" +
"                text-align: center;\n" +
"                background-color: lightpink;\n" +
"                border-radius: 4px;\n" +
"                margin: 0 auto;\n" +
"                margin-top: 2px;\n" +
"                padding-top: 20px;\n" +
"            }             \n" +
"        </style>\n" +
"    </head>\n" +
"    <body>\n" +
"        <table border=\"0\" width=\"100%\" >\n" +
"                 <tr>\n" +
"                 <td align=\"right\">\n" +
"                 <form method=\"post\" action=\"a_logout\"> \n" +
"                 <input type=\"submit\" value=\"Logout\"> \n" +
"                </form>\n" +
"                 </td>\n" +
"                 </tr>\n" +
"                 </table>\n" +
"                 <br>\n" +
"                 <hr>\n" +
"        <div class=\"container\">\n" +
"            <h2>Doctor's Confirmation</h2> \n" +
"            <a href=doctor_req?id=><b>View Doctor</b></a>\n" +
"<br>"+
                 "<br>"+
"            <a href=doctor_feed?id=><h3>Doctor's Feedback</h3></a>\n" +
                 "<br>"+
"            <a href=pharmacist_feed?id=><h3>Pharmacist Feedback</h3></a>\n" +
                 "<br>"+
"            <a href=patient_feed?id=><h3>Patient Feedback</h3></a>\n" +
                 "<br>"+
"            <h2>Payment Generate</h2> \n" +
"            <a href=doctor_payment?id=><h3>Doctor's Payment</h3></a>\n" +
    "<br>"+             
"            <a href=pharmacy_payment?id=><h3>Pharmacist's Payment</h3></a>\n" +
"        </div>\n" +
"    </body>\n" +
"</html>");
     }
     else
     {
         pw.println("Password did not match.");
     }
     
    }
}
