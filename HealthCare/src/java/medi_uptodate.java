import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class medi_uptodate extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
    {
     res.setContentType("text/html");
     PrintWriter pw=res.getWriter();
     String mname=req.getParameter("m5");
     String qty=req.getParameter("m6");
     String expd=req.getParameter("m7");
     String pp=req.getParameter("m8");
     String sp=req.getParameter("m9");
     try
     {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con=DriverManager.getConnection(
             "jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
     Statement stmt=con.createStatement();
     String q1="update medicine_db set qty='"+qty+"',exp_date='"+expd+"',p_price='"+pp+"',s_price='"+sp+"' where name='"+mname+"'";
     ResultSet rs=stmt.executeQuery(q1);
     String q2="select * from medicine_db";
     ResultSet rs2=stmt.executeQuery(q2);
     pw.println("<html><head>\n" +
"        <title>Medicine Update</title>\n" +
"        <style type=\"text/css\">\n" +
"            body{\n" +
"                margin: 0;\n" +
"                background-color: #aaaaaa;\n" +
"            }  \n" +
"            table{\n" +
"                border-collapse: collapse;\n" +
"            }\n" +
"            table th{\n" +
"                text-align: left;\n" +
"                background-color: #3A6070;\n" +
"                color: #fff;\n" +
"                padding:4px 30px 4px 8px; \n" +
"            }\n" +
"            table td{\n" +
"                border: 1px solid #3A6070;\n" +
"                padding: 4px 8px;\n" +
"            }\n" +
"            table tr:nth-child(odd) td{\n" +
"                background-color: aquamarine;\n" +
"            }\n" +
 "                   table tr:nth-child(even) td{\n"+
"                background-color: palegreen;\n"+
"          }\n"+
"            \n" +
"        </style>\n" +
"    </head><body>"+
 "        <table border=\"0\" width=\"100%\" >\n" +
"                 <tr>\n" +
"                 <td align=\"right\">\n" +
"                 <form method=\"post\" action=\"phar_logout\"> \n" +
"                 <input type=\"submit\" value=\"Logout\"> \n" +
"                </form>\n" +
"                 </td>\n" +
"                 </tr>\n" +
"                 </table>\n"+                 
"<table border=2 width=100%><tr><th>S.No</th><th>Category</th><th>Generic</th><th>Company</th><th>Madicine Name</th><th>QTY</th><th>Expire Date</th><th>Purchase Price</th><th>Selling Price</th><th>Update</th></tr>");
           while(rs2.next())
           {
             pw.println("<tr><td>"+rs2.getString(1)+"</td><td>"+rs2.getString(2)+"</td><td>"+rs2.getString(3)+"</td><td>"+rs2.getString(4)+"</td><td>"+rs2.getString(5)+"</td><td>"+rs2.getString(6)+"</td><td>"+rs2.getString(7)+"</td><td>"+rs2.getString(8)+"</td><td>"+rs2.getString(9)+"</td><td><a href=medicine_update?id="+rs2.getString(5)+">Update</a></td></tr>");
           }
           pw.println("</table></body></html>");  
     con.close();
           
     }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}
