
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

public class doctor_feed extends HttpServlet {

    
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = res.getWriter();
        
        try 
        {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
         Statement stmt=con.createStatement();
         String q1="select * from dfeedback";
         ResultSet rs=stmt.executeQuery(q1);
         int count=0;
         pw.println("<html><head>\n" +
"        <title>Doctor's Feedback</title>\n" +
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
"                 <form method=\"post\" action=\"a_logout\"> \n" +
"                 <input type=\"submit\" value=\"Logout\"> \n" +
"                </form>\n" +
"                 </td>\n" +
"                 </tr>\n" +
"                 </table>\n"+
           "<table border=2 width=80% align=center><tr><th>Name </th><th>Type</th><th>Feedback</th><th>Email</th><th>Mobile</th></tr>");
           while(rs.next())
           {
             pw.println("<tr><td>"+rs.getString(3)+" "+rs.getString(4)+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td></tr>");
            count++;
           }
           pw.println("</table><hr>  \n" +
"                 <p align=center>Go to Home Page<a href=\"AdminHome.html\">Click Here</a></p></body></html>");
        }           
        catch(Exception e) 
        {
            pw.println(e);
        }

   
}
}
