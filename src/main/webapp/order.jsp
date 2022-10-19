<%@ page import="fsst.htlklu.htl_factory.DAO.OrderDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="fsst.htlklu.htl_factory.Objects.Category" %><%--
  Created by IntelliJ IDEA.
  User: stefan
  Date: 02.03.2021
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
    <link rel="stylesheet" href="main.css">
</head>
<body>
<h1>HTL Factory Order System</h1>
<h2>New Order</h2>
<div id="order">
    <form action="confirm.jsp">
        <label for="type">Type of Order:</label>
        <select name="cat" id="type">
            <%
                ArrayList<Category> categories = OrderDAO.getCategories();
                for (Category s:categories) {
            %><option value="<%=Integer.toString(s.getId())%>"><%=s.getName()%></option><%
            }
        %>
        </select><br>
        <label for="s_name">Student/Team:</label>
        <input id="s_name" name="s_name" type="text"><br>
        <label for="s_class">Class:</label>
        <input id="s_class" name="s_class" type="text"><br>
        <label for="project">Project:</label>
        <input id="project" name="project" type="text"><br>
        <label for="comment">Comment:</label>
        <input id="comment" name="comment" type="text"><br>
        <button type="submit">Send</button>
        <input type="reset">
    </form>
</div>
<h2>Overview</h2>
<div id="back">
    <a href="overview.jsp">show order overview</a>
</div>
</body>
</html>
