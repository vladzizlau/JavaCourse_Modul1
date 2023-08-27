package by.pvt.core.multi.domain;

import java.io.Serializable;

//Корзина твоаров
public class ShopCart implements Serializable {
    private long id;
    private long productId;
    private long orderId;
    private String nameProduct;
    private int count; //количество товара
    private double cost; //Будем считать стоимоть в одной корзине

    public ShopCart(long id, String nameProd, long productId,int count, double cost, long orderId) {
        this.id = id;
        this.nameProduct = nameProd;
        this.productId = productId;
        this.orderId = orderId;
        this.count = count;
        this.cost = cost;

    }

public ShopCart(){}

    public String getNameProduct() { return nameProduct;}

    public void setNameProduct(String nameProduct) { this.nameProduct = nameProduct; }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
