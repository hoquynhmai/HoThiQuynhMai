<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tạo sản phẩm mới</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>Create new Product</h1>
<p>
    <c:if test="${message != null}">
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
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Cost:</td>
                <td><input type="text" name="cost" id="cost"></td>
            </tr>
            <tr>
                <td>Describe:</td>
                <td><input type="text" name="describe" id="describe"></td>
            </tr>
            <tr>
                <td>Producer:</td>
                <td><input type="text" name="producer" id="producer"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
