<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hiển thị danh sách sản phẩm</title>
</head>
<body>
<h1>Products</h1>
<p><a href="/listProduct?action=create">Create new customer</a></p>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Cost</td>
        <td>Describe</td>
        <td>Producer</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${listProduct}" var="product">
        <tr>
            <td>${product.getId()}</td>
            <td><a href="/listProduct?action=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getCost()}</td>
            <td>${product.getDescribe()}</td>
            <td>${product.getProducer()}</td>
            <td><a href="/listProduct?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="/listProduct?action=delete&id=${product.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
