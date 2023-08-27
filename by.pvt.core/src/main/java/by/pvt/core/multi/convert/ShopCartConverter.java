package by.pvt.core.multi.convert;

import by.pvt.api.dto.ProductRequest;
import by.pvt.api.dto.ProductResponse;
import by.pvt.api.dto.ShopCartRequest;
import by.pvt.api.dto.ShopCartResponse;
import by.pvt.core.multi.domain.Product;
import by.pvt.core.multi.domain.ShopCart;

import java.security.cert.Extension;

public class ShopCartConverter
    {
    //из объекта в сущность
    public ShopCart cartToDTO(ShopCartRequest shopCartR) {
    ShopCart entity = new ShopCart();
    entity.setId(shopCartR.getId());
    entity.setProductId(shopCartR.getProductId());
    entity.setOrderId(shopCartR.getOrderId());
    entity.setCount(shopCartR.getCount());
    entity.setCost(shopCartR.getCost());
    return entity;
    }
    // из сущности в объект
    public ShopCartResponse cartToEntity(ShopCart shopCart) {
    ShopCartResponse dto = new ShopCartResponse();
    dto.setId(shopCart.getId());
    dto.setProductId(shopCart.getProductId());
    dto.setOrderId(shopCart.getOrderId());
    dto.setCount(shopCart.getCount());
    dto.setCost(shopCart.getCost());
    return dto;
    }
    }
