<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xem thông tin sản phẩm</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/listProduct">Back to product list</a>
</p>
<table>
    <tr>
        <td>ID:</td>
        <td>${listProduct.getID()}</td>
    </tr>
    <tr>
        <td>Name:</td>
        <td>${listProduct.getName()}</td>
    </tr>
    <tr>
        <td>Cost:</td>
        <td>${listProduct.getCost()}</td>
    </tr>
    <tr>
        <td>Describe:</td>
        <td>${listProduct.getDescribe()}</td>
    </tr>
    <tr>
        <td>Producer:</td>
        <td>${listProduct.getProducer()}</td>
    </tr>
</table>
</body>
</html>
