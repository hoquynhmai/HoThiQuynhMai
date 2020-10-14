
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách người dùng</title>
</head>
<body>
<div align="center">
    <h1>Display User</h1>
    <a href="/listUsers?action=create">Add New User</a>
    <table border="1" cellpadding="5">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Email</td>
            <td>Country</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items="${listUsers}" var="user">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/> </td>
                <td><c:out value="${user.country}"/> </td>
                <td><a href="/listUsers?action=edit&id=${user.id}"></a>Edit</td>
                <td><a href="/listUsers?action=delete&id=${user.id}"></a>Delete</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
