package by.pvt.core.multi.service;

import by.pvt.api.dto.ShopCartRequest;
import by.pvt.core.multi.config.ApplicationContext;
import by.pvt.core.multi.domain.Product;
import by.pvt.core.multi.domain.ShopCart;
import by.pvt.core.multi.service.Interface.IShopService;

import java.util.ArrayList;

public class ShopService implements IShopService
    {
    public ShopCartRequest setShopCartRequest(long productid, int countProd, long userId)
        {
        long id = ApplicationContext.getInstance().getCartService().getlastIndexCart();
        double cost = getPriceProduct(productid) * countProd;
        long orderID = ApplicationContext.getInstance().getOrderService().order(userId);
        String name = getNameProduct(productid);
        ShopCartRequest request = new ShopCartRequest(id, name, productid, orderID, countProd, cost);
        return request;
        }

    public void addCart(ShopCartRequest scr) //В корзину
    {

    ShopCart shopCart = new ShopCart(scr.getId(), scr.getNameProduct(), scr.getProductId(), scr.getCount(), scr.getCost(), scr.getOrderId());
    ApplicationContext.getInstance().getShopRepository().addOrder(shopCart);
    System.out.println("Корзина создана: " + shopCart.getId() + " " + shopCart.getProductId() + " " + shopCart.getCount() + " " + shopCart.getCost() + " " + shopCart.getOrderId());
    }


    private double getPriceProduct(long productID)//получаем стоимость товара
        {
        return ApplicationContext.getInstance().getProductService().searchProduct(productID).getPrice();
        }

        private String getNameProduct(long productID) //Получим название товара
        {
            return ApplicationContext.getInstance().getProductService().searchProduct(productID).getNameProduct();
        }
    }
