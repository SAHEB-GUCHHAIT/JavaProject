import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class phar_signup extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
    {
        res.setContentType("text/html");
        PrintWriter pw= res.getWriter();
        String pid=req.getParameter("p1");
        String pass=req.getParameter("p2");
        String name=req.getParameter("p3");
        String email=req.getParameter("p4");
        String mob=req.getParameter("p5");
        String address=req.getParameter("p6");
        String security=req.getParameter("p7");
        String ans=req.getParameter("p8");
        String status="No";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
            Statement stmt=con.createStatement();
            String q1="insert into pharmacist_db values('"+pid+"','"+pass+"','"+name+"','"+email+"'"
                    + ",'"+mob+"','"+address+"','"+security+"','"+ans+"','"+status+"')";
            int x=stmt.executeUpdate(q1);
            if(x>0)
            {
                pw.println("success");
            }
            else
            {
                pw.println("unsuccess");
            }
            
        }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}