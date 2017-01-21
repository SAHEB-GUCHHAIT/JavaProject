/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 *
 * @author SAHEB GUCHHAIT
 */
public class medicine_update extends HttpServlet {
    
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
    {
     res.setContentType("text/html");
     PrintWriter pw=res.getWriter();
     String medi_name=req.getParameter("id");
     try
     {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con=DriverManager.getConnection(
             "jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
     Statement stmt=con.createStatement();
     String q1="select * from medicine_db where name='"+medi_name+"'";
     ResultSet rs=stmt.executeQuery(q1);
     if(rs.next())
     {
     pw.println("<!--\n" +
"To change this template, choose Tools | Templates\n" +
"and open the template in the editor.\n" +
"-->\n" +
"<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Update medicine</title>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"    </head>\n" +
"    <body bgcolor=\"pink\">\n" +
"               <table border=\"0\" width=\"100%\" >\n" +
"               <tr>\n" +
"               <td align=\"right\">\n" +
"               <form method=\"post\" action=\"phar_logout\">\n" +
"               <input type=\"submit\" value=\"Logout\">\n" +
"               </form>\n" +
"               </td>\n" +
"               </tr>\n" +
"               </table>\n" +
"               <br>\n" +
"               <hr>                                \n" +
"        <div>\n" +
"<form method=\"post\" action=\"medi_uptodate\"> \n" +
"<center><h2><font color=\"green\">Drug Details</font></h2></center>\n" +
"<table style=\"width:100%; height:100%\" cellpadding=\"0\" cellspacing=\"0\" >\n" +
"<tr>\n" +
"<td style=\"width: 30%; height: 50px;\" ></td>\n" +
"<td style=\"width: 40%; height: 50px;\" bgcolor=\"#808080\">\n" +
"    \n" +
"    <table style= \"width:100%; height:100%; border:0\">\n" +
"\n" +
"<tr>\n" +
"<td style=\"width: 100%; height: 95%;\">\n" +
"<table style=\"width:100%; height:100%\">\n" +
"    \n" +
"<tr>\n" +
"    <td>S.No:<font color=\"red\">*</font></td>\n" +
"<td><input type=\"text\" name=\"m1\" value="+rs.getString(1)+" readonly></td>\n" +
"\n" +
"</tr>\n" +
"<tr>\n" +
"<td>Pharmacy Category:</td>\n" +
"<td><input type=\"text\" name=\"m2\" value="+rs.getString(2)+" readonly></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td>Medicine Generic:</td>\n" +
"<td><input type=\"text\" name=\"m3\" value="+rs.getString(3)+" readonly></td>\n" +
"</tr>\n" +
"\n" +
"<tr>\n" +
"<td>Manufacturer Company:</td>\n" +
"<td><input type=\"text\" name=\"m4\" value="+rs.getString(4)+" readonly></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td>Medicine Name:</td>\n" +
"<td><input type=\"text\" name=\"m5\" value="+rs.getString(5)+" readonly></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td>Total QTY:</td>\n" +
"<td><input type=\"text\" name=\"m6\" value="+rs.getString(6)+"></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td>Expire Date:</td>\n" +
"<td><input type=\"date\" name=\"m7\" value="+rs.getString(7)+"></td>\n" +
"</tr>\n" +
"<tr>\n" +
"    <td>Purchase price:</td>\n" +
"<td><input type=\"text\" name=\"m8\" value="+rs.getString(8)+"></td>\n" +
"</tr>\n" +
"<tr>\n" +
"    <td>Selling price:</td>\n" +
"<td><input type=\"text\" name=\"m9\" value="+rs.getString(9)+"></td>\n" +
"</tr>\n" +
"<br>\n" +
"<tr>\n" +
"<td><input type=\"submit\" value=\"Update\"></td>\n" +
"<td><input type=\"reset\" value=\"Refresh\"></td>\n" +
"</tr>\n" +
"</table>\n" +
"\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</td>\n" +
"<td style=\"width: 30%; height: 50px;\" >\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"</form>\n" +
"        </div>\n" +
"    </body>\n" +
"</html>\n" +
"");
     }
        
     con.close();
           
     }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}
