<%--
  Created by IntelliJ IDEA.
  User: laptop88
  Date: 9/25/2020
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Ứng Dụng Chuyển Đổi Tiền Tệ</title>
    <style>
      form label input {
        margin: 15px;
      }
    </style>
  </head>
  <body>
  <h1>Chuyển Đổi Tiền Tệ</h1>
  <form action="/change" method="post">
    <label>Rate: <input type="text" name="rate" placeholder="Rate"></label>
    <br>
    <label>USD: <input type="text" name="USD" placeholder="USD"></label>
    <br>
    <input type="submit" value="Convert" style="margin-left: 75px; margin-top: 5px">
  </form>
  </body>
</html>
