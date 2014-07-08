<%-- 
    Document   : test
    Created on : 05/07/2014, 07:56:21 PM
    Author     : José Luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>Este es el usuario logado: <%=request.getRemoteUser() %></p>  
        <p>Nombre: <%=request.getUserPrincipal().getName()%></p> 
    </body>
</html>
