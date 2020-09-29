
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập nhật thông tin sản phẩm</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>Edit Products</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/listProduct">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name" value="${requestScope["listProduct"].getName()}"></td>
            </tr>
            <tr>
                <td>Cost:</td>
                <td><input type="text" name="cost" id="cost" value="${requestScope["listProduct"].getCost()}"></td>
            </tr>
            <tr>
                <td>Describe:</td>
                <td><input type="text" name="describe" id="describe" value="${requestScope["listProduct"].getDescribe()}">
                </td>
            </tr>
            <tr>
                <td>Producer:</td>
                <td><input type="text" name="producer" id="producer" value="${requestScope["listProduct"].getProducer()}">
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
