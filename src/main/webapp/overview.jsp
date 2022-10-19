<%@ page import="java.util.ArrayList" %>
<%@ page import="fsst.htlklu.htl_factory.Objects.Order" %>
<%@ page import="fsst.htlklu.htl_factory.DAO.OrderDAO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Orders</title>
    <link rel="stylesheet" href="main.css">
</head>
<body>
<h1>Order overview</h1>
<%
    ArrayList<Order> orders = OrderDAO.getAllOrders();
%>
<h2>3D Print</h2>
<div id="overview1">
<table>
    <tr>
        <th>Order Nr.</th>
        <th>Schüler</th>
        <th>Klasse</th>
        <th>Projekt</th>
        <th>Kommentar</th>
        <th>Kategorie</th>
        <th></th>
    </tr>
    <%
        for (Order o:orders) {
            if(o.getCategory().getId() == 1){
            %>
    <tr>
    <td><%=Integer.toString(o.getId())%></td>
    <td><%=o.getStudent()%></td>
    <td><%=o.getS_class()%></td>
    <td><%=o.getProject()%></td>
    <td><%=o.getComment()%></td>
    <td><%=o.getCategory().getName()%></td>
    <td><a href="http://localhost:8080/htl_factory_war_exploded/delete.jsp?id=<%=o.getId()%>"><button>Löschen</button></a></td>
    </tr>
            <%
    }}
    %>
</table>
</div>
<h2>Lasercutter</h2>
<div id="overview2">
<table>
    <tr>
        <th>Order Nr.</th>
        <th>Schüler</th>
        <th>Klasse</th>
        <th>Projekt</th>
        <th>Kommentar</th>
        <th>Kategorie</th>
        <th></th>
    </tr>
    <%
        for (Order o:orders) {
            if(o.getCategory().getId() == 2){
    %>
    <tr>
        <td><%=Integer.toString(o.getId())%></td>
        <td><%=o.getStudent()%></td>
        <td><%=o.getS_class()%></td>
        <td><%=o.getProject()%></td>
        <td><%=o.getComment()%></td>
        <td><%=o.getCategory().getName()%></td>
        <td><a href="http://localhost:8080/htl_factory_war_exploded/delete.jsp?id=<%=o.getId()%>"><button>Löschen</button></a></td>
    </tr>
    <%
        }}
    %>
</table>
</div>
<h2>PCB</h2>
<div id="overview3">
<table>
    <tr>
        <th>Order Nr.</th>
        <th>Schüler</th>
        <th>Klasse</th>
        <th>Projekt</th>
        <th>Kommentar</th>
        <th>Kategorie</th>
        <th></th>
    </tr>
    <%
        for (Order o:orders) {
            if(o.getCategory().getId() == 3){
    %>
    <tr>
        <td><%=Integer.toString(o.getId())%></td>
        <td><%=o.getStudent()%></td>
        <td><%=o.getS_class()%></td>
        <td><%=o.getProject()%></td>
        <td><%=o.getComment()%></td>
        <td><%=o.getCategory().getName()%></td>
        <td><a href="http://localhost:8080/htl_factory_war_exploded/delete.jsp?id=<%=o.getId()%>"><button>Löschen</button></a></td>
    </tr>
    <%
        }}
    %>
</table>
</div>
<div style="padding: 1%">
    <a href="order.jsp">back to order page</a>
</div>
</body>
</html>