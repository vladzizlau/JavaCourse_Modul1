package by.pvt.core.multi.service.Interface;

import by.pvt.core.multi.domain.ShopCart;

import java.util.ArrayList;

public interface ICart {
    long getlastIndexCart() ;

    ArrayList<ShopCart> getAllCartOrder(long orderid);

    ArrayList<ShopCart> getAllCart();

    ArrayList<ShopCart> returnAllCartthisWork(long userID) ;

    double finalCost(long orderid);
}
