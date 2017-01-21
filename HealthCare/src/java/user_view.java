import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class user_view extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
    {
     res.setContentType("text/html");
     PrintWriter pw=res.getWriter();
     String symtom=req.getParameter("s1");
     String days=req.getParameter("s2");
     if((symtom.equals("fever"))&&(days.equals("day1")))
             {
               pw.println("<!DOCTYPE html>\n" +
"\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Recommended Medicine</title>\n" +
"        <style type=\"text/css\">\n" +
"            body{\n" +
"                background-image: url(wide.jpg);\n" +
"                background-size: cover;\n" +
"            }\n" +
"            .log{\n" +
"                width: 720px;\n" +
"                height: 520px;\n" +
"                background-color: rgba(0,0,2,0.5);\n" +
"                margin: 0 auto;\n" +
"                margin-top: 30px;\n" +
"                padding-top: 10px;\n" +
"                padding-left: 50px;\n" +
"                border-radius: 15px;\n" +
"                -webkit-border-radius: 15px;\n" +
"                color: gold;\n" +
"                font-weight: bolder;\n" +
"                box-shadow: inset 4px 4px rgba(0,0,0,0.8);\n" +
"                font-size: 18px;\n" +
"            }\n" +
"            .log input[type=\"text\"]{\n" +
"                width: 200px;\n" +
"                height: 35px;\n" +
"                border: 0;\n" +
"                border-radius: 5px;\n" +
"                -webkit-border-radius: 5px;\n" +
"                padding-left: 5px;\n" +
"                background-color:  lightgray;\n" +
"            }\n" +
"            .log input[type=\"password\"]{\n" +
"                width: 200px;\n" +
"                height: 35px;\n" +
"                border: 0;\n" +
"                border-radius: 5px;\n" +
"                -webkit-border-radius: 5px;\n" +
"                padding-left: 5x;\n" +
"                background-color: lightgray;\n" +
"            }\n" +
"            .log input[type=\"submit\"]{\n" +
"                width: 180px;\n" +
"                height: 35px;\n" +
"                border: 0;\n" +
"               \n" +
"                border-radius: 5px;\n" +
"                -webkit-border-radius: 5px;\n" +
"                background-color: skyblue;\n" +
"                font-weight: bolder;\n" +
"            } \n" +
"            .log img{\n" +
"                height: 80px;\n" +
"                width: 200px;\n" +
"            }\n" +
"        </style>\n" +
"    </head>\n" +
"    <body>\n" +
                 "<table border=\"0\" width=\"100%\" >"+
                 "<tr>"+
                 "<td align=\"right\">"+
                                 "         <form method=\"post\" action=\"logout\">\n" + 
                 " <input type=\"submit\" value=\"Logout\">\n" + 
                 "        </form>    \n" +
                 "</td>"+
                 "</tr>"+
                 "</table>"+
"        <div class=\"log\">\n" +
"            <h3>Aspirin</h3>\n" +
"            <img src=\"aspirin.jpg\">\n" +
"            <p>\n" +
"            Aspirin is used to reduce fever and relieve mild to moderate pain from conditions such as\n" +
"            muscle aches, toothaches, common cold, and headaches. It may also be used to reduce pain \n" +
"            and swelling in conditions such as arthritis. Aspirin is known as a salicylate and a \n" +
"            nonsteroidal anti-inflammatory drug (NSAID). It works by blocking a certain natural \n" +
"            substance in your body to reduce pain and swelling(<u>Consult your doctor before treating \n" +
"                a child younger than 12 years</u>).<br>\n" +
"           Your doctor may direct you to take a low dose of aspirin to prevent blood clots.\n" +
"           This effect reduces the risk of stroke and heart attack. If you have recently had \n" +
"           surgery on clogged arteries (such as bypass surgery, carotid endarterectomy,\n" +
"           coronary stent), your doctor may direct you to use aspirin in low doses as a \"blood thinner\"\n" +
"           to prevent blood clots.\n" +
"            </p> \n" +
"        <a href=\"booking.html\">PLACE ORDER</a>\n" +                      
"            \n" +
"           <br>"+                       
"        Do you want Appointment a Doctor?     \n" +
"        <a href=\"location.html\">GET APPOINTMENT</a>\n" +
"           \n" +
"        </div>\n" +
"    </body>\n" +
"</html>");
    }
     else if((symtom.equals("cold"))&&(days.equals("day1")))
    {
        pw.println("<!DOCTYPE html>\n" +
"\n" +
"<html>\n" +
"    <head>\n" +
"        <title></title>\n" +
"        <style type=\"text/css\">\n" +
"            body{\n" +
"                background-image: url(wide.jpg);\n" +
"                background-size: cover;\n" +
"            }\n" +
"            .log{\n" +
"                width: 720px;\n" +
"                height: 520px;\n" +
"                background-color: rgba(0,0,2,0.5);\n" +
"                margin: 0 auto;\n" +
"                margin-top: 30px;\n" +
"                padding-top: 10px;\n" +
"                padding-left: 50px;\n" +
"                border-radius: 15px;\n" +
"                -webkit-border-radius: 15px;\n" +
"                color: gold;\n" +
"                font-weight: bolder;\n" +
"                box-shadow: inset 4px 4px rgba(0,0,0,0.8);\n" +
"                font-size: 18px;\n" +
"            }\n" +
"            .log input[type=\"text\"]{\n" +
"                width: 200px;\n" +
"                height: 35px;\n" +
"                border: 0;\n" +
"                border-radius: 5px;\n" +
"                -webkit-border-radius: 5px;\n" +
"                padding-left: 5px;\n" +
"                background-color:  lightgray;\n" +
"            }\n" +
"            .log input[type=\"password\"]{\n" +
"                width: 200px;\n" +
"                height: 35px;\n" +
"                border: 0;\n" +
"                border-radius: 5px;\n" +
"                -webkit-border-radius: 5px;\n" +
"                padding-left: 5x;\n" +
"                background-color: lightgray;\n" +
"            }\n" +
"            .log input[type=\"submit\"]{\n" +
"                width: 180px;\n" +
"                height: 35px;\n" +
"                border: 0;\n" +
"               \n" +
"                border-radius: 5px;\n" +
"                -webkit-border-radius: 5px;\n" +
"                background-color: skyblue;\n" +
"                font-weight: bolder;\n" +
"            } \n" +
"            .log img{\n" +
"                height: 80px;\n" +
"                width: 200px;\n" +
"            }\n" +
"        </style>\n" +
"    </head>\n" +
"    <body>\n" +
"        <div class=\"log\">\n" +
"            <h3>Nasal decongestant</h3>\n" +
"            <img src=\"cold.jpeg\">\n" +
"            <p>\n" +
"            Cold and Flu Overview\n" +
"            The common cold, including chest cold and head cold, and seasonal flu are caused by viruses.\n" +
"            Use over-the-counter cold medications to relieve symptoms including sore throat, runny nose,\n" +
"            congestion, and cough. Flu symptoms are similar, but include fever, headache and muscle\n" +
"            soreness. See a doctor who may prescribe antiviral medications Relenza or Tamiflu.\n" +
"            <br>\n" +
"            Sneezing, sore throat, a stuffy nose, coughing -- everyone knows the symptoms of the common \n" +
"            cold. It is probably the most common illness. Every year, adults get about 2-3 colds, and \n" +
"            children get even more.What can you do for your cold or cough symptoms? Besides drinking \n" +
"            lots of fluids and getting plenty of rest, you may decide to take medicines. There are\n" +
"            lots of different cold and cough medicines, and they do different things.Nasal decongestants\n" +
"            - unclog a stuffy nose Cough suppressants - quiet a cough Expectorants - loosen mucus so you\n" +
"            can cough it up Antihistamines - stop runny noses and sneezing Pain relievers - ease fever,\n" +
"            headaches, and minor aches and pains\n" +
"            </p> \n" +
"            \n" +
"        Do you want Appointment a Doctor?     \n" +
"        <a href=\"location.html\">GET APPOINTMENT</a>\n" +
"           \n" +
"        </div>\n" +
"    </body>\n" +
"</html>");
    }
     else
     {
         if((symtom.equals("diabetes"))&&(days.equals("day1")))
     {
        pw.println("<!DOCTYPE html>\n" +
"\n" +
"<html>\n" +
"    <head>\n" +
"        <title></title>\n" +
"        <style type=\"text/css\">\n" +
"            body{\n" +
"                background-image: url(wide.jpg);\n" +
"                background-size: cover;\n" +
"            }\n" +
"            h3 {\n" +
"            color: white;\n" +
"            text-align: center;\n" +
"            }\n" +
"            .log{\n" +
"                width: 720px;\n" +
"                height: 520px;\n" +
"                background-color: rgba(0,0,2,0.5);\n" +
"                margin: 0 auto;\n" +
"                margin-top: 30px;\n" +
"                padding-top: 10px;\n" +
"                padding-left: 50px;\n" +
"                border-radius: 15px;\n" +
"                -webkit-border-radius: 15px;\n" +
"                color: gold;\n" +
"                font-weight: bolder;\n" +
"                box-shadow: inset 4px 4px rgba(0,0,0,0.8);\n" +
"                font-size: 18px;\n" +
"            }\n" +
"            .log input[type=\"text\"]{\n" +
"                width: 200px;\n" +
"                height: 35px;\n" +
"                border: 0;\n" +
"                border-radius: 5px;\n" +
"                -webkit-border-radius: 5px;\n" +
"                padding-left: 5px;\n" +
"                background-color:  lightgray;\n" +
"            }\n" +
"            .log input[type=\"password\"]{\n" +
"                width: 200px;\n" +
"                height: 35px;\n" +
"                border: 0;\n" +
"                border-radius: 5px;\n" +
"                -webkit-border-radius: 5px;\n" +
"                padding-left: 5x;\n" +
"                background-color: lightgray;\n" +
"            }\n" +
"            .log input[type=\"submit\"]{\n" +
"                width: 180px;\n" +
"                height: 35px;\n" +
"                border: 0;\n" +
"               \n" +
"                border-radius: 5px;\n" +
"                -webkit-border-radius: 5px;\n" +
"                background-color: skyblue;\n" +
"                font-weight: bolder;\n" +
"            } \n" +
"            .log img{\n" +
"                height: 80px;\n" +
"                width: 200px;\n" +
"            }\n" +
"        </style>\n" +
"    </head>\n" +
"    <body>\n" +
"        <div class=\"log\">\n" +
"            <h3>Diabetes-metformin</h3>\n" +
"            <img src=\"Diabetes-metformin.jpg\">\n" +
"            <p>\n" +
"            Diabetes Overview\n" +
"            Diabetes is a number of diseases that involve problems with the hormone insulin. Normally,\n" +
"            the pancreas (an organ behind the stomach) releases insulin to help your body store and use\n" +
"            the sugar and fat from the food you eat. Diabetes can occur when the pancreas produces very\n" +
"            little or no insulin, or when the body does not respond appropriately to insulin. As yet,\n" +
"            there is no cure. People with diabetes need to manage their disease to stay healthy.\n" +
"\n" +
"            </p> \n" +
"            \n" +
"        \n" +
"        Do you want Appointment a Doctor?     \n" +
"        <a href=\"location.html\">GET APPOINTMENT</a>\n" +
"           \n" +
"        </div>\n" +
"    </body>\n" +
"</html>");
     } 
         
         else if((symtom.equals("fever"))&&(days.equals("day7")))
     {
     pw.println("For 7 days fever");
     }
     else
{
  if ((symtom.equals("cold"))&&(days.equals("day7")))
  {
     pw.println("for 7 days cold");
  }
  else if((symtom.equals("diabetes"))&&(days.equals("day7")))
  {
    pw.println("for 7 dAYS DIAbeties.");
  }
  else
  {
      if ((symtom.equals("fever"))&&(days.equals("days")))
      {
       pw.println("over days fever");
      }
      else if((symtom.equals("cold"))&&(days.equals("days")))
      {
        pw.println("over days cold");
      }
      else
      {
          if ((symtom.equals("diabetes"))&&(days.equals("days")))
            {
            pw.println("over days diabetes.");
            }
            else
            {
            pw.println("<!DOCTYPE html>\n" +
"\n" +
"<html>\n" +
"    <head>\n" +
"        <title></title>\n" +
"        <style type=\"text/css\">\n" +
"            body{\n" +
"                background-image: url(wide.jpg);\n" +
"                background-size: cover;\n" +
"            }\n" +
"            h3 {\n" +
"            color: white;\n" +
"            text-align: center;\n" +
"            }\n" +
"        </style>\n" +
"    </head>\n" +
"    <body>\n" +
   "        \n" +
"        Do you want Appointment a Doctor?     \n" +
"        <a href=\"location.html\">GET APPOINTMENT</a>\n" +
"           \n" +
"    </body>\n" +
"</html>");
            }
      }
        
  }
  
}
     
     
    }
  }
}
