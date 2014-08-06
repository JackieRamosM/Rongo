/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jasig.cas.client.authentication.AttributePrincipal;

public class TestCASClient extends HttpServlet 
{
  public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws IOException, ServletException 
  { 
    // The CAS client puts the Principal into the Request:
    AttributePrincipal principal = (AttributePrincipal)req.getUserPrincipal();
    String uni = principal.getName();
  } 
}
