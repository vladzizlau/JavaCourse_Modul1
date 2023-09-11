package by.pvt.core.multi.repository.Interface;

import by.pvt.core.multi.domain.ShopCart;

import java.util.ArrayList;

public interface IShop {

    void addOrder(ShopCart shopCart);
    public ArrayList<ShopCart> getCartList();
}
