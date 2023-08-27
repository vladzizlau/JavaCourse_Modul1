package by.pvt.core.multi.service.Interface;

import by.pvt.api.dto.ShopCartRequest;

public interface IShopService {

    ShopCartRequest setShopCartRequest(long productid, int countProd, long userId);

    void addCart(ShopCartRequest scr);

    double getPriceProduct(long productID);

    String getNameProduct(long productID);
}
