package by.pvt.core.multi.service;

import by.pvt.core.multi.config.ApplicationContext;
import by.pvt.core.multi.domain.ShopCart;
import by.pvt.core.multi.service.Interface.ICart;

import java.util.ArrayList;

public class CartService implements ICart {
    @Override
    public long getlastIndexCart() //Получим последний id корзины
    {
        long index = getAllCart().size();
        if(index != 0)
        {
            index++;
        }
        else {
            index = 1;
        }
        return index;
    }

    @Override
    public ArrayList<ShopCart> getAllCartOrder(long orderid) //Возвращает все корзины по заказу
    {
        ArrayList<ShopCart> newlist = new ArrayList<>();
        for (ShopCart shopCart : getAllCart()) {
            if(shopCart.getOrderId() == orderid)
            {
                newlist.add(shopCart);
            }
        }
        return newlist;
    }

    @Override
    public ArrayList<ShopCart> getAllCart()
    {
        return ApplicationContext.getInstance().getShopRepository().getCartList();
    }
    @Override
public ArrayList<ShopCart> returnAllCartthisWork(long userID) //Возвращает все товары, добавленные в корзину для текущего пользователя
    {
    long orderID = ApplicationContext.getInstance().getOrderService().searchCurrentOrder(userID);
    return getAllCartOrder(orderID);
    }
    @Override
    public double finalCost (long orderid) { //Получаем полную стоимость заказа
        ArrayList<ShopCart> allShopCart = getAllCartOrder(orderid);
        double cost = allShopCart.stream().mapToDouble(s -> s.getCost()).sum();
        return cost;
    }
}
