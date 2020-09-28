<%--
  Created by IntelliJ IDEA.
  User: laptop88
  Date: 9/25/2020
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng Dụng Từ Điển Đơn Giản</title>
    <style>
        .translate {
            height: 250px;
            width: 250px;
            border: 2px powderblue dotted;
            margin: 5px;
            padding: 5px;
        }

    </style>
</head>
<body>
<div class="translate">
    <h1>Tra Từ</h1>
    <form action="/trans" method="get">
        <h3>Vietnamese Dictionary</h3>
        <br>
        <input type="text" name="english" placeholder="Englissh">
        <br> <br>
        <input type="submit" value="Translate">
    </form>
</div>
</body>
</html>
