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
public class confirmappo extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
    {        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = res.getWriter();
        HttpSession policy=req.getSession();
        String pol=(String)policy.getAttribute("nm1");
        String email=req.getParameter("id");
        try
        {
        Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection
                   ("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
           Statement stmt=con.createStatement();
           String q1="select * from patient where policy_no='"+pol+"'";
           ResultSet rs=stmt.executeQuery(q1);
           
           if(rs.next())
           {
           String doctor=rs.getString("doctor");
           
        pw.println("\n" +
"<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title></title>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <div>\n" +
"            <form action=\"status\">\n" +
"             Email ID:\n" +
"             <input type=\"text\" name=\"a1\" value="+email+" readonly>\n" +
"             <br>\n" +
"             Appointment Date:\n" +
"             <input type=\"date\" name=\"a2\">\n" +
"             <br>\n" +
"             Appointment Time:\n" +
"             <input type=\"time\" name=\"a3\">\n" +
"             <br>\n" +
"             <br>\n" +
"             <br>\n" +
"             Doctor's Chamber Address:\n" +
"             <textarea rows=\"4\" cols=\"20\" name=\"a4\"></textarea>\n" +
"             <br>\n" +
                "<input type=\"hidden\" name=\"a5\" value="+doctor+">"+
                "<br>\n"+
"             <input type=\"submit\" value=\"SUBMIT\">\n" +
"            </form>\n" +
"        </div>\n" +
"    </body>\n" +
"</html>\n" +
"");
           }
        }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}
