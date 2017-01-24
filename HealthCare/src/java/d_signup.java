import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class d_signup extends HttpServlet 
{
    public void doPost (HttpServletRequest req,HttpServletResponse res) throws 
            ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw= res.getWriter();
        String did=req.getParameter("doc1");
        String pass=req.getParameter("doc2");
        String name=req.getParameter("doc3");
        String email=req.getParameter("doc4");
        String mob=req.getParameter("doc5");
        String gender=req.getParameter("doc6");
        String dob=req.getParameter("doc7");
        String marital=req.getParameter("doc8");
        String address=req.getParameter("doc9");
        String security=req.getParameter("doc10");
        String ans=req.getParameter("doc11");
        String location=req.getParameter("doc12");
        String specialist=req.getParameter("doc13");
        String status="No";
        try
        {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
           Statement stmt=con.createStatement();
           
           String q1="select * from policy_doc";
            ResultSet rs=stmt.executeQuery(q1);
            int pno=0;
            if(rs.next())
            {
                //pw.println(rs.getString(1));
                pno=Integer.parseInt(rs.getString(1));
                pno=pno+1;
                String q2="insert into doctors_db values('"+did+"','"+pass+"','"+name+"','"+email+"','"+mob+"','"+gender+"'"
                    + ",'"+dob+"','"+marital+"','"+address+"','"+security+"','"+ans+"','"+location+"','"+pno+"','"+specialist+"','"+status+"')";
           int x=stmt.executeUpdate(q2);
           if(x>0)
                   {
                      String q3="insert into policy values('"+pno+"','"+email+"')"; 
                      int y=stmt.executeUpdate(q3);
                      if(y>0)
                      {
                       String q4="update policy_doc set policy_no='"+pno+"'";
                        int z=stmt.executeUpdate(q4);
                         if(z>0)
                         {
                         pw.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>REGISTER SUCCESS</title>\n" +
"        <style type=\"text/css\">\n" +
"            body{\n" +
"                margin: 0;\n" +
"                background-color: #aaaaaa;\n" +
"            }  \n" +
"            .container{\n" +
"                width: 900px;\n" +
"                height: 500px;\n" +
"                text-align: center;\n" +
"                background-color: lightpink;\n" +
"                border-radius: 4px;\n" +
"                margin: 0 auto;\n" +
"                margin-top: 20px;\n" +
"                padding-top: 40px;\n" +
"            } \n" +
"          \n" +
"            \n" +
"        </style>\n" +
"    </head>\n" +
"    <body>\n" +
"        \n" +
"        <div class=\"container\">\n" +
"        <h2>Your Policy No:"+pno+"</h2>\n" +
"                 <hr>  \n" +
"                 Go to Login Page<a href=\"d_login.html\">Click Here</a>        \n" +
"        </div>\n" +
"    </body>\n" +
"</html>\n" +
"");
                         }
                         else
                         {
                         pw.println("Updation Unsuccess");
                         }
                      }
                      else
                      {
                       pw.println("Insert error.");
                      }
                   }
           else
           {
               pw.println("Insert Failed.");
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

    
    





