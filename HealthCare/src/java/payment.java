
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

public class payment extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = res.getWriter();
        String policy=req.getParameter("policyno");
        HttpSession pno=req.getSession();
        pno.setAttribute("pol",policy);
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection
                    ("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
            Statement stmt=con.createStatement();
            String q1="select * from patient where policy_no='"+policy+"' and status='Yes'"; 
            ResultSet rs=stmt.executeQuery(q1);
            int count=0;
            while(rs.next())
            {
             count++;
             
            }
            pw.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Patients</title>\n" +
"        <style type=\"text/css\">\n" +
"            body{\n" +
"                margin: 0;\n" +
"                background-color: #aaaaaa;\n" +
"            }  \n" +
"            .container{\n" +
"                width: 900px;\n" +
"                height: 500px;\n" +
"                text-align: center;\n" +
"                background-color:cyan;\n" +
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
"                 <form method=\"post\" action=\"a_logout\"> \n" +
"                 <input type=\"submit\" value=\"Logout\"> \n" +
"                </form>\n" +
"                 </td>\n" +
"                 </tr>\n" +
"                 </table>\n" +
"        <div class=\"container\">\n" +
"            <form action=\"payment_amount\" method=\"post\">\n" +
"                Number of Patients=<input type=\"text\"  name=\"p1\" value="+count+" readonly>\n" +
"                <br>\n" +
"                <br>\n" +
"                <input type=\"submit\" value=\"submit\">\n" +
"            </form>            \n" +
"        </div>\n" +
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