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
    <title>Sandwich Condiments</title>
</head>
<body>
<form action="/food">
    <div align="center">
        <fieldset>
            <h1>Sandwich Condiment</h1>
            <input type="checkbox" name="food" value="Lettuce"/>Lettuce
            <input type="checkbox" name="food" value="Tomato"/>Tomato
            <input type="checkbox" name="food" value="Mustard"/>Mustard
            <input type="checkbox" name="food" value="Sprouts"/>Sprouts
            <div align="center">
                <input type="submit" value="Save"/>
            </div>
        </fieldset>
        <h3 style="background-color: aqua">${food}</h3>
    </div>
</form>
</body>
</html>
