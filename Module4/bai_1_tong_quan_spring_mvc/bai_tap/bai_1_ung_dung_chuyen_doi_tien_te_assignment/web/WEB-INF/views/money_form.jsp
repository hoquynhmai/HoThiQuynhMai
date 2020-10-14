<%--
  Created by IntelliJ IDEA.
  User: laptop88
  Date: 10/13/2020
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Change Money</title>
  </head>
  <body>
  <form action="/changeMoney">
  <div align="center">
    <h1>Change Money from USD to VND</h1>
    <label>USD: </label>
    <input type="text" name="usd"/>
    <input type="submit" name="changeMoney" value="Change Money"/>
  </div>
<%--    <div align="center">--%>
<%--      <h1 style="background-color: aqua">${usd} $ = ${result} VND</h1>--%>
<%--    </div>--%>
  </form>
  </body>
</html>
