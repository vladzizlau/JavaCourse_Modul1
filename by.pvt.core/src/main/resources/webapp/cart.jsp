<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html lang="ru">
<head>
<meta charset="utf-8">
<title>Корзина</title>
<link href="./OnlineStore.css" rel="stylesheet">
<link href="./style/reg.css" rel="stylesheet">


</head>
<body>
<div id="container">
<a id="Button1" href="./cart.jsp" style="position:absolute;left:900px;top:0px;width:100px;height:29px;z-index:0;">Корзина</a>
<img src="./images/img0002.png" id="Banner1" alt="Online Store" style="border-width:0;position:absolute;left:0px;top:33px;width:1000px;height:70px;z-index:1;" width="1000" height="70">
<a id="Button2" href="../login.jsp" style="position:absolute;left:788px;top:0px;width:100px;height:29px;z-index:2;">Вход</a>
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

<div id="wb_Form1" style="position:absolute;left:269px;top:112px;width:462px;height:399px;z-index:20;">
<form name="Form1" method="post" action="./store" enc-type="application/x-www-form-urlencoded" id="Form1">
<input type="hidden" name="link" value="Payment">

<div id="wb_Text6" style="position:absolute;left:140px;top:17px;width:300px;height:19px;z-index:5;">
<span style="color:#000000;font-family:Arial;font-size:18px;">Корзина</span></div>
</form>
<jsp:useBean id="service" class="by.pvt.core.multi.service.CartService" scope="page"></jsp:useBean>
<jsp:useBean id="order" class="by.pvt.core.multi.service.OrderService" scope="page"></jsp:useBean>

<c:set var="userId"><c:out value='${sessionScope["userAuth"].getId()}' /></c:set>
 <c:if test="${userId != 0}">
            <script>
                  document.getElementById('Button2').text = "Кабинет";
                  document.getElementById('Button2').href = "./client.jsp";
              </script>
        </c:if>

<c:set var="count" value="1"></c:set>
<c:set var="cost" value="${0}"></c:set>
<table id="Table" style="position: relative;border-spacing: 10px;left: 10px;top: 50px;width: 100px;height: 100px;border: 1px solid;" >

<tr><th>Товар</th><th>Количество</th><th>Стоимость</th>
<c:forEach items="${service.returnAllCartthisWork(userId)}" var="cart">
<div id="wb_Text2" >
<c:set var="productID"><c:out value="${cart.getProductId()}"/></c:set>
<tr><td><c:out value="${cart.getNameProduct()}"/></td><td><c:out value="${cart.getCount()}"/></td><td><c:out value="${cart.getCost()}"/></td>
<c:set var="cost" value="${cost + cart.getCost()}"></c:set>
<c:set var="count" value="${count + 1 }"></c:set>
</c:forEach>

<form name="Form1" method="post" action="./store" enc-type="application/x-www-form-urlencoded" >
<input type="hidden" name="link" value="Payment">
<tr style="width:500px;position:absolute; left:150px"><td><td>Всего: <c:out value="${cost}"/> рублей</td></td></tr>
<tr style="width:75px;position:absolute;"><td><input type="submit" name="link" value="Оплатить"></td></tr>
</form>
</table>




</div>

</div>
</body>
</html>
