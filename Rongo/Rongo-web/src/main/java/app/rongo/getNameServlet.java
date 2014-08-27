/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo;

/**
 *
 * @author SEHORE
*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WINDOWS8
 */
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class getNameServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException{
HttpSession session = req.getSession();
session.setAttribute("name",req.getRemoteUser());
session.setAttribute("status",new Integer(1));
res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
res.setDateHeader("Expires",-1);
res.sendRedirect("faces/pages/estudiante/index.xhtml");
    }
}