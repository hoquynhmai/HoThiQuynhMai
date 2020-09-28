<%--
  Created by IntelliJ IDEA.
  User: laptop88
  Date: 9/25/2020
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Ứng Dụng Calculator</title>
    <style>
      form {
        height: 300px;
        width: 380px;
      }
       h1{
         margin-left: 75px;
       }
    </style>
  </head>
  <body>

  <h1>Simple Calculator</h1>

  <form action="/caculate" method="get">
    <fieldset>
      <legend>Calculator:</legend>
      <label>First Number:</label>
      <input type="text"  name="number1" style="margin-left: 18px"><br><br>

      <label>Operator:</label>
        <input type="radio" name="operator" value="+">Add
        <input type="radio" name="operator" value="-">Minus
        <input type="radio" name="operator" value="*">Multi
        <input type="radio" name="operator" value="/">Div <br><br>

      <label>Second Number:</label>
      <input type="text" name="number2"><br><br>

      <input type="submit" value="Calculator" style="margin-left: 115px">
    </fieldset>
  </form>
  </body>
</html>
