import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class u_updatepass extends HttpServlet 
{
    public void doPost (HttpServletRequest req,HttpServletResponse res) throws 
            ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        HttpSession mail=req.getSession();
        String email=(String)mail.getAttribute("eid");
        String pass=req.getParameter("p1");
        
        try
        {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection
                   ("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
           Statement stmt=con.createStatement();
           String q1="update user_db set password='"+pass+"' where user_id='"+email+"'";
          
           ResultSet rs=stmt.executeQuery(q1);
           if(rs.next())
           {
               pw.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Forgot password</title>\n" +
"        <style type=\"text/css\">\n" +
"            body{\n" +
"                margin: 0;\n" +
"                background-color: #aaaaaa;\n" +
"            }  \n" +
"            .container{\n" +
"                width: 500px;\n" +
"                height: 300px;\n" +
"                text-align: center;\n" +
"                background-color: lightpink;\n" +
"                border-radius: 4px;\n" +
"                margin: 0 auto;\n" +
"                margin-top: 50px;\n" +
"                padding-top: 40px;\n" +
"            }             \n" +
"        </style>\n" +
"    </head>\n" +
"    <body>\n" +
"        <div class=\"container\">\n" +
"            \n" +
"                <div class=\"\">\n" +
"                    <h1><font color=\"green\"><b>Update Successfully.</b></font></h1>\n" +
"                </div>\n" +
"                <a href=\"u_login.html\" >Go to Login Page</a>\n" +
"        </div>\n" +
"    </body>\n" +
"</html>\n" +
"");
               
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