<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<%
if(request.isUserInRole("ROLE_ADMIN")){  
    response.sendRedirect("index2.html");
} %>
<html>
    <form action="A.java"></form>
   <head><title>Hello World JSP Page.</title></head>
        <body>
                
                <font size="10"><%=("no funciona!!!!")%></font>
                <hr/>
                  src=<%=request.getAttribute("imgSrc")%>            
        </body>
</html>