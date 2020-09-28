
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hiển Thị Danh Sách Khách Hàng</title>
    <style>
        #image{
            width: 45px;
            height: 50px;
        }
        td {
            padding: 10px;
        }
        h1 {
            margin-left: 50px;
        }
    </style>
</head>
<body>
<h1>Danh Sách Khách Hàng</h1>
<table border="1">
    <tr>
        <th>Tên Khách Hàng</th>
        <th>Ngày Sinh</th>
        <th>Địa Chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${list}">
        <tr>
            <td><c:out value="${customer.name}"></c:out></td>
            <td><c:out value="${customer.dateOfBirth}"></c:out></td>
            <td><c:out value="${customer.address}"></c:out></td>
            <td><img id="image" src="${customer.image}"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
