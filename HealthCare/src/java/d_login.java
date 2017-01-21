import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class d_login extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
    {
     res.setContentType("text/html");
     PrintWriter pw=res.getWriter();
     String policyno=req.getParameter("d1");
      HttpSession policy=req.getSession();
      policy.setAttribute("nm1",policyno); 
     String pass=req.getParameter("d2");
     try
     {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con=DriverManager.getConnection(
             "jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
     Statement stmt=con.createStatement();
     String q2="select * from patient where policy_no='"+policyno+"' and status='No'";
     ResultSet rst=stmt.executeQuery(q2);
     int count=0;
     while(rst.next())
     {
         count++;
     }
     String q1="select * from doctors_db where policy_no='"+policyno+"' and password='"+pass+"' and status='Yes'";
     ResultSet rs=stmt.executeQuery(q1);
     if(rs.next())
     {
        
         //pw.println("Welcome "+rs.getString(3));
         pw.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
         "<title>Doctor Home</title>"+        
"        <style type=\"text/css\">\n" +
"            body{\n" +
"                background-image: url(doctor.jpg);\n" +
"                background-size: cover;\n" +
"            }\n" +
"            .h3{\n" +
"                color:deeppink; \n" +
"            }\n" +
"            .log{\n" +
"                width: 700px;\n" +
"                height: 460px;\n" +
"                background-color: rgba(0,0,2,0.5);\n" +
"                margin: 0 auto;\n" +
"                margin-top: 8px;\n" +
"                padding-top: 20px;\n" +
"                padding-left:0px;\n" +
                 "text-align:center;\n"+
"                border-radius: 15px;\n" +
"                -webkit-border-radius: 15px;\n" +
"                color: aqua;\n" +
"                font-weight: bolder;\n" +
"                box-shadow: inset 4px 4px rgba(0,0,0,0.8);\n" +
"                font-size: 18px;\n" +
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
"                 <form method=\"post\" action=\"d_logout\"> \n" +
"                 <input type=\"submit\" value=\"Logout\"> \n" +
"                </form>\n" +
"                 </td>\n" +
"                 </tr>\n" +
"                 </table>\n" +
"                 <hr>\n" +
"        <div class=\"log\">\n" +
"            <h3>View Status</h3>\n" +
"        \n" +
"        <a href=patient_details?id=><b>View Request</b>("+count+")</a>\n" +
"            \n" +
"                 <h3>Appointment Details</h3>\n"+
                 "\n"+
        " <a href=appo_details?id=><b>View Patient</b></a>\n"+    
                 "\n"+
"                 <br><br>\n" +
        " <a href=dpayment_details?id=><b>PAYMENT</b></a>\n"+    
                 "\n"+
"                 <br><br>\n" +                 
        " <a href=\"d_feedback.html\"><b>COMMENT</b></a>\n"+    
                 "\n"+
"        </div>\n" +
"    </body>\n" +
"</html>");
     }
     else
     {
         pw.println("Password don't Match./ You are not Registered Doctor.");
     }
          con.close();
           
     }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}
