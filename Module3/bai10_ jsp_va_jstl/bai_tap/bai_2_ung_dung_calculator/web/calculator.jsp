<%--
  Created by IntelliJ IDEA.
  User: laptop88
  Date: 9/25/2020
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng Dụng Calculator</title>
    <style>
        h1 {
            text-align: center;
        }

        h2 {
            text-align: center;
            background-color: aqua;
        }
    </style>
</head>
<body>
<h1>Calculate</h1>
<h2><%=request.getAttribute("calculate")%></h2>
</body>
</html>
