<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html lang="ru">
<head>
<meta charset="utf-8">
<title>Вход</title>
<link href="OnlineStore.css" rel="stylesheet">
<link href="./style/reg.css" rel="stylesheet">
</head>
<body>
<div id="container">
<a id="Button1" href="./cart.jsp" style="position:absolute;left:900px;top:0px;width:100px;height:29px;z-index:0;">Корзина</a>
<img src="./images/img0002.png" id="Banner1" alt="Online Store" style="border-width:0;position:absolute;left:0px;top:33px;width:1000px;height:70px;z-index:1;" width="1000" height="70">
<a id="Button1" href="./login.jsp" style="position:absolute;left:788px;top:0px;width:100px;height:29px;z-index:2;">Вход</a>
<nav id="wb_CssMenu2" style="position:absolute;left:0px;top:0px;width:336px;height:44px;z-index:3;">
<ul id="CssMenu2" role="menubar" class="nav">
<li role="menuitem" class="nav-item firstmain"><a class="nav-link" href="./index.jsp" target="_self" title="Товары">Гланая</a>
</li>
<li role="menuitem" class="nav-item"><a class="nav-link" href="./InfoPayment.jsp" target="_self">Оплата</a>
</li>
<li role="menuitem" class="nav-item"><a class="nav-link" href="./InfoDelivery.jsp" target="_self">Доставка</a>
</li>
</ul>
</nav>
<div id="wb_Text1" style="position:absolute;left:315px;top:550px;width:500px;height:15px;z-index:4;">
<span style="color:#000000;font-family:Arial;font-size:16px;">Site created special for Java course Enterprise Edition</span></div>


<div id="wb_Form1" style="position:absolute;left:269px;top:110px;width:500px;height:420px;z-index:13;">
<form name="Form1" method="post" action="./register.jsp" enc-type="application/x-www-form-urlencoded" id="Form1">
<input type="hidden" name="link" value="Login.html">
<div id="wb_Text4" style="position:absolute;left:175px;top:10px;width:300px;height:19px;z-index:9;">
<span style="color:#000000;font-family:Arial;font-size:18px;">Ошибка регистрации</span></div>
<div id="wb_Text2" style="position:absolute;left:50px;top:74px;width:400px;height:14px;z-index:7;">
<span style="color:#000000;font-family:Arial;font-size:15px;">Вас перекинуло на эту страницу, потому что:
<br>1) Вы не заполнили поля.
<br>2) Вы заполнили одно из полей.
<br>3) Вы не правильно указали номер телефона. Указывайте только цифры.


<div id="wb_Text3" style="position:absolute;left:50px;top:100px;width:400px;height:14px;z-index:8;">
<span style="color:#000000;font-family:Arial;font-size:15px;">Удачи! <a href="./register.jsp"><span style="color:#000000;font-family:'Times New Roman';font-size:17px;">Попытаться еще разок!</span></a></span></div>





</form>
</div>
</div>
</body>
</html>