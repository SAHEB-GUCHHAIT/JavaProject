
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

public class schedule_date extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = res.getWriter();
        String cid=req.getParameter("id");
        try {
          Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection
                   ("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
           Statement stmt=con.createStatement();  
           String s1="select * from order_medicines where email='"+cid+"'";
           ResultSet rs=stmt.executeQuery(s1);
           if(rs.next())
           {
               pw.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Shipping Address</title>\n" +
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
"                 <form method=\"post\" action=\"p_logout\"> \n" +
"                 <input type=\"submit\" value=\"Logout\"> \n" +
"                </form>\n" +
"                 </td>\n" +
"                 </tr>\n" +
"                 </table>\n" +
"                 <br>\n" +
"                 <hr>\n" +
"        <div class=\"container\">\n" +
"            <form action=\"medi_delivery\" method=\"post\">\n" +
"                 Customer ID:<input type=\"email\" name=\"d3\" value="+rs.getString(2)+" readonly><br><br>\n" +
"                 Medicine:<input type=\"text\" name=\"d4\" value="+rs.getString(6)+" readonly><br><br>\n" +                       
"                Approximate Date of Delivery:<input type=\"date\" name=\"d1\"><br><br>\n" +
"                Approximate Time of Delivery:<input type=\"time\" name=\"d2\"><br><br>\n" +
"            <input type=\"submit\" value=\"SUBMIT\">\n" +
"            </form>\n" +
"        </div>\n" +
"    </body>\n" +
"</html>\n" +
"");
           }
           else
               pw.println("Result not found.");
           con.close();
        }
        catch(Exception e)
        {
         pw.println(e);
        }
    }
}
