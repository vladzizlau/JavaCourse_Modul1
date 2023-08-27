<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html lang="ru">
<head>
<meta charset="utf-8">
<title>Безымянная страница</title>
<meta name="generator" content="WYSIWYG Web Builder 18 - https://www.wysiwygwebbuilder.com">
<link href="style/OnlineStore.css" rel="stylesheet">
<link href="style/InfoPayment.css" rel="stylesheet">
</head>
<body>


<div id="container">
<a id="Button1" href="./cart.jsp" style="position:absolute;left:900px;top:0px;width:100px;height:29px;z-index:0;">Корзина</a>
<img src="images/img0002.png" id="Banner1" alt="Online Store" style="border-width:0;position:absolute;left:0px;top:33px;width:1000px;height:70px;z-index:1;" width="1000" height="70">
<a id="Button2" href="./login.jsp" style="position:absolute;left:788px;top:0px;width:100px;height:29px;z-index:2;">Вход</a>
<nav id="wb_CssMenu2" style="position:absolute;left:0px;top:0px;width:336px;height:44px;z-index:3;">
<ul id="CssMenu2" role="menubar" class="nav">
<li role="menuitem" class="nav-item firstmain"><a class="nav-link" href="index.jsp" target="_self" title="Товары">Гланая</a>
</li>
<li role="menuitem" class="nav-item"><a class="nav-link" href="./InfoPayment.jsp" target="_self">Оплата</a>
</li>
<li role="menuitem" class="nav-item"><a class="nav-link" href="./InfoDelivery.jsp" target="_self">Доставка</a>
</li>
</ul>
</nav>
<div id="wb_Text1" style="position:absolute;left:335px;top:618px;width:330px;height:15px;z-index:4;">
<span style="color:#000000;font-family:Arial;font-size:16px;">Site created special for Java course Enterprise Edition</span></div>

<c:set var="userId"><c:out value='${sessionScope["userAuth"].getId()}' /></c:set>
 <c:if test="${userId != 0}">
            <script>
                  document.getElementById('Button2').text = "Кабинет";
                  document.getElementById('Button2').href = "./client.jsp";
              </script>
        </c:if>

<div id="wb_Form1" style="position:absolute;left:0px;top:109px;width:1000px;height:502px;z-index:7;">
<form name="Form1" method="post" action="mailto:yourname@yourdomain.com" enctype="multipart/form-data" id="Form1">
<div id="wb_Text2" style="position:absolute;left:9px;top:6px;width:991px;height:496px;z-index:5;">
<span style="color:#000000;font-family:Arial;font-size:21px;">Оплата</span><span style="color:#000000;font-family:Arial;font-size:16px;"><br>Мы позаботились о том, чтобы оплата покупки была доступна в той форме, которую предпочитаете лично вы.<br>Независимо от выбранной формы оплаты, расчет производится только в белорусских рублях.<br><br>Информация и персональные данные, которые мы получаем от Вас (включая, но не ограничиваясь: имя, фамилия, телефон, адрес электронной почты и т. д.) <br>надежно хранятся в нашей базе данных в соответствии с действующим законодательством и не подлежат распространению третьим лицам.<br>Банковские карты<br>Оплата банковской картой онлайн<br>К оплате принимаются карты Visa, MasterCard, Белкарт, МИР<br>Мы рекомендуем вам заранее обратиться в свой банк, чтобы удостовериться в том, что ваша карта может быть использована в системе Webpay.<br><br>При оформлении заказа на сайте выберите способ «Оплатить сейчас онлайн», далее выберите подходящий вариант:<br>— картой рассрочки;<br>— картой Visa, MasterCard или Белкарт;<br>— через систему «Расчет» (ЕРИП)<br><br>Введите данные для доставки и комментарий, нажмите кнопку «Подтвердить заказ».<br>Вы попадете на страницу подтверждения заказа, где будет указан его номер и сумма платежа. На этой странице нажмите кнопку «Оплатить счет».<br><br>После вы будете перенаправлены на сервер системы, обеспечивающей безопасность платежей, где вам потребуется ввести реквизиты своей карты <br>и персональные данные. Эти данные будут введены не на странице нашего онлайн-гипермаркета, а на авторизационной странице платежной системы. <br>Операция оплаты банковской картой онлайн полностью конфиденциальна и безопасна.<br><br>Для всех типов карт используется перенаправление в систему Webpay. Доступ к данным карты осуществляется по протоколу безопасной передачи данных <br>TLS,а для осуществления аутентификации держателя карточки используются методы Verified by Visa, MasterCard Securecode, MIR Accept, Белкарт <br>ИнтернетПароль.<br><br>После успешного проведения платежей данные Вашей карточки будут автоматически удалены из системы и не будут использованы для оплаты<br> последующих заказов на сайте <br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <br><br><br></span></div>
</form>
</div>
</div>
</body>
</html>