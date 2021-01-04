<%-- 
    Document   : uno
    Created on : 13/08/2020, 11:41:22 AM
    Author     : Polupero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int a, b, c;
            a = Integer.parseInt(request.getParameter("opA"));
            b = Integer.parseInt(request.getParameter("opB"));
            c = a + b;
            response.getWriter().print("<br><br>La suma de " + a + " y " + b + " es " + c);
        %>
    </body>
</html>
