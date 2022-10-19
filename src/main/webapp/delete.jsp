<%@ page import="fsst.htlklu.htl_factory.DAO.OrderDAO" %>
<%@ page import="fsst.htlklu.htl_factory.Objects.Order" %><%--
  Created by IntelliJ IDEA.
  User: stefan
  Date: 03.04.2021
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="refresh" content="0.1; URL=http://localhost:8080/htl_factory_war_exploded/overview.jsp">
</head>
<body>
<%
    if(request.getParameterMap().containsKey("id")){
        OrderDAO.deleteOrder(new Order(Integer.parseInt(request.getParameter("id"))));
    }
%>


</body>
</html>
