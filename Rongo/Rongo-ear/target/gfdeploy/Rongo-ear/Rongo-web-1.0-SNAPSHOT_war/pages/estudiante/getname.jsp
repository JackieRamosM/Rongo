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
        response.sendRedirect("faces/pages/estudiante/index.xhtml");
        %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
