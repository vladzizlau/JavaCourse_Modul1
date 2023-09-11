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

<style>
/* Базовые стили слоя затемнения и модального окна  */
.overlay {
top: 0;
right: 0;
bottom: 0;
left: 0;
z-index: 1;
visibility: hidden;
/* фон затемнения */
background-color: rgba(0, 0, 0, 0.7);
opacity: 0;
position: fixed; /* фиксированное поцизионирование */
cursor: default; /* тип курсара */
-webkit-transition: opacity .5s;
-moz-transition: opacity .5s;
-ms-transition: opacity .5s;
-o-transition: opacity .5s;
transition: opacity .5s;
}
.overlay:target {
visibility: visible;
opacity: 1;
}
.is-image {
top: 0;
right: 0;
bottom: 0;
left: 0;
display:block;
margin: 10&;
width: 100%;
height: auto;
/* скругление углов встроенных картинок */
-webkit-border-radius: 4px;
-moz-border-radius: 4px;
-ms-border-radius: 4px;
border-radius: 4px;
}
/* встроенные элементы м-медиа, фреймы */
embed, iframe {
top: 0;
right: 0;
bottom: 0;
left: 0;
display:block;
margin: auto;
min-width: 320px;
max-width: 600px;
width: 100%;
}
.popup h1 { /* заголовок 1 */
color: #008000;
text-align: left;
text-shadow: 0 1px 3px rgba(0,0,0,.3);
font:24px 'Trebuchet MS', Helvetica, sans-serif;
font-weight: bold;
}
.popup h2 { /* заголовок 2 */
color: #008000;
text-align: left;
text-shadow: 0 1px 3px rgba(0,0,0,.3);
font:22px 'Trebuchet MS', Helvetica, sans-serif;
}
/*** Формируем стили модального окна ***/
.popup {
top: 0;
right: 0;
left: 0;
font-size: 14px;
z-index: 10;
display: block;
visibility: hidden;
margin: 0 auto;
width: 90%;
min-width: 320px;
max-width: 600px;
/* фиксированное позиционирование, окно стабильно при прокрутке */
position: fixed;
padding: 15px;
border: 1px solid #383838;
/* скругление углов */
-webkit-border-radius: 4px;
-moz-border-radius: 4px;
-ms-border-radius: 4px;
border-radius: 4px;
background-color: #FFFFFF;
/* внешняя тень блока */
-webkit-box-shadow: 0 0 6px rgba(0, 0, 0, 0.8);
-moz-box-shadow: 0 0 6px rgba(0, 0, 0, 0.8);
-ms-box-shadow: 0 0 6px rgba(0, 0, 0, 0.8);
-o-box-shadow: 0 0 6px rgba(0, 0, 0, 0.8);
box-shadow: 0px 0px 6px rgba(0, 0, 0, 0.8);
/* полная прозрачность окна, появление при клике */
opacity: 0;
/* эффект перехода (появление) */
-webkit-transition: all ease .5s;
-moz-transition: all ease .5s;
-ms-transition: all ease .5s;
-o-transition: all ease .5s;
transition: all ease .5s;
}
/* активируем появление окна и затемнение фона */
.overlay:target+.popup {
top: 20%; /* положение окна от верха страницы при появлении */
visibility: visible;
opacity: 1; /* убираем прозрачность */
}
/* формируем кнопку закрытия */
.close {
position: absolute;
top: -10px;
right: -10px;padding: 0;
width: 20px;
height: 20px;
border: 2px solid #ccc;
-webkit-border-radius: 15px;
-moz-border-radius: 15px;
-ms-border-radius: 15px;
-o-border-radius: 15px;
border-radius: 15px;
background-color: rgba(61, 61, 61, 0.8);
-webkit-box-shadow: 0px 0px 10px #000;
-moz-box-shadow: 0px 0px 10px #000;
box-shadow: 0px 0px 10px #000;
text-align: center;
text-decoration: none;
font-weight: bold;
line-height: 20px;
/* задаём значения и эффект перехода при наведении */
-webkit-transition: all ease .8s;
-moz-transition: all ease .8s;
-ms-transition: all ease .8s;
-o-transition: all ease .8s;
transition: all ease .8s;
}
.close:before {
color: rgba(255, 255, 255, 0.9);
content: "X";
text-shadow: 0 -1px rgba(0, 0, 0, 0.9);
font-size: 12px;
}
.close:hover {
background-color: rgba(252, 20, 0, 0.8);
/* крутим кнопку при наведении */
-webkit-transform: rotate(360deg);
-moz-transform: rotate(360deg);
-ms-transform: rotate(360deg);
-o-transform: rotate(360deg);
transform: rotate(360deg);
}
/* опционально при добавлении вложений */
.popup p, .popup div {
margin-bottom: 10px;
}


