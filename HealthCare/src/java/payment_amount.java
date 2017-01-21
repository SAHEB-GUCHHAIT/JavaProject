
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

public class payment_amount extends HttpServlet {

    
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = res.getWriter();
        int count=Integer.parseInt(req.getParameter("p1"));
        HttpSession pno=req.getSession();
        String pnum=(String)pno.getAttribute("pol");
        
        try 
        {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
         Statement stmt=con.createStatement();
         String q1="select * from doctors_db where policy_no='"+pnum+"'";
         ResultSet rs=stmt.executeQuery(q1);
         int tax=(int) ((count*1000*12.5)/100);
         int price=(count*1000)+tax;
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
"                text-align: center;\n" +                 
"                border-radius: 15px;\n" +
"                -webkit-border-radius: 15px;\n" +
"                color: aqua;\n" +
"                font-weight: bolder;\n" +
"                box-shadow: inset 4px 4px rgba(0,0,0,0.8);\n" +
"                font-size: 18px;\n" +
"            }"+
"        </style>\n" +
"        <title>Doctor Payment</title>\n" +
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
"            <form action=\"payment_price\" method=\"post\">\n" +
                 "Doctor's Name=<input type=\"text\" name=\"t3\" value="+rs.getString(3)+" readonly>\n"+
                 "<br>\n"+
                 "<br>\n"+
"                &nbsp;&nbsp;&nbsp;&nbsp;Tax Amount=<input type=\"text\"  name=\"t1\" value="+tax+" readonly>\n" +
"                <br>\n" +
                 "<br>\n"+
"                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Net Price=<input type=\"text\" name=\"t2\" value="+price+" readonly>\n" +
"                <br>\n" +
"                <br>\n" +
                 "Payment L_Date:<input type=\"date\" name=\"t4\" >\n"+
                 "                <br>\n" +
"                <br>\n" +
"                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
"                <input type=\"submit\" value=\"SUBMIT\">\n" +
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
