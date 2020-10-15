<%--
  Created by IntelliJ IDEA.
  User: pato2
  Date: 10/15/2020
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create student</title>
</head>
<body>
    <p style="color: green">${message}</p>
    <form:form action="/student/create" method="post" modelAttribute="student">
        <p>Name:</p>
        <form:input type="text" path="name"/>
        <p>Date of birth:</p>
        <form:input type="date" path="dateOfBirth" />
        <br>
        <input type="submit" value="Save" />
    </form:form>
</body>
</html>
