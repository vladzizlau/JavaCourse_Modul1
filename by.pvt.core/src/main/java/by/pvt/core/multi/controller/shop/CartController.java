package by.pvt.core.multi.controller.shop;

import by.pvt.api.dto.ShopCartRequest;
import by.pvt.api.dto.UserResponse;
import by.pvt.core.multi.config.ApplicationContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




// --- Контроллер всей корзины.
public class CartController extends HttpServlet
    {
    public void toCart(HttpServletRequest req, HttpServletResponse resp) //добавить в корзину
    {
    HttpServletRequest httpServletRequest = (HttpServletRequest) req;
    HttpSession httpSession = httpServletRequest.getSession(false);
    UserResponse userResponse = (UserResponse) httpSession.getAttribute("userAuth");
    long productId = Long.parseLong(req.getParameter("id"));
    int count = Integer.parseInt(req.getParameter("count"));
    System.out.println("id usera: " + userResponse.getId());
    System.out.println("id producta: " + productId);
    System.out.println("count: " + count);

    ShopCartRequest shopCartRequest = ApplicationContext.getInstance().getShopService().setShopCartRequest(productId, count, userResponse.getId());
    ApplicationContext.getInstance().getShopService().addCart(shopCartRequest);

    }

    public void doPayment(HttpServletRequest req, HttpServletResponse resp){ //Оплата и смена статуса заказа
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpSession httpSession = httpServletRequest.getSession(false);
        UserResponse userResponse = (UserResponse) httpSession.getAttribute("userAuth");
        long userid = userResponse.getId();
        String status = "Оплачено";
        ApplicationContext.getInstance().getOrderService().editOrder(userid, status);
    }


    }
