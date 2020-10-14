<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/8/2020
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <c:if test='${message!= null}'>
        <span class="message">${message}</span>
    </c:if>
</p>
<form action="/home" method="post">
    <input type="hidden" name="action" value="create">
        <h2>Add new prodcut</h2>
        <table>
            <tr>
                <td><label for="productName">Name product: </label></td>
                <td><input type="text" name="productName" id="productName" value="<c:out value='${product.productId}'/>">
                </td>
            </tr>
            <tr>
                <td><label for="price">Price: </label></td>
                <td><input type="text" name="price" id="price" value='<c:out value="${product.getCustomerBirthday()}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="quantity">Quantity: </label></td>
                <td><input type="text" name="quantity" id="quantity" value='<c:out value="${product.getCustomerGender()}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="color">Color: </label></td>
                <td><input type="text" name="color" id="color" value='<c:out value="${product.getCustomerIdCard()}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="category">category: </label></td>
                <td>
                    <select name="category" id="category">
                        <c:forEach var="category" items="${categoryList}">
                            <c:choose>
                                <c:when test="${category.categoryId.equals(product.categoryId)}">
                                    <option value="<c:out value='${category.categoryId}'/>" selected><c:out value="${category.categoryName}"/></option>
                                </c:when>
                                <c:otherwise>
                                    <option value="<c:out value='${category.categoryId}'/>"><c:out value="${category.categoryName}"/></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Create">
                    <button type="button"><a href="/home?action=''">Back</a></button>
                </td>
            </tr>
        </table>
</form>
</body>
</html>
