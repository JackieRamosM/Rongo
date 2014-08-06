<%-- 
    Document   : getname
    Created on : 30/07/2014, 05:09:19 AM
    Author     : SEHORE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        session.setAttribute("name",request.getRemoteUser());
        session.setAttribute("status",new Integer(1));
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", -1); // Proxies.
        response.sendRedirect("faces/pages/estudiante/index.xhtml");
    %>
</html>
