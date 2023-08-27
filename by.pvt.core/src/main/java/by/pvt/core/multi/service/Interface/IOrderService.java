package by.pvt.core.multi.service.Interface;

import by.pvt.core.multi.domain.Order;

import java.util.ArrayList;

public interface IOrderService {

    long order(long userId);

    long createOrder(long userId);

    void editOrder(long userID, String status);

    long searchCurrentOrder(long userID);

    ArrayList<Order> getAllUserOrders(long userId);

    ArrayList<Order> getAllOrder();
}
