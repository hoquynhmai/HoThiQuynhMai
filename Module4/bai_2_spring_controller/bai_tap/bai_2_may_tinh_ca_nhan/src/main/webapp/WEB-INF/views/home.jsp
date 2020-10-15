<%--
  Created by IntelliJ IDEA.
  User: laptop88
  Date: 10/14/2020
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<form action="/result">
    <div align="center">
        <fieldset>
            <h1>Caculator</h1>
            <div align="center">
                <input type="text" name="num1" placeholder="Input number 1">
                <input type="text" name="num2" placeholder="Input number 2">
            </div>
            <input type="radio" name="caculate" value="Add" id="add"/>Add (+)
            <input type="radio" name="caculate" value="Subs" id="subs"/>Subs (-)
            <input type="radio" name="caculate" value="Multi" id="multi"/>Multi (*)
            <input type="radio" name="caculate" value="Div" id="div"/>Div (/)
            <div align="center">
                <input type="submit" value="Caculate"/>
            </div>
        </fieldset>
        <h3 style="background-color: aqua">${caculate}</h3>
    </div>
</form>
</body>
</html>
