package by.pvt.core.multi.repository.Interface;

import by.pvt.core.multi.domain.Order;
import by.pvt.core.multi.domain.ShopCart;

import java.util.ArrayList;

public interface IShop {


    // Сохраняет товар в файл
    void addOrder(ShopCart shopCart);
    void saveToFile(ShopCart shopCart);
    public ArrayList<ShopCart> getCartList();
}
