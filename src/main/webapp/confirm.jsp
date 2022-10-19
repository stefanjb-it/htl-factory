<%@ page import="fsst.htlklu.htl_factory.DAO.OrderDAO" %>
<%@ page import="fsst.htlklu.htl_factory.Objects.Order" %>
<%@ page import="fsst.htlklu.htl_factory.Objects.Category" %><%--
  Created by IntelliJ IDEA.
  User: stefan
  Date: 02.03.2021
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm</title>
    <link rel="stylesheet" href="main.css">
</head>
<body>
<%
    if(request.getParameterMap().containsKey("cat") && request.getParameterMap().containsKey("s_name") && request.getParameterMap().containsKey("s_class") &&
            request.getParameterMap().containsKey("project") && request.getParameterMap().containsKey("comment")){

        int cat_id = Integer.parseInt(request.getParameter("cat"));
        String s_name = request.getParameter("s_name");
        String s_class = request.getParameter("s_class");
        String project = request.getParameter("project");
        String comment = request.getParameter("comment");

        Order order = OrderDAO.addOrder(new Order(s_name, s_class, project, comment, new Category(cat_id)));

        %>
<div id="confirm">
    <h1>Thank you for your order</h1>
    <h2>Your order number is <%=Integer.toString(order.getId())%>.</h2>
    <a href="order.jsp">back to order page</a>
</div>
        <%
    }
%>

</body>
</html>
