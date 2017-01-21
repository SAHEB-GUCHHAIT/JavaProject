 import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class patient_details extends HttpServlet 
{
    public void doGet (HttpServletRequest req,HttpServletResponse res) throws 
            ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        HttpSession policy=req.getSession();
        String pol=(String)policy.getAttribute("nm1");
        
        try
        {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection
                   ("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
           Statement stmt=con.createStatement();
           String q1="select * from patient where status='No' and policy_no='"+pol+"'";
          
           ResultSet rs=stmt.executeQuery(q1);
           
           pw.println("<html><head>\n" +
"        <title>Patient Request</title>\n" +
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
"                 <form method=\"post\" action=\"d_logout\"> \n" +
"                 <input type=\"submit\" value=\"Logout\"> \n" +
"                </form>\n" +
"                 </td>\n" +
"                 </tr>\n" +
"                 </table>\n"+ 
                   "<table border=2 width=90% align=center><tr><th>Patient Name</th><th>email</th><th>Mobile</th><th>Symptom</th><th>Activate</th></tr>");
           while(rs.next())
           {
             pw.println("<tr><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td><a href=confirmappo?id="+rs.getString(3)+">Confirm</a></td></tr>");
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

    
    
 