package by.pvt.core.multi.convert;


import by.pvt.api.dto.ShopCartRequest;
import by.pvt.api.dto.ShopCartResponse;

import by.pvt.core.multi.domain.ShopCart;



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
