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
            pw.println("Success");
        }
        else
        {
            pw.println("Unsuccess");
        }
    }
}