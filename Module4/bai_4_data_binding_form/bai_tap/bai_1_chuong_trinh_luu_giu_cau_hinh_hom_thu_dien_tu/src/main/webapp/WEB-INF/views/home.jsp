<%--
  Created by IntelliJ IDEA.
  User: laptop88
  Date: 10/15/2020
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Email</title>
    <style>
        div {
            margin-top: 5px;
        }
    </style>
</head>
<body>
<h1>Settings</h1>
<form:form action="/update" modelAttribute="email"  method="post">

        <div>
            <form:label path="language"> Languages: </form:label>
            <form:select path="language" >
                <form:option value="Vietnamese">Vietnamese</form:option>
                <form:option value="English">English</form:option>
                <form:option value="Japanese">Japanese</form:option>
                <form:option value="Chinese">Chinese</form:option>
            </form:select>
        </div>

        <div>
            <form:label path="pageSize">Page Size: Show</form:label>
            <form:select path="pageSize">
                <p>Show</p>
                <form:option value="5">5</form:option>
                <form:option value="10">10</form:option>
                <form:option value="15">15</form:option>
                <form:option value="20">20</form:option>
            </form:select>
            <form:label path="pageSize"> emails per page</form:label>
    </div>

        <div>
            <form:label path="spamsFilter">Spams filter: </form:label>
            <form:checkbox path="spamsFilter" value="Enable spams filter"/>Enable spams filter
        </div>

        <div>
            <form:label path="sign">Singature:</form:label>
            <form:textarea rows="4" cols="25" path="sign"/>
        </div>
    <div>
        <input type="submit" value="Update">
        <input type="button" value="Cancel">
    </div>
</form:form>
</body>
</html>
