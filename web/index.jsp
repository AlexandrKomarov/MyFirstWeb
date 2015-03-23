<%--
  Created by IntelliJ IDEA.
  User: komarov.as
  Date: 12.03.15
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Решение квадратного уравнения</title>
</head>
<body>


<form action="1" method="post" name="form1">
    <input style="<%=request.getParameter("aStyle")%>" type="text" name="a" size="5"/> <% out.println("x^2 + "); %>
    <input style="<%=request.getParameter("bStyle")%>" type="text" name="b" size="5"/> <% out.println("x + "); %>
    <input style="<%=request.getParameter("cStyle")%>" type="text" name="c" size="5"/> <% out.println("= 0"); %>
    <input type="submit"/>
</form>

</body>
</html>
<%request.getParameterValues("text"); %>