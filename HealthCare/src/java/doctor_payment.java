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

public class doctor_payment extends HttpServlet {

    
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = res.getWriter();
        try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection
                   ("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
           Statement stmt=con.createStatement();
           String q1="select * from doctors_db";
           ResultSet rs=stmt.executeQuery(q1);
           pw.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Doctor's list</title>\n" +
"        <style type=\"text/css\">\n" +
"            body{\n" +
"                margin: 0;\n" +
"                background-color: #aaaaaa;\n" +
"            }  \n" +
"            .container{\n" +
"                width: 900px;\n" +
"                height: 550px;\n" +
"                text-align: center;\n" +
"                background-color:cyan;\n" +
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
"        <div class=\"container\">\n" +
"            <form action=\"payment\" method=\"post\">\n" +
"                <h2>Doctor's Policy No</h2>\n" +
"                <select name=\"policyno\">\n" +
"                    <option value=\"null\">Choose Doctor's Policy No</option>");
           while(rs.next())
           {
               pw.println("<option value="+rs.getString(13)+">"+rs.getString(13)+"</option>");
           }
           pw.println("</select>\n" +
                   "<td><input type=\"submit\" value=\"SUBMIT\"></td>\n" +
"            </form>            \n" +
"        </div>\n" +
"    </body>\n" +
"</html>");
           con.close();   
        }           
         catch(Exception e)
         {
             
         }
        }
    }
