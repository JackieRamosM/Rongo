<%-- 
    Document   : login
    Created on : 24/06/2014, 11:47:52 PM
    Author     : WINDOWS8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head></head>
<body>
   <h1>Custom Login</h1>
   <form name='f' action="https://auth.espol.edu.ec/login" method='POST'>
      <table>
         <tr>
            <td>User:</td>
            <td><input type='text' name='j_username' value=''></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' name='j_password' /></td>
         </tr>
         <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
         </tr>
      </table>
  </form>
</body>
</html>

