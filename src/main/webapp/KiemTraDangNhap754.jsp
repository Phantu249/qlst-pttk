<%@ page import="models.NguoiDung754" %><%--
  Created by IntelliJ IDEA.
  User: loinh
  Date: 11/3/2024
  Time: 6:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java"  %>--%>
<%-- Kiểm tra đăng nhập --%>
<%
    NguoiDung754 user = (NguoiDung754) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("login");
        return;
    }
%>
