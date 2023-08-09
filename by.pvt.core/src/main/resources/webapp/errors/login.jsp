<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html lang="ru">
<head>
<meta charset="utf-8">
<title>Вход</title>
<link href="OnlineStore.css" rel="stylesheet">
<link href="./style/login.css" rel="stylesheet">
</head>
<body>
<div id="container">
<a id="Button1" href="../cart.jsp" style="position:absolute;left:900px;top:0px;width:100px;height:29px;z-index:0;">Корзина</a>
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

<div id="wb_Form1" style="position:absolute;left:269px;top:110px;width:250px;height:420px;z-index:13;">
<form name="Form1" method="post" action="./login.jsp" enc-type="application/x-www-form-urlencoded" id="Form1">
<div id="wb_Text2" style="position:absolute;left:50px;top:74px;width:400px;height:14px;z-index:7;">
<span style="color:#000000;font-family:Arial;font-size:15px;">Вас перекинуло на эту страницу, потому что:
<br>1) Вы не правильно ввели логин или пароль.
<br>2) Вы забыли свой логин и пароль и по этому не знаете, что вписать в поле логин и пароль.
<br>3) Вы методом "тыка" пытались подобрать логин и пароль, но у вас ничего не вышло.
<br>4) Скорее всего, вы вообще ничего не ввели и просто "тыкнули" на кнопку "Войти", что бы посмотреть результат.
<br> Если все так, как описано выше, предлагаем вам попробовать зайти еще раз, нажав кнопочку ниже</span></div>
<div id="wb_Text3" style="position:absolute;left:50px;top:350px;width:400px;height:14px;z-index:8;">
<span style="color:#000000;font-family:Arial;font-size:15px;">Ну, а если, у вас нет и никогда небыло данных для входа, то предлагаем вам просто <a href="./register.jsp"><span style="color:#000000;font-family:'Times New Roman';font-size:17px;">зарегистрироваться!</span></a></span></div>

<div id="wb_Text4" style="position:absolute;left:175px;top:34px;width:112px;height:19px;z-index:9;">
<span style="color:#000000;font-family:Arial;font-size:21px;">Ошибка</span></div>
<input type="submit" id="Button2" name="" value="Войти" style="position:absolute;left:169px;top:300px;width:124px;height:33px;z-index:10;" href="../login.jsp">


</form>
</div>
</div>
</body>
</html>