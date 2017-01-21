
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logout extends HttpServlet {    
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
     HttpSession  session=req.getSession(false);
      if(session!=null)
      {
          session.invalidate();
      }
      getServletContext().getRequestDispatcher("/u_login.html").forward(req, res);
    } 
}
