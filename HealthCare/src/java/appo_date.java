
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

public class appo_date extends HttpServlet {

    
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = res.getWriter();
        HttpSession email=req.getSession();
        String mail=(String)email.getAttribute("nm1");
        try 
        {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
         Statement stmt=con.createStatement();
         String q1="select * from doc_appo where email='"+mail+"'";
         ResultSet rs=stmt.executeQuery(q1);
         int count=0;
         pw.println("<html><head>\n" +
"        <title>Appoenment Details</title>\n" +
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
                  "<table border=\"0\" width=\"100%\" >"+
                 "<tr>"+
                 "<td align=\"right\">"+
                 "<form method=\"post\" action=\"logout\">\n" + 
                 "<input type=\"submit\" value=\"Logout\">\n" + 
                 "</form>\n" +
                 "</td>"+
                 "</tr>"+
                 "</table>"+
                 "<table border=2 width=100%><tr ><td colspan=5 align=center><h3><b>Apppoint Date & Time</b></h3></td></tr><tr><th>Email</th><th>Appointment Date</th><th>Time</th><th>Doctor Name</th><th>Address</th></tr>");
           while(rs.next())
           {
             pw.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(4)+"</td></tr>");
            count++;
           }
           pw.println("</table>"+
 "                                    <hr>  \n" +
"                 <p align=center>Go to Home Page<a href=\"UserHome.html\">Click Here</a></p>"+
                    "</body></html>");
        }           
        catch(Exception e) 
        {
            pw.println(e);
        }

   
}
}
