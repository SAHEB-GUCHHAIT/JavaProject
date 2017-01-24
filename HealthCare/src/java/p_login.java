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
"                background-image: url(Drug2.jpg);\n" +
"                background-size: cover;\n" +
"            }\n" +
"            .h2{\n" +
"                color:deeppink; \n" +
"            }\n" +
"            .log{\n" +
"                width: 700px;\n" +
"                height: 560px;\n" +
"                background-color:cyan;\n" +
"                margin: 0 auto;\n" +
"                margin-top: 8px;\n" +
"                padding-top: 20px;\n" +
"                padding-left: 50px;\n" +
"                border-radius: 15px;\n" +
"                -webkit-border-radius: 15px;\n" +
"                color: aqua;\n" +
"                font-weight: bolder;\n" +
"                box-shadow: inset 4px 4px rgba(0,0,0,0.8);\n" +
"                font-size: 18px;\n" +
"            }\n" +
"            .log input[type=\"text\"]{\n" +
"                width: 200px;\n" +
"                height: 35px;\n" +
"                border: 0;\n" +
"                border-radius: 5px;\n" +
"                -webkit-border-radius: 5px;\n" +
"                padding-left: 5px;\n" +
"                background-color:  lightgray;\n" +
"            }\n" +
"            .log input[type=\"password\"]{\n" +
"                width: 200px;\n" +
"                height: 35px;\n" +
"                border: 0;\n" +
"                border-radius: 5px;\n" +
"                -webkit-border-radius: 5px;\n" +
"                padding-left: 5x;\n" +
"                background-color: lightgray;\n" +
"            }\n" +
"            .log input[type=\"submit\"]{\n" +
"                width: 100px;\n" +
"                height: 35px;\n" +
"                border: 0;\n" +
"               \n" +
"                border-radius: 5px;\n" +
"                -webkit-border-radius: 5px;\n" +
"                background-color: skyblue;\n" +
"                font-weight: bolder;\n" +
"            }                       \n" +
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
"        <div class=\"log\">\n" +
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
         pw.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>login failed</title>\n" +
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
"        \n" +
"        <div class=\"container\">\n" +
"        <h2>Password do not Match.</h2>\n" +
                 "Please try again."+
"                 <hr>  \n" +
"                 Go to Login Page<a href=\"p_login.html\">Click Here</a>        \n" +
                 "Forgot Password?<a href=\"p_forgot_pass.html\">Click Here</a>"+
"        </div>\n" +
"    </body>\n" +
"</html>\n");
     }
          con.close();
           
     }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}
