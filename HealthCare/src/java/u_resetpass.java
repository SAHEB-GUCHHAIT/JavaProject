
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class u_resetpass extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = res.getWriter();
        HttpSession mail=req.getSession();
        String email=(String)mail.getAttribute("eid");
        String ans=req.getParameter("r2");
        try
        {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection
                   ("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
           Statement stmt=con.createStatement();
           String q1="select * from user_db where user_id='"+email+"' and answer='"+ans+"'";
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
"                width: 600px;\n" +
"                height: 400px;\n" +
"                text-align: center;\n" +
"                background-color: lightpink;\n" +
"                border-radius: 4px;\n" +
"                margin: 0 auto;\n" +
"                margin-top: 50px;\n" +
"                padding-top: 40px;\n" +
"            }            \n" +
"            input[type=\"text\"]{\n" +
"                height: 45px;\n" +
"                width: 300px;\n" +
"                font-size: 18px;\n" +
"                border: none;\n" +
"                border-radius:5px;\n" +
"                margin-bottom: 20px;\n" +
"                background-color:  aqua;\n" +
"                padding-left: 20px;\n" +
"            }\n" +
"            .form-input::before{\n" +
"                position: absolute;\n" +
"                font-size: 30px;\n" +
"                padding-left: 5px;\n" +
"                padding-top: 5px;\n" +
"            }\n" +
"            .btn-submit{\n" +
"                padding:15px 30px;\n" +
"                color: blue;\n" +
"                cursor:  pointer;\n" +
"                border-radius: 4px;\n" +
"                border: none;\n" +
"                background-color: lawngreen;\n" +
"                border-bottom: 4px solid blueviolet;\n" +
"                margin-bottom: 20px;\n" +
"            }\n" +
"        </style>\n" +
"    </head>\n" +
"    <body>\n" +
"        <div class=\"container\">\n" +
"            <form action=\"u_updatepass\" method=\"post\">\n" +
"                <div class=\"form-input\">\n" +
"                    New Password:<input type=\"text\" name=\"p1\" placeholder=\"Enter a new password\">\n" +
"                </div>\n" +
"                <input type=\"submit\" name=\"submit\" value=\"SUBMIT\" class=\"btn-submit\">\n" +
"            </form>\n" +
"        </div>\n" +
"    </body>\n" +
"</html>\n" +
"");
           }
           else
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
"                    <h1><font color=\"green\"><b>Your ID and Security answer do not Match</b></font></h1>\n" +
"                </div>\n" +
"                <a href=\"u_forgot_pass.html\" >Try Again</a>\n" +
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
