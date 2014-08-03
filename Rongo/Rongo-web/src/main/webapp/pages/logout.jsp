<%-- 
    Document   : logout
    Created on : 03/08/2014, 01:35:10 PM
    Author     : Denny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        session.invalidate();
        Cookie access = new Cookie("JSESSIONID", null);
        access.setMaxAge(0);
        access.setPath("/");
        response.addCookie(access);
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", -1); // Proxies.
        response.sendRedirect("https://auth.espol.edu.ec/logout?destination=https://localhost:8181/Rongo-web/");
    %>
</html>
