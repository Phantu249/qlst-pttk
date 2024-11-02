<%@ page import="models.NguoiDung754" %><%--
  Created by IntelliJ IDEA.
  User: loinh
  Date: 10/18/2024
  Time: 10:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    NguoiDung754 user = (NguoiDung754) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("login");
        return;
    }
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>QLST</title>
</head>
<body>
<h1>Chao mung <%= user.getTen() %> den voi QLST</h1>
<br>
<button onclick="window.location.href='tim-kiem-mat-hang'">Tim kiem mat hang</button>
<button onclick="window.location.href='duyet-don'">Duyet don</button>
<br/>
</body>
</html>
