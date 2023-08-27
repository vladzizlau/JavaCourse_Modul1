package by.pvt.api.dto;

public class ShopCartResponse
    {
    private long id;
    private long productId;
    private long orderId;
    private int count;
    private double cost;

    public ShopCartResponse(long id, long productId, long orderId, int count, double cost)
        {
        this.id = id;
        this.productId = productId;
        this.orderId = orderId;
        this.count = count;
        this.cost = cost;
        }

    public ShopCartResponse(){}

    public long getId() {return id; }
    public void setId(long id){ this.id = id;}
    public long getProductId(){return productId;}
    public void setProductId(long productId) {this.productId = productId;}
    public long getOrderId(){return orderId; }
    public void setOrderId(long orderId){this.orderId = orderId;}
    public int getCount() {return count; }
    public void setCount(int count) {this.count = count;}
    public double getCost() { return cost; }
    public void setCost(double cost){this.cost = cost;}
    }
