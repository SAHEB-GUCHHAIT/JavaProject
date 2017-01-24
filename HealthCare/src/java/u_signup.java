import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import HealthPackage.*;
public class u_signup extends HttpServlet 
{
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
    {
        res.setContentType("text/html");
        PrintWriter pw= res.getWriter();
        String uid=req.getParameter("u1");
        String pass=req.getParameter("u2");
        String name=req.getParameter("u3");
        String gender=req.getParameter("u4");
        String dob=req.getParameter("u5");
        String mob=req.getParameter("u6");
        String marital=req.getParameter("u7");
        String address=req.getParameter("u8");
        String security=req.getParameter("u9");
        String ans=req.getParameter("u10");
        u_signupbean ob=new u_signupbean();
        ob.setUid(uid);
        ob.setPass(pass);
        ob.setName(name);
        ob.setGender(gender);
        ob.setDob(dob);
        ob.setMob(mob);
        ob.setMarital(marital);
        ob.setAddress(address);
        ob.setSecurity(security);
        ob.setAns(ans);
        boolean result=ob.InsertMethod();
        if(result==true)
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
"        <h2>Your Successfully Registered.</h2>\n" +
"                 <hr>  \n" +
"                 Go to Login Page<a href=\"u_login.html\">Click Here</a>        \n" +
"        </div>\n" +
"    </body>\n" +
"</html>\n" +
"");
        }
        else
        {
            pw.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>REGISTER failed</title>\n" +
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
"        <h2>Your Registration Failed..</h2>\n" +
"                 <hr>  \n" +
"        </div>\n" +
"    </body>\n" +
"</html>\n" +
"");
        }
    }
}