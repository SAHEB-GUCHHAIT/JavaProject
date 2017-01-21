
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

public class ppay_amount extends HttpServlet {

    
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = res.getWriter();
        int count=Integer.parseInt(req.getParameter("c1"));
               
        try 
        {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
         Statement stmt=con.createStatement();
         String q1="select * from pharmacist_db";
         ResultSet rs=stmt.executeQuery(q1);
         int tax=(int) ((count*50*12.5)/100);
         int price=(count*50)+tax;
         if(rs.next())
         {
         pw.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <style type=\"text/css\">\n" +
"            body{\n" +
"                background-color: aqua;\n" +
"                background-size: cover;\n" +
"            }\n" +
                 ".log{\n" +
"                width: 440px;\n" +
"                height: 260px;\n" +
"                background-color: rgba(0,0,2,0.5);\n" +
"                margin: 0 auto;\n" +
"                margin-top: 50px;\n" +
"                padding-top: 20px;\n" +
"                padding-left: 50px;\n" +
"                border-radius: 15px;\n" +
"                -webkit-border-radius: 15px;\n" +
"                color: aqua;\n" +
"                font-weight: bolder;\n" +
"                box-shadow: inset 4px 4px rgba(0,0,0,0.8);\n" +
"                font-size: 18px;\n" +
"            }"+
"        </style>\n" +
"        <title>Pharmacist Payment</title>\n" +
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
"        <div class=\"log\">\n" +
"            <form action=\"ppayment_price\" method=\"post\">\n" +
                 "Pharmacy Name=<input type=\"text\" name=\"t1\" value="+rs.getString(3)+" readonly>\n"+
                 "<br>\n"+
                 "<br>\n"+
                 "Pharmacist Email ID=<input type=\"email\" name=\"t2\" value="+rs.getString(1)+" readonly>\n"+
                 "<br>\n"+
                 "<br>\n"+                 
"                &nbsp;&nbsp;&nbsp;&nbsp;Tax Amount=<input type=\"text\"  name=\"t3\" value="+tax+" readonly>\n" +
"                <br>\n" +
                 "<br>\n"+
"                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Net Price=<input type=\"text\" name=\"t4\" value="+price+" readonly>\n" +
"                <br>\n" +
"                <br>\n" +
                 "Payment L_Date:<input type=\"date\" name=\"t5\" >\n"+
                 "                <br>\n" +
"                <br>\n" +
"                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
"                <input type=\"submit\" value=\"submit\">\n" +
"            </form>            \n" +
"        </div>\n" +
"    </body>\n" +
"</html>\n" +
"");
         }
        }
        catch (Exception e) 
        {
         pw.println(e);
        }
        
    }
}
