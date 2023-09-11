package by.pvt.core.multi.domain;

import java.io.Serializable;

// Заказ
public class Order implements Serializable {
   private long id;
   private long userId;
   private double cost; // общая стоимость
   private Status status ;//



   public Order(long id, long userId, double cost, Status status) {
      this.id = id;
      this.userId = userId;
      this.cost = cost;
      this.status = status;
   }

   public Order() {

   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public long getUserId() {
      return userId;
   }

   public void setUserId(long userId) {
      this.userId = userId;
   }

   public double getCost() {
      return cost;
   }

   public void setCost(double cost) {
      this.cost = cost;
   }

   public String getStatus() {
      return status.toString();
   }

   public void setStatus(Status status) {
      this.status = status;
   }
}
