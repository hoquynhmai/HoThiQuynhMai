<%--
  Created by IntelliJ IDEA.
  User: laptop88
  Date: 10/13/2020
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transale English To VietNamese</title>
</head>
<body>
<form action="findDic">
<div align="center">
    <fieldset>
        <h1> Transale English To VietNamese</h1>
        <label>English: </label>
        <input type="text" name="word" placeholder="Input English" />
        <input type="submit" value="Transale">
    </fieldset>
    <h1 style="background-color: aqua">${result}</h1>
</div>
</form>
</body>
</html>
