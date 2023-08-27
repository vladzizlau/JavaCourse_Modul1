<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<html>
<script>
window.onload = function(){
const element = document.getElementById("Table1").offsetHeight;
document.getElementById('tabs1-page-1').setAttribute("style","height:" + (element+10) );
};
</script>



<head>
<meta charset="utf-8">
<title>Главная страница</title>
<link href="base/jquery-ui.min.css" rel="stylesheet">
<link href="style/OnlineStore.css" rel="stylesheet">
<link href="style/index.css" rel="stylesheet">
<link href="style/table.css" rel="stylesheet">
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
<c:set var="userId"><c:out value='${sessionScope["userAuth"].getId()}' /></c:set>
 <c:if test="${userId != 0}">
            <script>
                  document.getElementById('Button2').text = "Кабинет";
                  document.getElementById('Button2').href = "./client.jsp";
              </script>
        </c:if>
<div id="wb_Form1" style="position:absolute;left:0px;top:165px;width:1000px;height:442px;z-index:16;">
<form name="Form1" method="post" action="http://localhost:8080/core/store" enc-type="multipart/form-data" id="Form1">
</form>
</div>
<div id="Tabs1" type="submit" style="position:relative;display:block;border:none;left:0px;top:119px;width:992px;height:478px;z-index:17;">
<ul>
<li role="presentation"><a href="#tabs1-page-1"><span>All</span></a></li>
<!--<li role="presentation"><a href="#tabs1-page-2"><span>Tab 2</span></a></li> -->

</ul>

<div style="height:454px;" id="tabs1-page-1">
<table  style="position:absolute;border-spacing:45px;left:10px;top:18px;width:900px;height:371px;z-index:5;" id="Table4">

<c:set var="goods" value="${ProductService}" />
<c:set var="lshop" value="${goods.loadGroups}" />

<c:set var="tr_count" value="1"></c:set>
<c:set var="td_count" value="1"></c:set>
<c:set var="top_count" value="0"></c:set>
<c:forEach items="${products}" var="good">

<tr id="tr${tr_count}">
<td class="cell${td_count}"><p style="font-size:11px;line-height:12px;">
<div><form name="Tovar" method="post" action="http://localhost:8080/core/store" enc-type="text/plain" id="Form2" style="position:absolute;left:27px;top:${top_count}px;width:170px;height:170px;z-index:10;border:solid">
<input type="hidden" name="link" value="cart">
<input type="hidden" name="id" value="<c:out value="${good.getId()}"/>">
<img id="imgPhoto" src="./images/tovar/non-image.jpg" style="display:block;position:absolute;left:45px"></img>
<label id="Label2" style="position:absolute;left:55px;top:75px;width:100px;height:16px;font-weight:bold;z-index:7;font-size:15px;"><c:out value="${good.getPrice()}"/> руб</label>
<label id="Label1" style="position:absolute;left:55px;top:90px;width:150px;height:16px;line-height:16px;z-index:6;font-size:13px;font-weight:inherit;"><c:out value="${good.getNameProduct()}"/></label>
<input type="number" id="tentacles" name="count" min="1" max="10" style="position:absolute;left:55px;top:107px;width:50px;height:18px;line-height:16px;z-index:8;font-size:12px;" value="1" /></input>
<!--<p style="position:absolute;left:110px;top:95px;width:50px;height:5px;line-height:16px;z-index:8;font-size:14px;">кг</p>-->
<label id="Label3" style="position:absolute;left:5px;top:125px;width:100px;height:16px;line-height:16px;z-index:8;font-size:10px;">Код товара: <c:out value="${good.getCodeProduct()}"/></label>
<input type="submit" id="Button2" name="" value="В корзину" style="position:absolute;left:40px;top:140px;width:80px;height:25px;">
<!--
<a href="./store?action=cart&id=<c:out value="${good.getId()}"/>&count=<c:out value="${ves}" />" style="position:absolute;left:50px;top:138px;width:98px;height:25px;z-index:9;">В корзину</a>
-->
</form></div>
<c:set var="td_count" value="${td_count + 1 }"></c:set>
<c:if test="${td_count > 4}">
<c:set var="tr_count" value="${tr_count + 1 }"></c:set>
<c:set var="td_count" value="${ 1 }"></c:set>
<c:set var="top_count" value="${top_count + 250 }"></c:set>
</c:if>

</p></tr></td>
</c:forEach>

</table>
</div>






</div>
<script src="style/jquery-3.7.0.min.js"></script>
<script src="style/jquery-ui.min.js"></script>
<script src="style/index.js"></script>
</body>
</html>

