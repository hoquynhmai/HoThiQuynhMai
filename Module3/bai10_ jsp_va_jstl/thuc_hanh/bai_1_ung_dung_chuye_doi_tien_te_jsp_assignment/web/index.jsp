<%--
  Created by IntelliJ IDEA.
  User: laptop88
  Date: 9/25/2020
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng dụng chuyển đổi tiền tệ - JSP</title>
    <style>
        .convert {
            height: 120px;
            width: 250px;
            background-color: aqua;
            border: 2px black dotted;
            padding: 20px;
        }
    </style>
</head>
<body>
<h1>Chuyển Đổi Tiền Tệ</h1>
<div class="convert">
    <form action="convert.jsp" method="post">
        <label>Rate </label>
        <input type="text" name="rate" placeholder="Rate">
        <br><br>

        <label>USD </label>
        <input type="text" name="usd" placeholder="USD">
        <br><br>

        <input type="submit" value="Convert" style="margin-left: 85px">
    </form>
</div>
</body>
</html>
