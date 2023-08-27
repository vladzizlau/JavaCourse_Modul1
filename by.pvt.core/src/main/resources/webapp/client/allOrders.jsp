<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<html lang="ru">
<head>
<meta charset="utf-8">
<title>История заказов</title>
<link href="../OnlineStore.css" rel="stylesheet">
<link href="../style/reg.css" rel="stylesheet">
</head>
<body>
<div id="container">
<a id="Button1" href="../cart.jsp" style="position:absolute;left:900px;top:0px;width:100px;height:29px;z-index:0;">Корзина</a>
<img src="../images/img0002.png" id="Banner1" alt="Online Store" style="border-width:0;position:absolute;left:0px;top:33px;width:1000px;height:70px;z-index:1;" width="1000" height="70">

<nav id="wb_CssMenu2" style="position:absolute;left:0px;top:0px;width:336px;height:44px;z-index:3;">
<ul id="CssMenu2" role="menubar" class="nav">
<li role="menuitem" class="nav-item firstmain"><a class="nav-link" href="../index.jsp" target="_self" title="Товары">Гланая</a>
</li>
<li role="menuitem" class="nav-item"><a class="nav-link" href="../InfoPayment.jsp" target="_self">Оплата</a>
</li>
<li role="menuitem" class="nav-item"><a class="nav-link" href="../InfoDelivery.jsp" target="_self">Доставка</a>
</li>
</ul>
</nav>
<div id="wb_Text1" style="position:absolute;left:315px;top:530px;width:500px;height:15px;z-index:4;">
<span style="color:#000000;font-family:Arial;font-size:16px;">Site created special for Java course Enterprise Edition</span></div>

<div id="wb_Form1" style="position:absolute;left:269px;top:112px;width:462px;height:399px;z-index:20;">
<form name="Form1" method="post" action="./store" enc-type="application/x-www-form-urlencoded" id="Form1">
<input type="hidden" name="link" value="Register.jsp">
<div id="wb_Text6" style="position:absolute;left:180px;top:17px;width:200px;height:19px;z-index:5;">
<span style="color:#000000;font-family:Arial;font-size:18px;">Мои заказы</span></div>
<a id="Button1" href="../client.jsp" style="position:absolute;left:-150px;top:0px;width:120px;height:30px;">Кабинет</a>
</form>


<jsp:useBean id="dateValue" class="java.util.Date"/>



<jsp:useBean id="order" class="by.pvt.core.multi.service.OrderService" scope="page"></jsp:useBean>
<c:set var="userId"><c:out value='${sessionScope["userAuth"].getId()}' /></c:set>
<table id="Table" style="position: relative;border-spacing: 10px;left: 10px;top: 50px;width: 100px;height: 100px;border: 1px solid;" >

<tr><th>  </th><th>id пользователя</th><th>Стоимость</th><th>Статус</th>
<c:forEach items="${order.getAllUserOrders(userId)}" var="good">
<div id="wb_Text2" >
<jsp:setProperty name="dateValue" property="time" value="${good.getId()}"/>



<tr><td><fmt:formatDate value="${dateValue}" pattern="MM/dd/yyyy HH:mm"/></td><td><c:out value="${good.getUserId()}"/></td><td><c:out value="${good.getCost()}"/></td><td><c:out value="${good.getStatus()}"/></td></tr>

</c:forEach>
</table>
</form>
</div>
</div>
</body>
</html>
