
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

public class schedule_date extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = res.getWriter();
        String cid=req.getParameter("id");
        try {
          Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection
                   ("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
           Statement stmt=con.createStatement();  
           String s1="select * from order_medicines where email='"+cid+"' and delivery='No'";
           ResultSet rs=stmt.executeQuery(s1);
           if(rs.next())
           {
               pw.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Shipping Address</title>\n" +
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
"        <table border=\"0\" width=\"100%\" >\n" +
"                 <tr>\n" +
"                 <td align=\"right\">\n" +
"                 <form method=\"post\" action=\"p_logout\"> \n" +
"                 <input type=\"submit\" value=\"Logout\"> \n" +
"                </form>\n" +
"                 </td>\n" +
"                 </tr>\n" +
"                 </table>\n" +
"                 <br>\n" +
"                 <hr>\n" +
"        <div class=\"container\">\n" +
"            <form action=\"medi_delivery\" method=\"post\">\n" +
"                 Customer ID:<input type=\"email\" name=\"d3\" value="+rs.getString(2)+" readonly><br><br>\n" +
"                 Medicine:<input type=\"text\" name=\"d4\" value="+rs.getString(6)+" readonly><br><br>\n" + 
                       "Approximate Date of Delivery:\n" +
"                Day:<select name=\"d11\">\n" +
"                    <option value=\"1\">1</option><option value=\"2\">2</option><option value=\"3\">3</option>\n" +
"                    <option value=\"4\">4</option><option value=\"5\">5</option><option value=\"6\">6</option>\n" +
"                    <option value=\"7\">7</option><option value=\"8\">8</option><option value=\"9\">9</option>\n" +
"                    <option value=\"10\">10</option><option value=\"11\">11</option><option value=\"12\">12</option>\n" +
"                    <option value=\"13\">13</option><option value=\"14\">14</option><option value=\"15\">15</option>\n" +
"                    <option value=\"16\">16</option><option value=\"17\">17</option><option value=\"18\">18</option>\n" +
"                    <option value=\"19\">19</option><option value=\"20\">20</option><option value=\"21\">21</option>\n" +
"                    <option value=\"22\">22</option><option value=\"23\">23</option><option value=\"24\">24</option>\n" +
"                    <option value=\"25\">25</option><option value=\"26\">26</option><option value=\"27\">27</option>\n" +
"                    <option value=\"28\">28</option><option value=\"29\">29</option><option value=\"30\">30</option>\n" +
"                    <option value=\"31\">31</option>\n" +
"                    \n" +
"                </select>\n" +
"                Month:<select name=\"d12\">\n" +
"                    <option value=\"jan\">Jan</option>\n" +
"                    <option value=\"feb\">Feb</option>\n" +
"                    <option value=\"mar\">Mar</option>\n" +
"                    <option value=\"apr\">Apr</option>\n" +
"                    <option value=\"may\">May</option>\n" +
"                    <option value=\"jun\">Jun</option>\n" +
"                    <option value=\"jul\">Jul</option>\n" +
"                    <option value=\"aug\">Aug</option>\n" +
"                    <option value=\"sep\">Sep</option>\n" +
"                    <option value=\"oct\">Oct</option>\n" +
"                    <option value=\"nov\">Nov</option>\n" +
"                    <option value=\"dec\">Dec</option>\n" +
"                </select>\n" +
"                <select name=\"d13\">\n" +
"                    <option value=\"2017\">2017</option>\n" +
"                    <option value=\"2018\">2018</option>\n" +
"                    <option value=\"2019\">2019</option>\n" +
"                    <option value=\"2020\">2020</option>\n" +
"                    <option value=\"2021\">2021</option>\n" +
"                    <option value=\"2022\">2022</option>\n" +
"                </select>\n" +
"                <br><br>"+
"                Approximate Time of Delivery:<input type=\"time\" name=\"d2\"><br><br>\n" +
"            <input type=\"submit\" value=\"SUBMIT\">\n" +
"            </form>\n" +
"        </div>\n" +
"    </body>\n" +
"</html>\n" +
"");
           }
           else
               pw.println("Result not found.");
           con.close();
        }
        catch(Exception e)
        {
         pw.println(e);
        }
    }
}
