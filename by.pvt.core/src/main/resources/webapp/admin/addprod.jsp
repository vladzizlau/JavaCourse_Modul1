<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<html lang="ru">
<head>
<meta charset="utf-8">
<title>Admin</title>
<link href="../OnlineStore.css" rel="stylesheet">
<link href="../style/reg.css" rel="stylesheet">
</head>
<body>
<div id="container">
<a id="Button1" href="../cart.jsp" style="position:absolute;left:900px;top:0px;width:100px;height:29px;z-index:0;">Корзина</a>
<img src="../images/img0002.png" id="Banner1" alt="Online Store" style="border-width:0;position:absolute;left:0px;top:33px;width:1000px;height:70px;z-index:1;" width="1000" height="70">
<a id="Button2" href="../login.jsp" style="position:absolute;left:788px;top:0px;width:100px;height:29px;z-index:2;">Вход</a>
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
<span style="color:#000000;font-family:Arial;font-size:18px;">Добавить товар</span></div>
<a id="Button1" href="addprod.jsp" style="position:absolute;left:-150px;top:0px;width:120px;height:30px;">Добавить</a>
<a id="Button1" href="editprod.jsp" style="position:absolute;left:-150px;top:50px;width:120px;height:30px;">Редактировать</a>
<a id="Button1" href="deleteprod.jsp" style="position:absolute;left:-150px;top:100px;width:120px;height:30px;">Удалить</a>
<a id="Button1" href="allusers.jsp" style="position:absolute;left:-150px;top:150px;width:120px;height:30px;">Пользователи</a>
</form>


<table id="Table" style="position: relative;border-spacing: 10px;left: 10px;top: 50px;width: 100px;height: 100px;border: 1px solid;" >
<jsp:useBean id="service" class="by.pvt.core.multi.service.ProductService" scope="page"></jsp:useBean>

<tr><th>Категория</th><th>Название</th><th>Цена</th><th>Код</th><th>ID</th>
<form action="../store">
    <input type="hidden" name="action" value="add">
  <tr><td>  <input type="text" name="M_Type" size="20" value="<c:out value="${good.getType()}"/>"></td>
    <td><input type="text" name="M_Name" size="20" value="<c:out value="${good.getNameProduct()}"/>"></td>
    <td><input type="text" name="M_Price" size="15" value="<c:out value="${good.getPrice()}"/>"></td>
    <td><input type="text" name="M_Code" size="10" value="<c:out value="${good.getCodeProduct()}"/>"></td>
    <td> ${service.getNewIndex()}</td></tr>
    <input type="hidden" name="id" value="${service.getNewIndex()}">
    <tr><td><input id="Button1"  type="submit" method="get" style="position:relative;left:250px;" value="Добавить"></td></tr>
</form>
</table>


</div>
</div>
</body>
</html>
