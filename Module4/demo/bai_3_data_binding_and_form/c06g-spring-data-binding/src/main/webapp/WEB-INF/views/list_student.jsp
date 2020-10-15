<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List student</title>
</head>
<body>
    <a href="/student/create">Create student</a>
    <p style="color: green">${message}</p>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Date of birth</th>
            <th>Request param</th>
            <th>Path variable</th>
        </tr>
        <c:forEach var="student" items="${listStudent}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.dateOfBirth}</td>
                <td><a href="/student/detail?id=${student.id}">Request param</a></td>
                <td><a href="/student/detail/${student.id}">Path variable</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
