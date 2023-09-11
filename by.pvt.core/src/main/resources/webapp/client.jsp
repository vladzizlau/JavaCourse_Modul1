<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<c:set var="userId"><c:out value='${sessionScope["userAuth"].getId()}' /></c:set>
 <c:if test="${userId != 0}">
            <script>
                  document.getElementById('Button2').hidden = true;
                  document.getElementById('Button2').href = "./client.jsp";
              </script>
        </c:if>



<div id="wb_Form1" style="position:absolute;left:269px;top:112px;width:462px;height:399px;z-index:20;">
<form name="Form1" method="post" action="./store" enc-type="application/x-www-form-urlencoded" id="Form1">
<input type="hidden" name="link" value="Register.jsp">
<div id="wb_Text6" style="position:absolute;left:180px;top:17px;width:200px;height:19px;z-index:5;">
<span style="color:#000000;font-family:Arial;font-size:18px;">Личный кабинет</span></div>
<a id="Button1" href="client/allOrders.jsp" style="position:absolute;left:-150px;top:0px;width:120px;height:30px;">Мои заказы</a>
<div id="wb_Text2" style="position:absolute;left:147px;top:56px;width:400px;height:14px;z-index:10;">
<span style="color:#000000;font-family:Arial;font-size:15px;" >Логин:   <c:out value="${sessionScope.userAuth.getLogin()}" /></span></div>
<div id="wb_Text3" style="position:absolute;left:75px;top:90px;width:400px;height:14px;z-index:11;">
<span style="color:#000000;font-family:Arial;font-size:15px;">Идентификатор:   <c:out value="${sessionScope.userAuth.getId()}" /></span></div>
<div id="wb_password" style="position:absolute;left:147px;top:128px;width:400px;height:14px;z-index:16;">
<span style="color:#000000;font-family:Arial;font-size:15px;">Email:   <c:out value="${sessionScope.userAuth.getEmail()}" /></span></div>
<div id="wb_Text4" style="position:absolute;left:155px;top:168px;width:400px;height:14px;z-index:12;">
<span style="color:#000000;font-family:Arial;font-size:15px;">Имя:   <c:out value="${sessionScope.userAuth.getFirstName()}" /></span></div>
<div id="wb_Text5" style="position:absolute;left:122px;top:208px;width:400px;height:14px;z-index:13;">
<span style="color:#000000;font-family:Arial;font-size:15px;">Фамилия:   <c:out value="${sessionScope.userAuth.getSurName()}" /></span></div>
<div id="wb_Text8" style="position:absolute;left:120px;top:248px;width:400px;height:15px;z-index:17;">
<span style="color:#000000;font-family:Arial;font-size:16px;">Телефон:   <c:out value="${sessionScope.userAuth.getPhone()}" /></span></div>
<div id="wb_Text8" style="position:absolute;left:147px;top:288px;width:400px;height:15px;z-index:17;">
<span style="color:#000000;font-family:Arial;font-size:16px;">Роль:   <c:out value="${sessionScope.userAuth.getRole()}" /></span></div>

<a id="exit" href="./login.jsp" value="Сменить пользователя" style="position:absolute;left:172px;top:320px;width:148px;height:41px;z-index:18;" onclick="">Сменить пользователя</a>



</form>
</div>
</div>
</body>
</html>