/* button */

.button {

  font-size: 20px;
  color: white;
  width: 270px;
  text-decoration: none;
  padding: 10px 5px;
  border-radius: 10px;
  -moz-border-radius: 10px;
  -webkit-border-radius: 10px;
  font-family: Helvetica, Arial, sans-serif;
  transition: all 0.3s;
  -moz-transition: all 0.3s;
  -webkit-transition: all 0.3s;
  cursor: pointer;

}
.button-blue {
  background-color: #0600FF;
  }
.button:hover {
  background-color: #5555ff;
  box-shadow:0 0 10px 10px #b7b7ff inset;
}
.button:active {
    background-color: #0000ff;
    box-shadow:0 0 0 0 #ffffff;
}
</style>
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
<div id="wb_Text6" style="position:absolute;left:140px;top:17px;width:300px;height:19px;z-index:5;">
<span style="color:#000000;font-family:Arial;font-size:18px;">Редактирование товаров</span></div>
<a id="Button1" href="addprod.jsp" style="position:absolute;left:-150px;top:0px;width:120px;height:30px;">Добавить</a>
<a id="Button1" href="editprod.jsp" style="position:absolute;left:-150px;top:50px;width:120px;height:30px;">Редактировать</a>
<a id="Button1" href="deleteprod.jsp" style="position:absolute;left:-150px;top:100px;width:120px;height:30px;">Удалить</a>
<a id="Button1" href="allusers.jsp" style="position:absolute;left:-150px;top:150px;width:120px;height:30px;">Пользователи</a>
</form>

<c:set var="count" value="1"></c:set>
<table id="Table" style="position: relative;border-spacing: 10px;left: 10px;top: 50px;width: 100px;height: 100px;border: 1px solid;" >
<jsp:useBean id="service" class="by.pvt.core.multi.service.ProductService" scope="page"></jsp:useBean>
<tr><th>Категория</th><th>Название</th><th>Цена</th><th>Код</th><th>ID</th>
<c:forEach items="${service.loadProds()}" var="good">
<div id="wb_Text2" >

<tr><td><c:out value="${good.getType()}"/></td><td><c:out value="${good.getNameProduct()}"/></td><td><c:out value="${good.getPrice()}"/></td><td><c:out value="${good.getCodeProduct()}"/></td><td><c:out value="${good.getId()}"/></td><td><a href="#win${count}" id="<c:out value="${good.getId()}"/>"><img style="height: 20px;" src="../images/editImage.png"></img></a></td>

<!-- Модальное окно -->
 <a href="#x" class="overlay" id="win${count}"></a>
   <div class="popup">
   <p>Редактирование товара</p>
   <form action="../store">
    <input type="hidden" name="action" value="edit">
    <input type="text" name="M_Type" size="20" value="<c:out value="${good.getType()}"/>">
    <input type="text" name="M_Name" size="20" value="<c:out value="${good.getNameProduct()}"/>">
    <input type="text" name="M_Price" size="15" value="<c:out value="${good.getPrice()}"/>">
    <input type="text" name="M_Code" size="10" value="<c:out value="${good.getCodeProduct()}"/>">
    <input type="hidden" name="id" value="<c:out value="${good.getId()}"/>">
    <input id="Button1"  type="submit" method="get" style="position:relative;left:250px;" value="Сохранить">
</form>

    <a class="close"title="Закрыть" href="#close"></a>
    </div>
<!-- Модальное окно -->
<c:set var="count" value="${count + 1 }"></c:set>
</c:forEach>
</table>




</div>
</div>
</body>
</html>
