<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html lang="ru">
<head>
<meta charset="utf-8">
<title>Личный кабинет</title>
<link href="OnlineStore.css" rel="stylesheet">
<link href="style/reg.css" rel="stylesheet">
</head>
<body>
<div id="container">
<a id="Button1" href="./cart.jsp" style="position:absolute;left:900px;top:0px;width:100px;height:29px;z-index:0;">Корзина</a>
<img src="images/img0002.png" id="Banner1" alt="Online Store" style="border-width:0;position:absolute;left:0px;top:33px;width:1000px;height:70px;z-index:1;" width="1000" height="70">
<a id="Button2" href="./login.jsp" style="position:absolute;left:788px;top:0px;width:100px;height:29px;z-index:2;">Вход</a>
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
<div id="wb_Text1" style="position:absolute;left:315px;top:530px;width:500px;height:15px;z-index:4;">
<span style="color:#000000;font-family:Arial;font-size:16px;">Site created special for Java course Enterprise Edition</span></div>

<div id="wb_Form1" style="position:absolute;left:269px;top:112px;width:462px;height:399px;z-index:20;">
<form name="Form1" method="post" action="./store" enc-type="application/x-www-form-urlencoded" id="Form1">
<input type="hidden" name="link" value="Register.jsp">
<div id="wb_Text6" style="position:absolute;left:180px;top:17px;width:200px;height:19px;z-index:5;">
<span style="color:#000000;font-family:Arial;font-size:18px;">Личный кабинет</span></div>
<!-- Этот текст закомментирован и не виден в коде
<input type="text" id="loginlabel" style="position:absolute;left:134px;top:53px;width:214px;height:24px;z-index:6;" name="LoginLabel" value="" spellcheck="false">
<input type="password" id="passlabel" style="position:absolute;left:134px;top:89px;width:214px;height:24px;z-index:7;" name="PassLabel" value="" spellcheck="false">
<input type="email" id="emaillable" style="position:absolute;left:134px;top:126px;width:214px;height:24px;z-index:8;" name="emaillable" value="" spellcheck="false">
<input type="text" id="namelabel" style="position:absolute;left:134px;top:217px;width:214px;height:24px;z-index:9;" name="nameLabel" value="" spellcheck="false">
<input type="text" id="surnamelabel" style="position:absolute;left:134px;top:251px;width:214px;height:24px;z-index:14;" name="surnameLabel" value="" spellcheck="false">
<input type="text" id="phonelabel" style="position:absolute;left:134px;top:285px;width:214px;height:24px;z-index:15;" name="phonelabel" value="" spellcheck="false">

-->
<div id="wb_Text2" style="position:absolute;left:147px;top:56px;width:400px;height:14px;z-index:10;">
<span style="color:#000000;font-family:Arial;font-size:15px;">Логин:   ${login}</span></div>
<div id="wb_Text3" style="position:absolute;left:75px;top:90px;width:400px;height:14px;z-index:11;">
<span style="color:#000000;font-family:Arial;font-size:15px;">Идентификатор:   ${id}</span></div>
<div id="wb_password" style="position:absolute;left:147px;top:128px;width:400px;height:14px;z-index:16;">
<span style="color:#000000;font-family:Arial;font-size:15px;">Email:   ${email}</span></div>
<div id="wb_Text4" style="position:absolute;left:155px;top:168px;width:400px;height:14px;z-index:12;">
<span style="color:#000000;font-family:Arial;font-size:15px;">Имя:   ${fname}</span></div>
<div id="wb_Text5" style="position:absolute;left:122px;top:208px;width:400px;height:14px;z-index:13;">
<span style="color:#000000;font-family:Arial;font-size:15px;">Фамилия:   ${sname}</span></div>
<div id="wb_Text8" style="position:absolute;left:120px;top:248px;width:400px;height:15px;z-index:17;">
<span style="color:#000000;font-family:Arial;font-size:16px;">Телефон:   ${phone}</span></div>
<div id="wb_Text8" style="position:absolute;left:147px;top:288px;width:400px;height:15px;z-index:17;">
<span style="color:#000000;font-family:Arial;font-size:16px;">Роль:   ${role}</span></div>
<!--
<input type="submit" id="register" name="" value="Регистрация" style="position:absolute;left:172px;top:320px;width:148px;height:41px;z-index:18;">
-->
</form>
</div>
</div>
</body>
</html>
