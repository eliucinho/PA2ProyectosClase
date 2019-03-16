<%-- 
    Document   : frmMuro
    Created on : 09-mar-2019, 8:30:23
    Author     : uth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String tablaEstados=(String)request.getSession().getAttribute("tablaEstados");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>uth</title>
    </head>
    <body>
        <h1>Mini Red Social!</h1>
        <h3>Bienvenido, usuario</h3>
        <!-- Aqui van a ir los muros -->
        <form action="" method="">
            <input type="text" name="descripcion">
            <input type="submit" value="publicar">
        </form>
        <%=tablaEstados%>
    </body>
</html>
