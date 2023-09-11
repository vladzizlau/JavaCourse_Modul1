package by.pvt.core.multi.service.Interface;

import by.pvt.core.multi.domain.Order;
import by.pvt.core.multi.domain.Status;

import java.util.ArrayList;

public interface IOrderService {

    long order(long userId);

    Order createOrder(long userId);

    void editOrderStatus(long userID, Status status);

    Order searchCurrentOrder(long userID);

    ArrayList<Order> getAllUserOrders(long userId);

    ArrayList<Order> getAllOrder();
}
