package by.pvt.core.multi.service;

import by.pvt.core.multi.config.ApplicationContext;
import by.pvt.core.multi.domain.Order;
import by.pvt.core.multi.domain.ShopCart;
import by.pvt.core.multi.repository.DBShopRepository;
import by.pvt.core.multi.repository.ShopRepository;
import by.pvt.core.multi.service.Interface.ICart;

import java.util.ArrayList;

public class CartService implements ICart {
    private final DBShopRepository shopRepository;

    public CartService() {
        shopRepository = new DBShopRepository();
    }

    @Override
    public long getlastIndexCart() //Получим последний id корзины
    {
        long index = getAllCart().size();
        if (index != 0) {
            index++;
        } else {
            index = 1;
        }
        return index;
    }

    @Override
    public ArrayList<ShopCart> getAllCartOrder(long orderid) //Возвращает все корзины по заказу
    {
        ArrayList<ShopCart> newList = new ArrayList<>();
        for (ShopCart shopCart : getAllCart()) {
            if (shopCart.getOrderId() == orderid) {
                newList.add(shopCart);
            }
        }
        return newList;
    }

    @Override
    public ArrayList<ShopCart> getAllCart() {
        return shopRepository.getCartList();
    }

    @Override
    public ArrayList<ShopCart> returnAllCartthisWork(long userID) //Возвращает все товары, добавленные в корзину для текущего пользователя
    {
        Order order = ApplicationContext.getInstance().getOrderService().searchCurrentOrder(userID);
        return getAllCartOrder(order.getId());
    }

    @Override
    public double finalCost(long orderid) { //Получаем полную стоимость заказа
        ArrayList<ShopCart> allShopCart = getAllCartOrder(orderid);
        double cost = allShopCart.stream().mapToDouble(s -> s.getCost()).sum();
        return cost;
    }
}
