import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class medi_upload extends HttpServlet 
{
    public void doPost (HttpServletRequest req,HttpServletResponse res) throws 
            ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter(); 
        String sno=req.getParameter("m1");
        String catego=req.getParameter("m2");
        String generic=req.getParameter("m3");
        String comp=req.getParameter("m4");
        String name=req.getParameter("m5");
        String qty=req.getParameter("m6");
        String expdate=req.getParameter("m7");
        String pp=req.getParameter("m8");
        String sp=req.getParameter("m9");
        try
        {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
           Statement stmt=con.createStatement();
           String q1="insert into medicine_db values('"+sno+"','"+catego+"','"+generic+"','"+comp+"','"+name+"','"+qty+"','"+expdate+"','"+pp+"','"+sp+"')";
           int x=stmt.executeUpdate(q1);
           if(x>0)
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
"                width: 1200px;\n" +
"                height: 550px;\n" +
"                text-align: center;\n" +
"                background-color: lightpink;\n" +
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
"                 <form method=\"post\" action=\"phar_logout\"> \n" +
"                 <input type=\"submit\" value=\"Logout\"> \n" +
"                </form>\n" +
"                 </td>\n" +
"                 </tr>\n" +
"                 </table>\n" +
"                 <br>\n" +
"                 <hr>\n" +
"        <div class=\"container\">\n" +
"            \n" +
"            <a href=medi_view?id=><h3>Stocks Medicine</h3></a>\n" +
"                <br>\n" +
"                <a href=\"medi_update.html\"><h3>Update Stocks</h3></a>\n" +
"                <br>\n" +
                 "<a href=\"upload.html\"><h3>Upload Medicine</h3></a>\n" +
"                <br>\n" +
"                <a href=medi_req?id=><h3>Requested Medicine by Patient</h3></a>\n" +
"                <br>\n" +
"                <a href=medi_dispatch?id=><h3>Dispatch Status</h3></a>\n" +
"                <br>\n" +
"                <a href=\"phar_feed.html\"><h3>Feedback</h3></a>\n" +
"                <br>\n" +
"        </div>\n" +
"    </body>\n" +
"</html>");
                   }
           else
           {
               pw.println("Insert Failed.");
           }
           con.close();
           
        }
        catch(Exception e)
        {
            pw.println(e);
        }
        
    }
}

    
    
