<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/6/2020
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
          integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
          crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Student</title>

    <style>
        .message {
            text-align: center;
            color: deeppink;
        }

        h1 {
            text-align: center;
        }

        .btn {
            background-color: violet
        }

        .back {
            margin-left: 10px;
        }

        p {
            color: red;
        }

        input {
            font-weight: bold;
        }
    </style>
</head>

<body>
<div class="container">
    <h1>Information Student</h1>

    <h3 class="messageComplete">${messageComplete}</h3>

    <form action="/student" method="post">
        <input type="hidden" name="actionStudent" value="updateStudent" />

        <div class="form-group has-success">
            <label for="id">ID :</label>
            <input type="text" class="form-control" name="id" id="id" value="${student.id}" readonly/>
        </div>

        <div class="form-group has-success">
            <label for="name">Name :</label>
            <input type="text" class="form-control" name="name" id="name" value="${student.name}" required/>
        </div>

        <div class="form-group has-warning">
            <label for="age">Age :</label>
            <input type="text" class="form-control" name="age" id="age" value="${student.age}" required/>
            <p>${messageAge}</p>
        </div>

        <div class="form-group has-error">
            <label for="email">Email :</label>
            <input type="text" class="form-control" name="email" id="email" value="${student.email}" required/>
            <p>${messageEmail}</p>
        </div>

        <div class="form-group has-success">
            <label for="address">Address :</label>
            <input type="text" class="form-control" name="address" id="address" value="${student.address}" required/>
        </div>

        <div class="form-group">
            <label>Select Class : </label>
            <label for="classCG"></label><select name="classCG" id="classCG" required>
            <c:forEach var="classCG" items="${classList}">
                <c:choose>
                    <c:when test="${classCG.id.equals(student.idClass)}">
                        <option value="<c:out value='${classCG.id}'/>" selected><c:out value="${classCG.name}"></c:out></option>
                    </c:when>
                    <c:otherwise>
                        <option value="${classCG.id}">${classCG.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
        </div>

        <input type="submit" class="btn btn-info" value="Update" /><span>
            <a href="/student" class="btn btn-info back">Back</a></span>
    </form>

</div>
</body>
</html>