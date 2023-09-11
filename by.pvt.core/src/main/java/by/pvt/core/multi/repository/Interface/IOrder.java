package by.pvt.core.multi.repository.Interface;

import by.pvt.core.multi.domain.Order;
import by.pvt.core.multi.domain.Status;

import java.util.ArrayList;

public interface IOrder {

    Order addOrder(Order order);
    public ArrayList<Order> getOrdersList();

    Order searchCurrentOrder(long userID);

    ArrayList<Order> getAllUserOrders(long userId);

    void editStatusOrder(Order order, Status status, double cost);
}
