
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

public class medi_delivery extends HttpServlet {    
    public void doPost (HttpServletRequest req,HttpServletResponse res) throws 
            ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String cid=req.getParameter("d3");
        String medi=req.getParameter("d4");
        String day=req.getParameter("d11");
        String month=req.getParameter("d12");
        String year=req.getParameter("d13");
        String time=req.getParameter("d2");
        try
        {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection
                   ("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
           Statement stmt=con.createStatement();
           String q4="insert into delivery_status values('"+cid+"','"+medi+"','"+day+"','"+month+"','"+year+"','"+time+"')";
           int y=stmt.executeUpdate(q4);
           if(y>0)
           {
           String q1="update order_medicines set delivery='Yes' where email='"+cid+"'";   
           int x=stmt.executeUpdate(q1);
           if(x>0)
           {
           String q2="select * from order_medicines where delivery='No'";
           ResultSet rs=stmt.executeQuery(q2);
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
                   "        <table border=\"0\" width=\"100%\" >\n" +
"                 <tr>\n" +
"                 <td align=\"right\">\n" +
"                 <form method=\"post\" action=\"p_logout\"> \n" +
"                 <input type=\"submit\" value=\"Logout\"> \n" +
"                </form>\n" +
"                 </td>\n" +
"                 </tr>\n" +
"                 </table>\n" +
                   "<table border=2 width=100%><tr><th>Customer Name</th><th>Email</th><th>Pincode</th><th>Address</th><th>Mobile</th><th>Medicine</th><th>Delivery</th></tr>");
           while(rs.next())
           {
             pw.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td><a href=medi_delivery?id="+rs.getString(2)+">Confirm</a></td></tr>");
           }
           pw.println("</table></body></html>");
           }
           }
           else
               pw.println("Insertion Problem.");
           
          con.close();
           
        }
        catch(Exception e)
        {
            pw.println(e);
        }
        
    }
}
