<%-- 
    Document   : frmLogin
    Created on : 09-mar-2019, 8:31:08
    Author     : uth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>uth</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            try {
                String error = (String)request.getSession().getAttribute("estadoError");

                if (error != null) {
                    out.print("<p style='color:red;'>contrasenia y usuario no valido</p>");
                }
            } catch (Exception e) {
                e.printStackTrace();
                //out.print("<p style='color:red;'>"+e.toString()+"</p>");
            }
        %>
        <form action="servletLogin" method="post">
            usuario:
            <input type="text" name="usuario">
            <br>
            contraseña:
            <input type="password" name="contrasenia">
            <br>
            <input type="submit" value="acceder">                
        </form>
    </body>
</html>
