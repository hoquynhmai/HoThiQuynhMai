<%--
  Created by IntelliJ IDEA.
  User: laptop88
  Date: 9/25/2020
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng dụng chuyển đổi tiền tệ - JSP</title>
    <style>
        h2 {
            text-align: center;
            background-color: aqua;
        }

        h1 {
            text-align: center;
            text-decoration: black dotted;
        }
    </style>
</head>
<body>
<h1>Chuyển Đổi Tiền Tệ</h1>
<%
    float rate = Float.parseFloat(request.getParameter("rate"));
    float usd = Float.parseFloat(request.getParameter("usd"));

    float vnd = rate * usd;
%>
<h2>Rate: <%=rate%></h2>
<h2>USD: <%=usd%></h2>
<h2>VND: <%=vnd%></h2>
</body>
</html>
