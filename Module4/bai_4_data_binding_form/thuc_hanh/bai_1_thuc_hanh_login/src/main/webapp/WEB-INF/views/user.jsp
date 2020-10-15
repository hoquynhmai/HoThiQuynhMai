<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info User</title>
    <style>
        h3{
            color: cornflowerblue;
        }
    </style>
</head>
<body>
<div align="center">
<h1>Welcome</h1>
<h3>Account: ${user.account}</h3>
<h3>Name: ${user.name}</h3>
<h3>Email: ${user.email}</h3>
<h3>Age: ${user.age}</h3>
</div>
</body>
</html>