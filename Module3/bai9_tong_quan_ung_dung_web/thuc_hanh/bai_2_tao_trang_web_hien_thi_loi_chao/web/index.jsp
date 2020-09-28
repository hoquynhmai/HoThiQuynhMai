<%--
  Created by IntelliJ IDEA.
  User: laptop88
  Date: 9/24/2020
  Time: 9:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Đăng nhập và Hiển Thị</title>
    <style type="text/css">
      .login {
        height:180px; width:280px;
        margin:0;
        padding:5px;
        border:2px #CCC dotted;
      }
      .login input {
        padding:5px; margin:5px
      }
    </style>
  </head>
  <body>
  <form action="/login" method="post">
    <div class="login">
      <h2>Login</h2>
      <input type="text" name="username" size="30"  placeholder="username" />
      <input type="password" name="password" size="30" placeholder="password" />
      <input type="submit" value="Sign in"/>
    </div>
  </form>
  </body>
</html>
