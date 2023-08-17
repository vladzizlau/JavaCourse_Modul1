<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<script>
window.onload = function(){
document.getElementById("1234").click();
};
</script>

<head>
<meta charset="utf-8">
<title>Главная страница</title>
<link href="base/jquery-ui.min.css" rel="stylesheet">
<link href="style/OnlineStore.css" rel="stylesheet">
<link href="style/index.css" rel="stylesheet">
</head>
<body>
<form action="./store" method="post">
<input type="hidden" name="link" value="loadShop">
<input type="submit" id="1234" hidden="hidden">
</form>


<div id="container">
<a id="Button1" href="./cart.html" style="position:absolute;left:900px;top:0px;width:100px;height:29px;z-index:0;">Корзина</a>
<img src="images/img0002.png" id="Banner1" alt="Online Store" style="border-width:0;position:absolute;left:0px;top:33px;width:1000px;height:70px;z-index:1;" width="1000" height="70">
<a id="Button2" href="./login.jsp" style="position:absolute;left:788px;top:0px;width:100px;height:29px;z-index:2;">Вход</a>
<nav id="wb_CssMenu2" style="position:absolute;left:0px;top:0px;width:336px;height:44px;z-index:3;">
<ul id="CssMenu2" role="menubar" class="nav">
<li role="menuitem" class="nav-item firstmain"><a class="nav-link" href="./index.jsp" target="_self" title="Товары">Гланая</a>
</li>
<li role="menuitem" class="nav-item"><a class="nav-link" href="./InfoPayment.html" target="_self">Оплата</a>
</li>
<li role="menuitem" class="nav-item"><a class="nav-link" href="./InfoDelivery.html" target="_self">Доставка</a>
</li>
</ul>
</nav>
<div id="wb_Text1" style="position:absolute;left:3155px;top:618px;width:330px;height:15px;z-index:4;">
<span style="color:#000000;font-family:Arial;font-size:16px;">Site created special for Java course Enterprise Edition</span></div>

<div id="wb_Form1" style="position:absolute;left:0px;top:165px;width:1000px;height:442px;z-index:16;">
<form name="Form1" method="post" action="http://localhost:8080/core/store" enc-type="multipart/form-data" id="Form1">
</form>
</div>
<div id="Tabs1" type="submit" style="position:absolute;left:0px;top:119px;width:992px;height:478px;z-index:17;">
<ul>

<script src="style/jquery-3.7.0.min.js"></script>
<script src="style/jquery-ui.min.js"></script>
<script src="style/index.js"></script>
</body>
</html>

