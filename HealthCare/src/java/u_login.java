import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class u_login extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
    {
     res.setContentType("text/html");
     PrintWriter pw=res.getWriter();
     String uid=req.getParameter("u1");
     HttpSession email=req.getSession();
      email.setAttribute("nm1",uid); 
     String pass=req.getParameter("u2");
     try
     {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con=DriverManager.getConnection(
             "jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
     Statement stmt=con.createStatement();
     String q1="select * from user_db where user_id='"+uid+"' and password='"+pass+"'";
     ResultSet rs=stmt.executeQuery(q1);
     if(rs.next())
     {
        // pw.println("Welcome "+rs.getString(3));`
         pw.println("<!DOCTYPE html>\n" +
"\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Welcome to Health Services</title>\n" +
"        <style type=\"text/css\">\n" +
"            body{\n" +
"                background-image: url(wide.jpg);\n" +
"                background-size: cover;\n" +
"            }\n" +
"            .h2{\n" +
"                color:deeppink; \n" +
"            }\n" +
"            .log{\n" +
"                width: 700px;\n" +
"                height: 560px;\n" +
"                background-color: rgba(0,0,2,0.5);\n" +
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
                 "<table border=\"0\" width=\"100%\" >"+
                 "<tr>"+
                 "<td align=\"right\">"+
                 "<form method=\"post\" action=\"logout\">\n" + 
                 "<input type=\"submit\" value=\"Logout\">\n" + 
                 "</form>\n" +
                 "</td>"+
                 "</tr>"+
                 "</table>"+
                 "<br>\n"+
"        <div class=\"log\">\n" +
"         <form method=\"post\" action=\"user_view\">\n" +
"             <p>How To Use My Medicine?\n" +
"\n" +
"My Medicine helps you safely take your medicine.\n" +
"\n" +
"Interactions:: Check for interactions between your medications.\n" +
"FDA Warnings & Alerts:: Learn if there are any major FDA warnings or alerts on saved medicines.</p>\n" +
                 "        <a href=\"booking.html\">ORDER MEDICINE</a>\n" +                      
"            \n" +
"           <br>"+
"             <h2>SYMPTOM</h2>\n" +
"        <b>Choose Your Symptoms:</b>\n" +
"        <select name=\"s1\">\n" +
"            <option value=\"null\">your's Symptom</option> \n" +
"            <option value=\"fever\">Fever</option>\n" +
"            <option value=\"cold\">Cold, Flu, & Cough</option>\n" +
"            <option value=\"diabetes\">Diabetes</option>\n" +
"        </select>\n" +
"        <br>\n" +
"        <br>\n" +
"        <b>How day's you are suffering?</b>\n" +
"        <select name=\"s2\">\n" +
"            <option value=\"null\">choose days</option> \n" +
"            <option value=\"day1\">1-2 Day's</option>\n" +
"            <option value=\"day7\">3-7 Day's</option>\n" +
"            <option value=\"days\">Over 7 day's</option>\n" +
"        </select>\n" +
"        <br>\n" +
"        <br>\n" +
"        <input type=\"submit\" value=\"SUBMIT\">\n" +                 
                 "<br>\n"+
                 "<br>\n"+
                 " Do you want Appointment a Doctor?(Without our medicine support.)     \n" +
                 "<br>\n"+
"        <a href=\"location.html\">GET APPOINTMENT</a>"+
                            "<br>\n"+
                 "<br>\n"+
         "<a href=appo_date?id=>Notification</a>\n"+    
                 "<br>\n"+ 
                  "<br>\n"+
         "<a href=deli_status?id=>View Delivery Status</a>\n"+    
                 "<br>\n"+                  
                                  "<br>\n"+
         "<a href=\"u_feedback.html\">Leave a Comment</a>\n"+
"        </form>    \n" +
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
"                 Go to Login Page<a href=\"u_login.html\">Click Here</a>        \n" +
                 "Forgot Password?<a href=\"u_forgot_pass.html\">Click Here</a>"+
"        </div>\n" +
"    </body>\n" +
"</html>\n" +
"");
     }
          con.close();
           
     }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}
