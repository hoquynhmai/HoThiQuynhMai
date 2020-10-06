<%--
  Created by IntelliJ IDEA.
  User: laptop88
  Date: 10/1/2020
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Furama resort management</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
      integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
      integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<style>
    * {
        margin: 0;
        padding: 0;
    }

    img {
        height: 150px;
        width: 270px;
    }

    h1 {
        color: green;
    }

    .nav-link:hover {
        background-color: black;
        margin-left: 25px;
    }

    h5 {
        margin-left: 90px;
    }

    .col-sm-3 img {
        width: 95%;
    }

    .icon img {
        width: 100%;
        height: 100%;
    }

    .footer {
        background-color: gray;
        text-align: center;
        height: 25px;
    }
</style>
</head>
<body>
<form action="/furama">
    <div class="container-fluid">
        <div class="row" style="background-color: aliceblue">
            <div class="col-sm-8">
                <img src="pic/logo.png" alt="furama-icon" style="height: 90px; width: 90px; margin-left: 25px">
            </div>

            <div class="col-sm-4">
                <h1 style="margin-top: 25px">HỒ QUỲNH MAI</h1>
            </div>
        </div>

        <nav class="navbar navbar-expand-lg navbar-light bg-dark">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link text-white" href="http://localhost:8080/furama/view.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="#">Employee</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="#">Customer</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="#">Service</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="#">Contract</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="#">Contract Detail</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                           style="width: 250px">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>


        <div class="row" style="background-color: aliceblue">
            <div class="col-sm-3">
                <div class="row">
                    <img src="pic/villa.jpg" alt="villa-icon">
                    <h5>Villa System</h5>
                    <img src="pic/house.jpg" alt="house-icon">
                    <h5>Home System</h5>
                    <img src="pic/room.png" alt="room-icon">
                    <h5>Room System</h5>
                </div>
            </div>

            <div class="col-sm-9">
                <div class="row">
                    <div class="col-sm-6" style="text-align: center">
                        <h1>FURAMA DANANG - FURAMA INTERNATIONAL RESORT</h1>
                        <p style="text-align: justify">
                            Overlooking Da Nang beach stretching white sand, Furama Resort Danang is the gateway to 3 di
                            World Cultural Property: Hoi An (20 minutes), My Son (90 minutes) and Hue (2 hours. 196
                            luxury
                            rooms with 70 villas villa with two to four rooms Sleep with private swimming pools are all
                            tastefully decorated, in a traditional design style of Vietnamese architecture and belonging
                            location of France, making Furama the most prestigious resort in Vietnam - honored to be
                            welcomed meet many famous people, royalty, politicians, movie stars and international
                            business
                            leaders.</p>

                        <p>The resort has 196 rooms designed in traditional Vietnamese style combined with French
                            style, 2-4 storey buildings overlooking the sea, overlooking the clear blue swimming pool
                            and lush tropical gardens. In addition, Furama Resort also offers legal spas, steam baths,
                            saunas, hot pool massage, water sports services.</p>
                    </div>
                    <div class="col-sm-6 icon">
                        <img src="pic/pic_1.jpg" alt="pic1">
                    </div>
                </div>
            </div>
        </div>

        <div class="row" style="background-color: blanchedalmond">
            <div class="col-sm-3">
                <img src="pic/pic_2.jpg" alt="pic2">
            </div>
            <div class="col-sm-3">
                <img src="pic/pic_3.jpeg" alt="pic3">
            </div>
            <div class="col-sm-3">
                <img src="pic/pic_4.jpg" alt="pic4">
            </div>
            <div class="col-sm-3">
                <img src="pic/pic_5.jpg" alt="pic5">
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12 footer">
                <p>HQM © 2020</p>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>

</form>
</body>
</html>
