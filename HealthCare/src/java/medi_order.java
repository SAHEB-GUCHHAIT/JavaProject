
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class medi_order extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = res.getWriter();
        HttpSession email=req.getSession();
        String mail=(String)email.getAttribute("nm1");
        String name=req.getParameter("a1");
        String pin=req.getParameter("a3");
        String add=req.getParameter("a4");
        String mob=req.getParameter("a5");
        String medicine=req.getParameter("m1");
        String status="No";
        try 
        {
         Class.forName("oracle.jdbc.driver.OracleDriver");   
         Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
         Statement stmt=con.createStatement();
         String q1="insert into order_medicines values('"+name+"','"+mail+"','"+pin+"','"+add+"','"+mob+"','"+medicine+"','"+status+"')";
         int x=stmt.executeUpdate(q1);
         if(x>0)
         {
             pw.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Orders Medicines</title>\n" +
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
"                 <form method=\"post\" action=\"u_logout\"> \n" +
"                 <input type=\"submit\" value=\"Logout\"> \n" +
"                </form>\n" +
"                 </td>\n" +
"                 </tr>\n" +
"                 </table>\n" +
"                 <br>\n" +
"                 <hr>\n" +
"        <div class=\"container\">\n" +
"        <h3><b>Order Generate Successfully.</b></h3>   "+
"        </div>\n" +
"    </body>\n" +
"</html>\n" +
"");
         }
         else
         {
             pw.println("Insert Failed");
         }
        } 
        catch(Exception e)
        {
          pw.println(e);
        }
    }
}
