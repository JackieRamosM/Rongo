<%-- 
    Document   : redirect
    Created on : 30/07/2014, 04:14:44 AM
    Author     : SEHORE
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        if(session.getAttribute("status")!=null){
        int i=((Integer)session.getAttribute("status")).intValue();
        session.setAttribute("status",new Integer(i+1));
        switch (i){
            case 1:
            response.sendRedirect("/Rongo-web/faces/pages/academico/index.xhtml");
            break;
            case 2:
            response.sendRedirect("/Rongo-web/faces/pages/admin/index.xhtml");
            break;
            case 3:
            response.sendRedirect("/Rongo-web/faces/pages/supervisor/index.xhtml");
           break;
           }
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <%=session.getAttribute("name")%>!</h1>
        <h1>Lamento decirte que no estas autorizado(a) a entrar a esta pagina</h1>
    </body>
</html>
