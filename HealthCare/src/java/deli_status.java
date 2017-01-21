 import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class deli_status extends HttpServlet 
{
    public void doGet (HttpServletRequest req,HttpServletResponse res) throws 
            ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        HttpSession email=req.getSession();
        String mail=(String)email.getAttribute("nm1"); 
            
        try
        {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection
                   ("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
           Statement stmt=con.createStatement();
           String q1="select * from delivery_status where cid='"+mail+"'";
          
           ResultSet rs=stmt.executeQuery(q1);
           
           pw.println("<html><head>\n" +
"        <title>Delivery Status</title>\n" +
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
                                 "         <form method=\"post\" action=\"logout\">\n" + 
                 " <input type=\"submit\" value=\"Logout\">\n" + 
                 "        </form>    \n" +
                 "</td>"+
                 "</tr>"+
                 "</table>"+
                 "<br>\n"+
                 "<table border=2 width=80% align=center><tr><th>Email ID</th><th>Medicine Name</th><th>Approximate Date of Delivery</th><th>Approximate Time of Delivery</th></tr>");
           while(rs.next())
           {
             pw.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
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

    
    
 