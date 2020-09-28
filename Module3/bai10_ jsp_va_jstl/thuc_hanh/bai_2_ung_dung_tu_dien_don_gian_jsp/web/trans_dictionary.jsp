<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: laptop88
  Date: 9/25/2020
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng Dụng Từ Điển Đơn Giản</title>
    <style>
        h2 {
            text-align: center;
            background-color: aqua;
        }
    </style>
</head>
<body>
<h1 style="text-align: center">Tra Từ</h1>
    <% Map<String, String> dictionary = new HashMap<>();
    dictionary.put("one","Một");
    dictionary.put("two","Hai");
    dictionary.put("three","Ba");
    dictionary.put("four","Bốn");
    dictionary.put("five","Năm");

    String search = request.getParameter("english");
    String result = dictionary.get(search);

    if(result != null) {
        out.println("<h2>" + search + ": " + result + "</h2>" );
    } else {
        out.println("<h2> Not found </h2>");
    }
    %>
</body>
</html>
