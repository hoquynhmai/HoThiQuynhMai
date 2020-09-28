<%--
  Created by IntelliJ IDEA.
  User: laptop88
  Date: 9/25/2020
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng Dụng Từ Điển Đơn Giản</title>
    <style>
        body {
            padding: 15px;
        }
    </style>
</head>
<body>
    <h1>Vietnamese Dictionary</h1>
    <form action="trans_dictionary.jsp" method="get">
        <input type="text" name="english" placeholder="Enter your word">
        <input type="submit" value="Translate">
    </form>
</body>
</html>
