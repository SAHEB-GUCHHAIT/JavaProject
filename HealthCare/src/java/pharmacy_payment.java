
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

public class pharmacy_payment extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = res.getWriter();
        
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection
                    ("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
            Statement stmt=con.createStatement();
            String q1="select * from delivery_status where month='jan'"; 
            ResultSet rs=stmt.executeQuery(q1);
            int count=0;
            while(rs.next())
            {
             count++;
             
            }
            pw.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <style type=\"text/css\">\n" +
"            body{\n" +
"                background-color: aqua;\n" +
"                background-size: cover;\n" +
"            }\n" +
                 ".log{\n" +
"                width: 740px;\n" +
"                height: 360px;\n" +
"                background-color: rgba(0,0,2,0.5);\n" +
"                margin: 0 auto;\n" +
"                margin-top: 50px;\n" +
"                padding-top: 20px;\n" +
"                padding-left: 50px;\n" +
"                text-align: center;\n" +                    
"                border-radius: 15px;\n" +
"                -webkit-border-radius: 15px;\n" +
"                color: aqua;\n" +
"                font-weight: bolder;\n" +
"                box-shadow: inset 4px 4px rgba(0,0,0,0.8);\n" +
"                font-size: 18px;\n" +
"            }"+
"        </style>\n" +
"        <title>View Customer</title>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
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
                      "<div class=\"log\"> "+
"            <form action=\"ppay_amount\" method=\"post\">\n" +
"                Number of Customer=<input type=\"text\"  name=\"c1\" value="+count+" readonly>\n" +
"                <br>\n" +
"                <br>\n" +                    
"                <input type=\"submit\" value=\"SUBMIT\">\n" +
"            </form>            \n" +
                      "</div>"+
"    </body>\n" +
"</html>");
            con.close();
        }
        catch(Exception e)
        {            
            pw.println(e);
        }
    }
}