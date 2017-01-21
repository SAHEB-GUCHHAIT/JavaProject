
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

public class status extends HttpServlet {    
    public void doGet (HttpServletRequest req,HttpServletResponse res) throws 
            ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String email=req.getParameter("a1");
        String date=req.getParameter("a2");
        String time=req.getParameter("a3");
        String address=req.getParameter("a4");
        String d_name=req.getParameter("a5");
        HttpSession policy=req.getSession();
        String pol=(String)policy.getAttribute("nm1");
        try
        {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection
                   ("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
           Statement stmt=con.createStatement();
           String q2="insert into doc_appo values('"+email+"','"+date+"','"+time+"','"+address+"','"+pol+"','"+d_name+"')";
           int y=stmt.executeUpdate(q2);
           if(y>0)
           {
           String q1="update patient set status='Yes' where email='"+email+"'";   
           int x=stmt.executeUpdate(q1);
           
           if(x>0)
           {
            String q3="select * from patient where status='No' and policy_no='"+pol+"'";
          
           ResultSet rs=stmt.executeQuery(q3);
           pw.println("<html><body><table border=2 width=100%><tr><td>Patient Name</td><td>email</td><td>Mobile</td><td>Symptom</td><td>Activate</td></tr>");
           while(rs.next())
           {
             pw.println("<tr><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td><a href=status?id="+rs.getString(3)+">Confirm</a></td></tr>");
           }
           pw.println("</table></body></html>");
           }
           }
          con.close();
           
        }
        catch(Exception e)
        {
            pw.println(e);
        }
        
    }
}
