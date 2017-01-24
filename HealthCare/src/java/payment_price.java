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

public class payment_price extends HttpServlet {    
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = res.getWriter();
        HttpSession pno=req.getSession();
        String policyno=(String)pno.getAttribute("pol");
        String name=req.getParameter("t3");
        String price=req.getParameter("t2");
        String l_date=req.getParameter("t4");
        String status="Not_paid";
        try 
        {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
          Statement stmt=con.createStatement();
          String q2="Select * from doc_pay where doc_policyno='"+policyno+"' and status='Not_paid'";
          ResultSet rs=stmt.executeQuery(q2);
          if(rs.next())
          {
           pw.println( "   <head>\n" +
"        <style type=\"text/css\">\n" +
"            body{\n" +
"                background-color: aqua;\n" +
"                background-size: cover;\n" +
"            }\n" +
                 ".log{\n" +
"                width: 640px;\n" +
"                height: 360px;\n" +
"                background-color: rgba(0,0,2,0.5);\n" +
"                margin: 0 auto;\n" +
"                margin-top: 20px;\n" +
"                padding-top: 20px;\n" +
"                padding-left: 0px;\n" +
"                text-align: center;\n" +                   
"                border-radius: 15px;\n" +
"                -webkit-border-radius: 15px;\n" +
"                color: aqua;\n" +
"                font-weight: bolder;\n" +
"                box-shadow: inset 4px 4px rgba(0,0,0,0.8);\n" +
"                font-size: 18px;\n" +
"            }"+
"        </style>\n" +
"        <title>Payment status</title>\n" +
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
                      "<h2><b>Already Created.</b></h2>"+
                  " <hr>  \n" +
"                 <p align=center>Go to Home Page<a href=\"AdminHome.html\">Click Here</a></p>"+
                      "</div>"+
                  "</body>\n");
          }
          else
          {
              
            String q1="insert into doc_pay values('"+policyno+"','"+price+"','"+name+"','"+status+"','"+l_date+"')";
            int x=stmt.executeUpdate(q1);
            if(x>0)
            {
              pw.println("    <head>\n" +
"        <style type=\"text/css\">\n" +
"            body{\n" +
"                background-color: aqua;\n" +
"                background-size: cover;\n" +
"            }\n" +
                 ".log{\n" +
"                width: 640px;\n" +
"                height: 360px;\n" +
"                background-color: rgba(0,0,2,0.5);\n" +
"                margin: 0 auto;\n" +
"                margin-top: 20px;\n" +
"                padding-top: 20px;\n" +
"                text-align:center;\n"+                      
"                padding-left: 0px;\n" +
"                border-radius: 15px;\n" +
"                -webkit-border-radius: 15px;\n" +
"                color: aqua;\n" +
"                font-weight: bolder;\n" +
"                box-shadow: inset 4px 4px rgba(0,0,0,0.8);\n" +
"                font-size: 18px;\n" +
"            }"+
"        </style>\n" +
"        <title>Payment status</title>\n" +
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
                      "<h2><b>Payment generate Successfully.</b></h2>"+
                      "<hr>  \n" +
"                 <p align=center>Go to Home Page<a href=\"AdminHome.html\">Click Here</a></p>"+
                      "</div>"+
                  "</body>\n");
            }
            else
            {
              pw.println("unsuccess");
            }
          }
        } 
        catch(Exception e)
        {
        pw.println(e);
        }
    }
}
