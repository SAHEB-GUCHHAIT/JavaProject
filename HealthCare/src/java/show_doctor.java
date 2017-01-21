import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class show_doctor extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
    {
     res.setContentType("text/html");
     PrintWriter pw=res.getWriter();
     
     String location=req.getParameter("p5");
     try
     {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con=DriverManager.getConnection(
             "jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
     Statement stmt=con.createStatement();
     String q1="select * from doctors_db where location='"+location+"'";
     ResultSet rs=stmt.executeQuery(q1);
     pw.println("<html>\n" +
"<head>\n" +
"    <title>Patient Details</title>\n" +
"<style type=\"text/css\">\n" +
"            body{\n" +
"                background-image: url(5.jpg);\n" +
"                background-size: cover;\n" +
"            }\n" +
"            h2 {\n" +
"            color: white;\n" +
"            text-align: center;\n" +
"            }\n" +
"\n" +
"            .log input[type=\"submit\"]{\n" +
"                width:150px;\n" +
"                height: 30px;\n" +
"                border: 0;\n" +
"                border-radius: 5px;\n" +
"                -webkit-border-radius: 5px;\n" +
"                background-color: skyblue;\n" +
"                font-weight: bolder;\n" +
"                color: navy;\n" +
"            }\n" +
"            .log input[type=\"reset\"]{\n" +
"                width: 100px;\n" +
"                height: 30px;\n" +
"                border: 0;\n" +
"                border-radius: 5px;\n" +
"                -webkit-border-radius: 5px;\n" +
"                background-color: skyblue;\n" +
"                font-weight: bolder;\n" +
"            }\n" +
"            \n" +
"</style>         \n" +
"</head>\n" +
                 "<table border=\"0\" width=\"100%\" >"+
                 "<tr>"+
                 "<td align=\"right\">"+
                                 "         <form method=\"post\" action=\"logout\">\n" + 
                 " <input type=\"submit\" value=\"Logout\">\n" + 
                 "        </form>    \n" +
                 "</td>"+
                 "</tr>"+
                 "</table>"+
"<body>\n" +
"    <div class=\"log\">\n" +
"<form method=\"post\" action=\"appoint_req\"> \n" +
"<table style=\"width:100%; height:100%\" cellpadding=\"0\" cellspacing=\"0\" >\n" +
"<tr>\n" +
"<td style=\"width: 25%; height: 50px;\" ></td>\n" +
"<td style=\"width: 50%; height: 50px;\" bgcolor=\"#808080\">\n" +
"<table style= \"width:100%; height:100%; border:0\">\n" +
"<tr>\n" +
"<td style=\"width: 100%; height: 95%;\">\n" +
"<table style=\"width:100%; height:100%\">\n" +
"    <tr><td colspan=\"2\"><center><h2>Doctor & Patient Details</h2></center></td></tr>\n" +
"<tr>\n" +
"    <td>Doctor Name:</td>\n" +
"    <td>\n" +
"        <select name=\"p5\">\n" +
"            <option value=\"null\">Choose your doctor</option>");
     while(rs.next())
     {
     pw.println("<option value="+rs.getString(3)+">"+rs.getString(3)+"</option>"); 
     }
     pw.println("</select>\n" +
"    </td>\n" +
"</tr>\n" +
"\n" +
"<tr>\n" +
"<td>Patient Name:</td>\n" +
"<td><input type=\"text\" name=\"p1\" placeholder=\"Enter your name\" required ></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td>Email ID:</td>\n" +
"<td><input type=\"text\" name=\"p2\" placeholder=\"Enter a valid email id\" required ></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td>Mobile No:</td>\n" +
"<td><input type=\"text\" name=\"p3\" placeholder=\"Enter your Phone no.\" required ></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td>Symptoms:</td>\n" +
"<td>\n" +
"<select name=\"p4\">\n" +
"<option value=\"Null\">Choose Your Symptoms</option>\n" +
"<option value=\"fever\">Fever</option>\n" +
"<option value=\"cold\">Cold, Flu, & Cough</option>\n" +
"<option value=\"diabetes\">Diabetes</option>\n" +
"</select>\n" +
"</td></tr>\n" +
"<tr>\n" +
"<td><input type=\"submit\" value=\"Book & Appointment\"></td>\n" +
"<td><input type=\"reset\" value=\"Refresh\"></td>\n" +
"</tr>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</td>\n" +
"<td style=\"width: 25%; height: 50px;\" ></td>\n" +
"</tr>\n" +
"</table>\n" +
"</form>\n" +
"    </div>        \n" +
"</body>\n" +
"</html>");
        
     con.close();
           
     }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}
