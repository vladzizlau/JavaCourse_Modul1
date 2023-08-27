package by.pvt.api.dto;

public class ShopCartRequest {
    private long id;
    private long productId;
    private long orderId;
    private int count;
    private String nameProduct;
    private double cost;

    public ShopCartRequest(long id, String nameProduct, long productId, long orderId, int count, double cost) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.productId = productId;
        this.orderId = orderId;
        this.count = count;
        this.cost = cost;
    }

    public ShopCartRequest() {
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

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
