/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class redirectServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException{
        
        HttpSession session = req.getSession();
        if(session.getAttribute("status")!=null){
        int i=((Integer)session.getAttribute("status")).intValue();
        session.setAttribute("status",new Integer(i+1));
        switch (i){
            case 1:
            res.sendRedirect("/Rongo-web/faces/pages/academico/index.xhtml");
            break;
            case 2:
            res.sendRedirect("/Rongo-web/faces/pages/supervisor/index.xhtml");
            break;
            case 3:
            res.sendRedirect("/Rongo-web/faces/pages/estudiante/index.xhtml");
           break;
           }
        }
   res.sendRedirect("/Rongo-web/redirect.jsp");
        
        
    }
}
