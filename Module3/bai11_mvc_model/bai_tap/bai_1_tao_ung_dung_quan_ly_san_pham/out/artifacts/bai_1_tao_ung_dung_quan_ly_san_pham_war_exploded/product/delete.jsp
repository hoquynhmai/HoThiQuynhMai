<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xóa thông tin sản phẩm</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/listProduct">Back to product list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
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
            <tr>
                <td><input type="submit" value="Delete product"></td>
                <td><a href="/listProduct">Back to product list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
